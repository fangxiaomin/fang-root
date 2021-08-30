package com.fang.user.design.adapter;

import com.fang.user.design.adapter.sub.SourceSub1;
import com.fang.user.design.adapter.sub.SourceSub2;
import com.fang.user.design.adapter.sub.Sourceable;

/**
 * @description:
 */
public class AdapterTest {

    public static void main(String[] args) {
        //  通过适配器   Targetable   就可以去调用 原角色的 方法。具备了Source类的功能。
        Targetable targetable= new Adapter();
        targetable.doSomething();
        targetable.method2();

        //  对象的适配器模式
        Targetable targetable2= new WrapperAdapter(new Source());
        targetable2.doSomething();
        targetable2.method2();

        //接口的适配器模式
        Sourceable source1 = new SourceSub1();
        Sourceable source2 = new SourceSub2();
        source1.method1();
        source1.method2();
//        source2.method1();
//        source2.method2();

    }
}
