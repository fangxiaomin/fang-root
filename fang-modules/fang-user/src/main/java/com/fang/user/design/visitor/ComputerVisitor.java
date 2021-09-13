package com.fang.user.design.visitor;

/**
 * @author:fxm
 * @createTime:2021/9/13 15:28
 */
public class ComputerVisitor implements ComputerPart{
    ComputerPart[] parts;

    public ComputerVisitor() {
        parts = new ComputerPart[] {new Mouse(), new Keyboard(), new Monitor()};
    }

    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        for (int i = 0; i < parts.length; i++) {
            parts[i].accept(computerPartVisitor);
        }
        computerPartVisitor.visit(this);
    }
}
