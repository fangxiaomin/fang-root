package com.fang.user.design.adapter;

/**
 * @description: 类的适配器模式  适配器 ----将 源 角色里面的方法适配到 目标类中，使目标拥有 原角色的  方法
 * Adapter类继承Source类，实现Targetable接口
 */
public class Adapter extends Source implements Targetable{

    @Override
    public void method2() {
        System.out.println("this is the targetable method!");
    }
}
