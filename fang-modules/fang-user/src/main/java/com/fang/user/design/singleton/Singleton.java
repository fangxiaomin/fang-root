package com.fang.user.design.singleton;

/**
 * @description:  双重校验锁  实现单例
 * @createTime:2021/8/26 10:28
 * @version:1.0
 */
public class Singleton {

    /* 持有私有静态实例，防止被引用，此处赋值为null，目的是实现延迟加载 */
    private static Singleton instance = null;

    /* 私有构造方法，防止被实例化 */
    public Singleton() {
    }

    /*双重校验锁-线程安全  实现单例模式*/
    public static Singleton getInstance(){
        if( instance  == null ){
            synchronized (Singleton.class){
                if( instance  == null ){
                    instance = new Singleton();    //这句是分两步进行的  对象的初始化需要时间
                    /*JVM中创建对象和赋值操作是分开进行的...JVM会先给Singleton实例分配一个空白内存，并赋值给instance成员
                      但是jvm 并没有开始初始化这个实例，然后再去new一个Singleton对象赋给instance。

                      A B 2个线程来了，A线程进入synchronized,执行new Singleton(); 进行了赋值，但是不一定真正初始化了（需要时间）。
                      B线程来了，发现instance不是null，立马返回该instance（其实是没有初始化好的），然后B就开始使用该instance，却发现没初始化，于是就出问题了。
                    */
                }
            }
        }
        return instance;
    }


}
