package com.fang.user.design.mediator;

/**
 * @author:fxm
 * @createTime:2021/9/15 15:10
 */
public class User2 extends User{
    public User2(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void work() {
        System.out.println("user2 exe!");
    }
}
