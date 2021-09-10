package com.fang.user.design.iterator;

import java.awt.*;

/**
 * @author:fxm
 * @createTime:2021/9/3 16:05
 */
public class NameRepository implements Container{
    public String names[] = {"3", "1", "6", "4","7","2","5"};
    @Override
    public Iterator1 getIterator() {
        return new NameIterator();
    }

    //实现了 Iterator 接口的内部类 NameIterator。  也可以拿出去，写一个单独的类
    private class NameIterator implements Iterator1{
        private int index ;
        @Override
        public Object previous() {
            if(index > 0){
                index--;
            }
            return names[index];
        }

        @Override
        public Object next() {
            if(hasNext()){
                return names[index++];
            }
            return null;
        }

        @Override
        public boolean hasNext() {
            if(index < names.length){
                return true;
            }
            return false;
        }

        @Override
        public Object first() {
            index = 0;
            return names[index];
        }
    }
}
