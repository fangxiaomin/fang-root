package com.fang.user.design.Responsibility;

/**
 * @author:fxm  责任链模式
 * @createTime:2021/9/10 14:33
 */
public abstract class CRAbstractHandler {
    private CRHandler crHandler;

    public CRHandler getCrHandler() {
        return crHandler;
    }

    public void setCrHandler(CRHandler crHandler) {
        this.crHandler = crHandler;
    }
}
