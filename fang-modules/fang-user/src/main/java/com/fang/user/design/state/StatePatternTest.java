package com.fang.user.design.state;

/**
 * @author:fxm  状态模式
 * @createTime:2021/9/13 14:18
 */
public class StatePatternTest {
    public static void main(String[] args) {
        Context context = new Context();
        StartState startState = new StartState();
        startState.doAction(context);
        System.out.println(context.getState().toString());
        System.out.println();
        StopState stopState = new StopState();
        stopState.doAction(context);
        System.out.println(context.getState().toString());
    }
}
