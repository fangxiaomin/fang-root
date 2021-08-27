package com.fang.user.design.adapter;

/**
 * @description:   对象的适配器模式
 * @version:1.0
 */
public class WrapperAdapter implements Targetable{

    private Source source;

    public WrapperAdapter(Source source) {
        this.source = source;
    }

    @Override
    public void doSomething() {
        System.out.println("this is the targetable method!");
    }

    @Override
    public void method2() {
        source.doSomething();
    }
}
