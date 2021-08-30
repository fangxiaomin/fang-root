package com.fang.user.design.Facade;

/**
 * @description:
 * @projectName:fang-root
 * @see:com.fang.user.design.Facade
 * @author:fxm
 * @createTime:2021/8/30 14:19
 * @version:1.0
 */
public class Disk {
    public void startup(){
        System.out.println("cpu startup!");
    }

    public void shutdown(){
        System.out.println("cpu shutdown!");
    }
}
