package com.fang.user.design.qiaojie;

/**
 * @description:  定义一个桥，持有Sourceable的一个实例：
 * @version:1.0
 */
public abstract class BridgeQ {
   private SourceableQ sourceableQ;

    public abstract void method1();

    public SourceableQ getSourceableQ() {
        return sourceableQ;
    }

    public void setSourceableQ(SourceableQ sourceableQ) {
        this.sourceableQ = sourceableQ;
    }
}
