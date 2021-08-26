package com.fang.user.design.factory.ab;

import com.fang.user.design.factory.general.Sender;

/**
 * @description:  Abstract
 * @version:1.0
 */
public abstract class AbstractHumanFactory {
    public abstract Sender createHuman(); //注意这里T必须是Sender的实现类才行，因为要造Sender嘛

}
