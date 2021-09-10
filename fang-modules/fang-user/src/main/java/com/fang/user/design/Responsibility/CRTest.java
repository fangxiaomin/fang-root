package com.fang.user.design.Responsibility;

/**
 * @author:fxm
 * @createTime:2021/9/10 14:37
 */
public class CRTest {
    public static void main(String[] args) {
        CRMyHandler crMyHandler = new CRMyHandler("test1");
        CRMyHandler crMyHandler2 = new CRMyHandler("test2");
        CRMyHandler crMyHandler3 = new CRMyHandler("test3");
        crMyHandler.setCrHandler(crMyHandler2);
        crMyHandler2.setCrHandler(crMyHandler3);
        crMyHandler.operator();
    }
}
