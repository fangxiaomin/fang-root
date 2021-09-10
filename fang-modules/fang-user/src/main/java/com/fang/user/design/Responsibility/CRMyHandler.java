package com.fang.user.design.Responsibility;

/**
 * @author:fxm MyHandle类是核心，实例化后生成一系列相互持有的对象，构成一条链。
 * @createTime:2021/9/10 14:34
 */
public class CRMyHandler extends CRAbstractHandler implements CRHandler{

    private String name ;

    public CRMyHandler(String name) {
        this.name = name;
    }

    @Override
    public void operator() {
        System.out.println(name+"hello,责任链");
        if(getCrHandler() != null ){
            getCrHandler().operator();
        }

    }
}
