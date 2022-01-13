package com.fang.user.JUC.cas;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @author:fxm
 * @createTime:2021/12/31 14:40
 */
public class AtomicIntegerArrayDemo {
    public static void main(String[] args) {
//        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(new int[5]);
//        AtomicIntegerArray atomicIntegerArray1 = new AtomicIntegerArray(5);
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(new int[]{1,2,3,4,5});
        for (int i = 0; i < atomicIntegerArray.length(); i++) {
            System.out.println(atomicIntegerArray.get(i));
        }

        int temInt = 0 ;
        temInt = atomicIntegerArray.getAndSet(0,1122);
        System.out.println(temInt+"\t" + atomicIntegerArray.get(0));

        atomicIntegerArray.getAndIncrement(1);
        atomicIntegerArray.getAndIncrement(1);
        temInt = atomicIntegerArray.getAndIncrement(1);
        System.out.println(temInt +"\t" +atomicIntegerArray.get(1));


    }
}
