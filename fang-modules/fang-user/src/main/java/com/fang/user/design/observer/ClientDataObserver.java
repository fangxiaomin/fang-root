package com.fang.user.design.observer;

/**
 * @author:fxm  订阅者添加  观察者操作类
 * @createTime:2021/9/1 14:44
 */
public class ClientDataObserver extends SubscribeDataSubject{

    private static SubjectData subject = null ;

    static {
        subject = new SubscribeDataSubject();
        /**添加观察者*/
        subject.attach(new Observer1());
        subject.attach(new Observer2());
        subject.attach(new Observer3());
    }

    public static synchronized void send(String message) throws Exception {
        subject.notifyObservers(message);
    }

}
