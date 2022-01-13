package com.fang.user.JUC.sync;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author:fxm
 * @createTime:2022/1/6 14:11
 */
public class MyObject {
    public static void main(String[] args) {
    }

    private static void noLock() {
        Object o = new Object();
        System.out.println(o.hashCode());
        System.out.println(Integer.toHexString(o.hashCode())); // 16进制
        System.out.println(Integer.toBinaryString(o.hashCode()));// 2进制

        System.out.println(ClassLayout.parseInstance(0).toPrintable());
    }
}
