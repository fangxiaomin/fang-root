package com.fang.user.design.proxy.sub;

/**
 * @description:
 * @projectName:fang-root
 * @see:com.fang.user.design.proxy.sub
 * @author:fxm
 * @createTime:2021/8/30 11:13
 * @version:1.0
 */
public class Source implements Sourceable{
    @Override
    public void method() {
        System.out.println("the original method!");
    }
}
