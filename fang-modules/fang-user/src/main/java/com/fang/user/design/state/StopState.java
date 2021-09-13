package com.fang.user.design.state;

/**
 * @author:fxm
 * @createTime:2021/9/13 14:17
 */
public class StopState implements State{
    @Override
    public void doAction(Context context) {
        System.out.println("Player is in stop state");
        context.setState(this);
    }

    @Override
    public String toString() {
        return "StopState{}";
    }
}
