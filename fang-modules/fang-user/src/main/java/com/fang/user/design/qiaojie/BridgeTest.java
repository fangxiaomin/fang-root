package com.fang.user.design.qiaojie;

/**
 * @description:
 * @projectName:fang-root
 * @see:com.fang.user.design.qiaojie
 * @author:fxm
 * @createTime:2021/8/30 17:43
 * @version:1.0
 */
public class BridgeTest {
    public static void main(String[] args) {

        BridgeQ bridgeQ = new MyBridge();

        /*调用第一个对象*/
        SourceableQ sourceableQ1 = new SourceSubQ1();
        bridgeQ.setSourceableQ(sourceableQ1);
        bridgeQ.method1();

        /*调用第二个对象*/
        SourceableQ sourceableQ2 = new SourceSubQ2();
        bridgeQ.setSourceableQ(sourceableQ2);
        bridgeQ.method1();
    }
}
