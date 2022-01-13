package com.fang.user.JUC.locks;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author:fxm
 * @createTime:2022/1/11 17:04
 */
public class LockDownGradingDemo {
    public static void main(String[] args) {
        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();

        //  有且只有一个线程main  验证锁降级策略要求
        writeLock.lock();
        System.out.println("111111111");
        readLock.lock();
        System.out.println("----read");


        writeLock.unlock();
        readLock.unlock();
    }
}
