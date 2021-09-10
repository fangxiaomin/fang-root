package com.fang.user.design.Command.sub;

/**
 * @author:fxm
 * @createTime:2021/9/10 16:09
 */
public class CommandStock {
    private String name = "ABC";
    private int quantity = 10;
    public void buy() {
        System.out.println("Stock [ Name: " + name + ", Quantity:" + quantity + " ]bought ");
    }

    public void sell() {
        System.out.println("Stock [ Name: " + name + ", Quantity:" + quantity + " ]sold ");
    }
}
