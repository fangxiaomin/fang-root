
package com.fang.user.JUC.threadLoacl;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

/**
 * @author:fxm
 * @createTime:2022/1/5 14:01
 */

class MyObject{

    @Override
    protected void finalize() throws Throwable {
        System.out.println("--------------gc ,finalize() invoke ");
    }


}

public class ReferenceDemo {
    public static void main(String[] args) {
        WeakReference<MyObject> weakReference = new WeakReference<>(new MyObject());
        System.out.println("----gc before :" + weakReference.get());
        System.gc();  //  手动挡的方式开启gc回收
        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println("----gc after :" + weakReference.get());

    }


    //软引用
    private static void softReference() {
        SoftReference<MyObject> softReference = new SoftReference<>(new MyObject());
        System.out.println("----gc before 内存够用:" + softReference);

        System.gc();  //  手动挡的方式开启gc回收
        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println("----gc after 内存够用:" + softReference);
    }

    //强引用
    private static void strongReference() {
        MyObject myObject = new MyObject();   // m默认，强引用，死了都不放手
        System.out.println("----gc before :" + myObject);

        myObject = null ;
        System.gc();  //  手动挡的方式开启gc回收
        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println("----gc after :" + myObject);
    }
}
