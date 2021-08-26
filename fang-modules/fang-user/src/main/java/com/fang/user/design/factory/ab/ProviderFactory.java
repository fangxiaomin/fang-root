package com.fang.user.design.factory.ab;

import com.fang.user.design.factory.general.Sender;

/**
 * @description:   创建一个工厂接口，   也可以是 抽象类  public abstract class
 * @version:1.0
 */
public interface ProviderFactory {
    public Sender produce();
}
