package com.fang.user.redis.lock;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.connection.ReturnType;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.types.Expiration;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author:fxm redis分布式锁实现
 * @createTime:2021/9/23 16:33
 */
@Slf4j
public class RedisDistributedLock extends AbstractDistributedLock {

    private StringRedisTemplate redisTemplate;
    private ThreadLocal<String> lockFlag = new ThreadLocal<>();
    private static final String UNLOCK_LUA;

    /*
     * 通过lua脚本释放锁,来达到释放锁的原子操作
     */
    static {
        UNLOCK_LUA = "if redis.call(\"get\",KEYS[1]) == ARGV[1] " +
                "then " +
                "    return redis.call(\"del\",KEYS[1]) " +
                "else " +
                "    return 0 " +
                "end ";
    }

    public RedisDistributedLock(StringRedisTemplate redisTemplate) {
        super();
        this.redisTemplate = redisTemplate;
    }


    @Override
    public boolean lock(String key, long expire, int retryTimes, long sleepMillis) {
        boolean result = setRedis(key, expire);
        // 如果获取锁失败，按照传入的重试次数进行重试
        while ((!result) && retryTimes-- > 0) {
            try {
                log.info("get redisDistributeLock failed, retrying..." + retryTimes);
                Thread.sleep(sleepMillis);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return false;
            }
            result = setRedis(key, expire);
        }
        return result;
    }

    private boolean setRedis(final String key, final long expire) {
        try {
            Boolean result = redisTemplate.execute((RedisCallback<Boolean>) connection -> {
                String uuid = UUID.randomUUID().toString();
                lockFlag.set(uuid);
                Boolean flag = connection.set(key.getBytes(StandardCharsets.UTF_8),
                        uuid.getBytes(StandardCharsets.UTF_8),
                        Expiration.seconds(TimeUnit.MICROSECONDS.toSeconds(expire)),
                        RedisStringCommands.SetOption.SET_IF_ABSENT);
                return flag;
            });
            return result == null ? false : result;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("set redisDistributeLock occured an exception", e);
        }
        return false;
    }


    @Override
    public boolean releaseLock(String key) {
        try {
            final List<String> keys = new ArrayList<>();
            keys.add(key);
            final List<String> args = new ArrayList<>();
            args.add(lockFlag.get());

            Boolean result = redisTemplate.execute((RedisCallback<Boolean>) connection -> {
                return connection.eval(UNLOCK_LUA.getBytes(),
                        ReturnType.BOOLEAN, 1, key.getBytes(StandardCharsets.UTF_8),
                        lockFlag.get().getBytes(StandardCharsets.UTF_8));
            });
            log.info("release redisDistributeLock success");
            return result == null ? false : result;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("release redisDistributeLock occured an exception", e);
        } finally {
            lockFlag.remove();
        }
        return false;
    }

    @Override
    public boolean getLock(String key, int retryTimes, long sleepMillis) {
        return false;
    }
}
