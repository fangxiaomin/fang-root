package com.fang.user.design.mediator;

/**
 * @author:fxm User类统一接口
 * @createTime:2021/9/15 15:08
 */
public abstract class User {
    private Mediator mediator;

    public User(Mediator mediator) {
        this.mediator = mediator;
    }

    public Mediator getMediator() {
        return mediator;
    }
    public abstract void work();
}
