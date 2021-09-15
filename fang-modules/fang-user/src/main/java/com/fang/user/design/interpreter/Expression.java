package com.fang.user.design.interpreter;

/**
 * @author:fxm
 * @createTime:2021/9/15 15:52
 */
public interface Expression {
    boolean interpret(String context);
}
