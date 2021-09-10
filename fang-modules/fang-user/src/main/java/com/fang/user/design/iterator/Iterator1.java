package com.fang.user.design.iterator;

/**
 * @author:fxm 创建一个叙述导航方法的 Iterator 接口
 * @createTime:2021/9/3 16:03
 */
public interface Iterator1 {

    //前移
    public Object previous();

    //后移
    public Object next();
    public boolean hasNext();

    //取得第一个元素
    public Object first();
}
