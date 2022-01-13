package com.fang.user.redis.lock;

/**
 * @author:fxm
 * @createTime:2021/9/23 16:24
 */
public interface DistributedLock {
    /**
     * 默认超时时间
     */
    long TIMEOUT_MILLIS = 3000L;

    int RETRY_TIMES = 2;

    long SLEEP_MILLIS = 100L;
    /**
     * 获取锁
     *
     * @param key key
     * @return 成功/失败
     */
    boolean lock(String key);

    /**
     * 获取锁
     *
     * @param key        key
     * @param retryTimes 重试次数
     * @return 成功/失败
     */
    boolean lock(String key, int retryTimes);

    /**
     * 获取锁
     *
     * @param key         key
     * @param retryTimes  重试次数
     * @param sleepMillis 获取锁失败的重试间隔
     * @return 成功/失败
     */
    boolean lock(String key, int retryTimes, long sleepMillis);

    /**
     * 获取锁
     *
     * @param key    key
     * @param expire 获取锁超时时间
     * @return 成功/失败
     */
    boolean lock(String key, long expire);

    /**
     * 获取锁
     *
     * @param key        key
     * @param expire     获取锁超时时间
     * @param retryTimes 重试次数
     * @return 成功/失败
     */
    boolean lock(String key, long expire, int retryTimes);

    /**
     * 获取锁
     *
     * @param key         key
     * @param expire      获取锁超时时间
     * @param retryTimes  重试次数
     * @param sleepMillis 获取锁失败的重试间隔
     * @return 成功/失败
     */
    boolean lock(String key, long expire, int retryTimes, long sleepMillis);

    /**
     * 释放锁
     *
     * @param key key值
     * @return 释放结果
     */
    boolean releaseLock(String key);

    /**
     * 查询锁是否存在
     * @param key
     * @return true 不存在
     */
    boolean getLock(String key);

    /**
     * 查询锁是否存在
     * @param key        key
     * @param retryTimes 重试次数
     * @return true 不存在
     */
    boolean getLock(String key, int retryTimes);

    boolean getLock(String key, int retryTimes, long sleepMillis);
}
