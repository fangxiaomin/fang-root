package com.fang.user.design.visitor;

/**
 * @author:fxm 需要访问的类
 * @createTime:2021/9/13 15:26
 */
public interface ComputerPart {
    void accept(ComputerPartVisitor computerPartVisitor);
}
