package com.fang.user.design.memento;

/**
 * @author:fxm  原始类
 * @createTime:2021/9/13 13:41
 */
public class Original {

    private  String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    public Memento createMemento(){
        return new Memento(value);

    }

    public void restoreMemento(Memento memento){
        value = memento.getValue();

    }
}
