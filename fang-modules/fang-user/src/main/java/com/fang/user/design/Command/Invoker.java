package com.fang.user.design.Command;

/**
 * @author:fxm 是调用者。领导
 * @createTime:2021/9/10 16:00
 */
public class Invoker {
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void action(){
        command.exe();
    }
}
