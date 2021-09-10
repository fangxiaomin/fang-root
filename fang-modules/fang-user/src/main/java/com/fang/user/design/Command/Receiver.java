package com.fang.user.design.Command;

/**
 * @author:fxm  命令接受者，去执行具体的命令
 * @createTime:2021/9/10 15:57
 */
public class Receiver {
    public void action(){
        System.out.println("command received!");
    }
}
