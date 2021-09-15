package com.fang.user.design.mediator;

/**
 * @author:fxm
 * @createTime:2021/9/15 15:09
 */
public class User1 extends User{

    public User1(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void work() {
        System.out.println("user1 exe!");

    }
}
