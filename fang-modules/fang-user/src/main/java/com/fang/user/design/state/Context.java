package com.fang.user.design.state;

/**
 * @author:fxm   状态模式的切换类
 * @createTime:2021/9/13 14:15
 */
public class Context {

    private State state;

    public Context(State state) {
        this.state = state;
    }

    public Context() {
        state =null ;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
