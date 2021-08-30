package com.fang.user.design.proxy.sub;

import javax.swing.*;

/**
 * @description:  即客户端通过代理间接地访问该对象，从而限制、增强或修改该对象的一些特性
 * @version:1.0
 */
public class Proxy implements Sourceable{
    private Source  source;

    public Proxy() {
        super();
        this.source = new Source();
    }

    @Override
    public void method() {
        before();
        source.method();
        atfer();

    }

    private void atfer() {
        System.out.println("after proxy!");
    }
    private void before() {
        System.out.println("before proxy!");
    }
}
