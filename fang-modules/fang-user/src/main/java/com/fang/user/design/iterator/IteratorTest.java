package com.fang.user.design.iterator;

/**
 * @author:fxm
 * @createTime:2021/9/3 16:11
 */
public class IteratorTest {
    public static void main(String[] args) {
        NameRepository nameRepository = new NameRepository();
        Iterator1 iter = nameRepository.getIterator();
        while (iter.hasNext()){
            String  name = (String) iter.next();
            System.out.println(name);
        }
    }
}
