package com.fang.user.redis.lock;

/**
 * @author:fxm
 * @createTime:2021/9/23 16:30
 */
public abstract class AbstractDistributedLock implements DistributedLock{
    @Override
    public boolean lock(String key) {
        return lock(key, TIMEOUT_MILLIS, RETRY_TIMES, SLEEP_MILLIS);
    }

    @Override
    public boolean lock(String key, int retryTimes) {
        return lock(key, TIMEOUT_MILLIS, retryTimes, SLEEP_MILLIS);
    }

    @Override
    public boolean lock(String key, int retryTimes, long sleepMillis) {
        return lock(key, TIMEOUT_MILLIS, retryTimes, sleepMillis);
    }

    @Override
    public boolean lock(String key, long expire) {
        return lock(key, expire, RETRY_TIMES, SLEEP_MILLIS);
    }

    @Override
    public boolean lock(String key, long expire, int retryTimes) {
        return lock(key, expire, retryTimes, SLEEP_MILLIS);
    }

    @Override
    public boolean getLock(String key){
        return getLock(key, RETRY_TIMES, SLEEP_MILLIS);
    }
    @Override
    public boolean getLock(String key, int retryTimes){
        return getLock(key, retryTimes, SLEEP_MILLIS);
    }

}
