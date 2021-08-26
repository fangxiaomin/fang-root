package com.fang.user.design.factory.ab;

import com.fang.user.design.factory.general.MailSender;
import com.fang.user.design.factory.general.Sender;

/**
 * @description:  使用Abstract
 * @version:1.0
 */
public class BlackHumanFactory extends AbstractHumanFactory{

    @Override
    public Sender createHuman() {
        return new MailSender();
    }


    public static void main(String[] args) {
        Sender mail = new BlackHumanFactory().createHuman(); //main诞生了
        mail.send();
    }
}
