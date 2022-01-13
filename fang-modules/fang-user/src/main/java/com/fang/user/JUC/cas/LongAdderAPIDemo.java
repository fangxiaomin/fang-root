package com.fang.user.JUC.cas;

import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.LongBinaryOperator;

/**
 * @author:fxm
 * @createTime:2021/12/31 16:38
 */
public class LongAdderAPIDemo {
    public static void main(String[] args) {
        LongAdder longAdder = new LongAdder();  //  只能做加法
        longAdder.increment();
        longAdder.increment();
        longAdder.increment();
        System.out.println( longAdder.longValue());


        LongAccumulator longAccumulator = new LongAccumulator(new LongBinaryOperator() {
            @Override
            public long applyAsLong(long left, long right) {
                return left - right ;   //  可以自己选择  加法 还是 减法
            }
        },100);   //初始值
        longAccumulator.accumulate(1);
        longAccumulator.accumulate(3);
        longAccumulator.accumulate(5);

        System.out.println(longAccumulator.longValue());

    }
}
