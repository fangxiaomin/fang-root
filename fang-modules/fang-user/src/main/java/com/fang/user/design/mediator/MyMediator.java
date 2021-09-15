package com.fang.user.design.mediator;

/**
 * @author:fxm 实现类，里面持有User1和User2的实例，用来实现对User1和User2的控制.这样User1和User2两个对象相互独立，他们只需要保持好和Mediator之间的关系就行
 * @createTime:2021/9/15 15:07
 */
public class MyMediator implements Mediator{

    private User user1;
    private User user2;

    public User getUser1() {
        return user1;
    }

    public User getUser2() {
        return user2;
    }

    @Override
    public void createMediator() {
        user1 = new User1(this);
        user2 = new User2(this);
    }

    @Override
    public void workAll() {
        user1.work();
        user2.work();

    }
}
