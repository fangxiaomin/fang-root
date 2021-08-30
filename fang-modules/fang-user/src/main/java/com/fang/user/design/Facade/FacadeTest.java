package com.fang.user.design.Facade;

/**
 * @description:
 * @projectName:fang-root
 * @see:com.fang.user.design.Facade
 * @author:fxm
 * @createTime:2021/8/30 14:37
 * @version:1.0
 */
public class FacadeTest {

    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.startup();
        computer.shutdown();
    }
}
