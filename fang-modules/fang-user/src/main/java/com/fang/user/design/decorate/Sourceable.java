package com.fang.user.design.decorate;

/**
 * @description:
 * @projectName:fang-root
 * @see:com.fang.user.design.decorate
 * @author:fxm
 * @createTime:2021/8/27 16:22
 * @version:1.0
 */
public interface  Sourceable {
    public void method();
}

//被装饰类，
class Source implements Sourceable {

    @Override
    public void method() {
        System.out.println("the original method!");
    }
}
//Decorator类是一个装饰类.  在method 前后可以动态添加功能
 class Decorator implements Sourceable {
    private Sourceable source;

    public Decorator(Sourceable source){
        super();
        this.source = source;
    }
    @Override
    public void method() {
        //动态添加  功能
        System.out.println("before decorator!");
        source.method();
        //动态添加  功能
        System.out.println("after decorator!");
    }
}

 class DecoratorTest {
    public static void main(String[] args) {
        Sourceable source = new Source();
        Sourceable obj = new Decorator(source);
        obj.method();
    }
}
