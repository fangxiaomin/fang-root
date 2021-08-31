package com.fang.user.design.strategy;

/**
 * @description:
 * @projectName:fang-root
 * @see:com.fang.user.design.strategy
 * @author:fxm
 * @createTime:2021/8/31 17:38
 * @version:1.0
 */
public class StrategrTest {
    public static void main(String[] args) {
        Context context = new Context(new OperationAdd());
        System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

        context = new Context(new OperationSubstract());
        System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

        context = new Context(new OperationMultiply());
        System.out.println("10 * 5 = " + context.executeStrategy(10, 5));

    }
}
