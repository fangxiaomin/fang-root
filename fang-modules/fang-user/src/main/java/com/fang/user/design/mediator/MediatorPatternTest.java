package com.fang.user.design.mediator;

/**
 * @author:fxm
 * @createTime:2021/9/15 15:12
 */
public class MediatorPatternTest {
    public static void main(String[] args) {
        Mediator mediator = new MyMediator();
        mediator.createMediator();
        mediator.workAll();
    }
}
