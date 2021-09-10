package com.fang.user.design.Responsibility.sub;

/**
 * @author:fxm
 * @createTime:2021/9/10 15:22
 */
public class ErrorLogger extends AbstractLogger{

    public ErrorLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error Console::Logger: " + message);
    }
}
