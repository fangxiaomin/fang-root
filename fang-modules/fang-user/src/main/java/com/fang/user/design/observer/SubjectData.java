package com.fang.user.design.observer;

/**
 * 订阅的主题类
 *
 * @author:fxm
 * @createTime:2021/9/1 14:34
 */
public interface SubjectData {

    /**
     * @Description:增加订阅者
     *
     **/
    void attach(ObserverData observerData);

    /**
     * @Description: 删除订阅者
     * 
     **/
    void detach(ObserverData observerData);

    /**
     * @Description:知订阅者更新消息
     *
     **/
    void notifyObservers(String message) throws Exception;

    /**
     * @Description: 自身的操作
     *
     **/
    void operation();
}
