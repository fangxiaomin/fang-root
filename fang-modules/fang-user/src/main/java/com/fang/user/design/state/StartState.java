package com.fang.user.design.state;

/**
 * @author:fxm
 * @createTime:2021/9/13 14:16
 */
public class StartState implements State{
    @Override
    public void doAction(Context context) {
        System.out.println("Player is in start state");
        context.setState(this);
    }

    @Override
    public String toString() {
        return "StartState{}";
    }
}
