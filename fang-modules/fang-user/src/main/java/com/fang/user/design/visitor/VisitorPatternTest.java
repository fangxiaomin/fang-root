package com.fang.user.design.visitor;

/**
 * @author:fxm
 * @createTime:2021/9/13 15:38
 */
public class VisitorPatternTest {
    public static void main(String[] args) {
        ComputerPart computerPart = new ComputerVisitor();
        computerPart.accept(new ComputerPartDisplayVisitor());
    }
}
