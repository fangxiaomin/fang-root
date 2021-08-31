package com.fang.user.design.strategy;

/**
 * @description:
 * @projectName:fang-root
 * @see:com.fang.user.design.strategy
 * @author:fxm
 * @createTime:2021/8/31 17:35
 * @version:1.0
 */
public class OperationSubstract implements Strategy{
    @Override
    public int doOperation(int num1, int num2) {
        return num1-num2;
    }
}
