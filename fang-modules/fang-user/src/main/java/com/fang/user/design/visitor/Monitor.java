package com.fang.user.design.visitor;

/**
 * @author:fxm
 * @createTime:2021/9/13 15:27
 */
public class Monitor implements ComputerPart{
    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
