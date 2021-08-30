package com.fang.user.design.adapter.sub;

import com.fang.user.design.adapter.sub.Sourceable;

/**
 * @description:   抽象类Wrapper2：  实现接口里面的部分 方法  选择性
 *
 * 有时我们写的一个接口中有多个抽象方法，
 * 当我们写该接口的实现类时，必须实现该接口的所有方法，这明显有时比较浪费
 */
public abstract class Wrapper2 implements Sourceable {

    @Override
    public void method1(){};
    @Override
    public void method2(){};
    @Override
    public void method3(){};
    @Override
    public void method4(){};
    @Override
    public void method5(){};


}
