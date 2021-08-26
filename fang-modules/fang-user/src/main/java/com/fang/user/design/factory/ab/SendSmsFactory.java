package com.fang.user.design.factory.ab;

import com.fang.user.design.factory.general.Sender;
import com.fang.user.design.factory.general.SmsSender;

/**
 * @description:
 * @version:1.0
 */
public class SendSmsFactory implements ProviderFactory{
    @Override
    public Sender produce() {
        return new SmsSender();
    }
}
