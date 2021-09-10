package com.fang.user.design.Command;

/**
 * @author:fxm  具体命令
 * @createTime:2021/9/10 15:57
 */
public class MyCommand implements Command{

    private Receiver receiver;

    public MyCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void exe() {
        receiver.action();
    }
}
