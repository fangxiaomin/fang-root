package com.fang.user.design.singleton;

/**
 * @description: 使用内部类 实现  单例模式。可以解决  双重校验 未初始化的问题
 * <p>
 * 单例模式使用内部类来维护单例的实现，JVM内部的机制能够保证当一个类被加载的时候，
 * 这个类的加载过程是线程互斥的。这样，当我们第一次调用getInstance()方法的时候，
 * JVM能够帮我们保证instance实例只被创建一次，并且会保证把赋值给instance的内存初始化完毕
 */
public class Singleton2 {

    /* 私有构造方法，防止被实例化 */
    public Singleton2() {
    }

    private static class SingletonFactory {
        private static Singleton2 instance2 = new Singleton2();
    }

    /* 获取实例   线程互斥，当多个线程加载的时候，只有第一个进入的线程才会创建对象*/
    public static Singleton2 getInstance() {
        return SingletonFactory.instance2;
    }


    /* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */
    public Object readResolve() {
        return getInstance();
    }

}
