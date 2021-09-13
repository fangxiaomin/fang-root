package com.fang.user.design.visitor;


/**
 * @author:fxm  表示访问者的接口。
 * @createTime:2021/9/13 15:24
 */
public interface ComputerPartVisitor {
    void visit(ComputerVisitor computer);

    void visit(Mouse mouse);

    void visit(Keyboard keyboard);

    void visit(Monitor monitor);
}
