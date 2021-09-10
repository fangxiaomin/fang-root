package com.fang.user.design.Responsibility.sub;

/**
 * @author:fxm
 * @createTime:2021/9/10 15:19
 */
public class ConsoleLogger extends AbstractLogger{

    public ConsoleLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standard Console::Logger: " + message);
    }
}
