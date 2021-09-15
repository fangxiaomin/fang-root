package com.fang.user.design.interpreter;

/**
 * @author:fxm
 * @createTime:2021/9/15 15:52
 */
public class TerminalExpression implements Expression{

    private String data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        if (context.contains(data)) {
            return true;
        }
        return false;
    }
}
