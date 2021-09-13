package com.fang.user.design.memento;

/**
 * @author:fxm  备忘录 类
 * @createTime:2021/9/13 13:40
 */
public class Memento {

    private String value ;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Memento(String value) {
        this.value = value;
    }
}
