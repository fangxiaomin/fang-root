package com.fang.user.design.visitor;


/**
 * @author:fxm  类的实体访问者。
 * @createTime:2021/9/13 15:33
 */
public class ComputerPartDisplayVisitor implements ComputerPartVisitor{
    @Override
    public void visit(ComputerVisitor computer) {
        System.out.println("Displaying Computer.");
    }

    @Override
    public void visit(Mouse mouse) {
        System.out.println("Displaying Mouse.");
    }

    @Override
    public void visit(Keyboard keyboard) {
        System.out.println("Displaying Keyboard.");
    }

    @Override
    public void visit(Monitor monitor) {
        System.out.println("Displaying Monitor.");
    }
}
