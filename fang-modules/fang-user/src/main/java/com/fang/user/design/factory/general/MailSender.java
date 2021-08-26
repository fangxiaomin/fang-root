package com.fang.user.design.factory.general;

/**
 * @description:
 * @projectName:fang-root
 * @see:com.fang.user.design.factory
 * @author:fxm
 * @createTime:2021/8/26 14:46
 * @version:1.0
 */
public class MailSender implements Sender{
    @Override
    public void send() {
        System.out.println("this is mailsender!");

    }
}
