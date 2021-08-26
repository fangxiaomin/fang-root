package com.fang.user.design.factory.general;

/**
 * @description:
 * @projectName:fang-root
 * @see:com.fang.user.design.factory.general
 * @author:fxm
 * @createTime:2021/8/26 14:55
 * @version:1.0
 */
public class SendMoreFactory {

    public Sender produceMail(){
        return new MailSender();
    }

    public Sender produceSms(){
        return new SmsSender();
    }
}
