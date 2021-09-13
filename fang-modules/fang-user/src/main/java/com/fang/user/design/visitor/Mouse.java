package com.fang.user.design.visitor;

/**
 * @author:fxm
 * @createTime:2021/9/13 15:28
 */
public class Mouse implements ComputerPart{
    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
