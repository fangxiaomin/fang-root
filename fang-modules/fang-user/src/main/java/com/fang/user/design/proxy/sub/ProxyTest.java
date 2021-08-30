package com.fang.user.design.proxy.sub;

/**
 * @description:
 * @projectName:fang-root
 * @see:com.fang.user.design.proxy.sub
 * @author:fxm
 * @createTime:2021/8/30 11:16
 * @version:1.0
 */
public class ProxyTest {
    public static void main(String[] args) {
        Sourceable proxy = new Proxy();
        proxy.method();
    }
}
