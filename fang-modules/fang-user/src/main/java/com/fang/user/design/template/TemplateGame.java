package com.fang.user.design.template;

/**
 * @description:  模板模式。。。模板基类
 * @projectName:fang-root
 * @version:1.0
 */
public abstract class TemplateGame {

    /*被子类重写的方法*/
    public abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();

    /*模板方法，实现对本类其它方法的调用*/
    public final void play(){
        //初始化游戏
        initialize();

        //开始游戏
        startPlay();

        //结束游戏
        endPlay();
    }
}
