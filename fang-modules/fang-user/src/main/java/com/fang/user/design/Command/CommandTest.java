package com.fang.user.design.Command;

/**
 * @author:fxm
 * @createTime:2021/9/10 16:01
 */
public class CommandTest {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Command command = new MyCommand(receiver);
        Invoker invoker = new Invoker(command);
        invoker.action();
    }
}
