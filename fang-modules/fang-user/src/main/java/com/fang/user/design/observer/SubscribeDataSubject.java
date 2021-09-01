package com.fang.user.design.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:fxm  主题订阅类，负责给观察者发送消息
 * @createTime:2021/9/1 14:39
 */
public class SubscribeDataSubject implements SubjectData{

    //存储观察者
    private List<ObserverData> observers = new ArrayList<ObserverData>();


    @Override
    public void attach(ObserverData observerData) {
        observers.add(observerData);
    }

    @Override
    public void detach(ObserverData observerData) {
        observers.remove(observerData);
    }

    @Override
    public void notifyObservers(String message) throws Exception {
        for (ObserverData observer : observers) {
            observer.processData(message);
        }
    }

    @Override
    public void operation() {

    }
}
