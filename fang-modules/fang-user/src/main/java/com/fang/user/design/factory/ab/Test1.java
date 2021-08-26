package com.fang.user.design.factory.ab;

import com.fang.user.design.factory.general.Sender;

/**
 * @description:
 * @projectName:fang-root
 * @see:com.fang.user.design.factory.ab
 * @author:fxm
 * @createTime:2021/8/26 15:37
 * @version:1.0
 */
public class Test1 {

    public static void main(String[] args) {
        ProviderFactory providerFactory =new SendMailFactory();
        Sender sender= providerFactory.produce();
        sender.send();
    }
}
