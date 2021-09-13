package com.fang.user.design.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:fxm 存储备忘录的类  拥有备忘录类实例
 * @createTime:2021/9/13 13:44
 */
public class Storage {

    private List<Memento> mementoList = new ArrayList<>();

    public void add(Memento memento){
        mementoList.add(memento);
    }

   public Memento get(int index){
        return mementoList.get(index);
   }
}
