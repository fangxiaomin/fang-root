package com.fang.user.design.factory.ab;

import com.fang.user.design.factory.general.MailSender;
import com.fang.user.design.factory.general.Sender;

/**
 * @description:
 * @version:1.0
 */
public class SendMailFactory implements ProviderFactory{
    @Override
    public Sender produce() {
        return new MailSender();
    }
}
