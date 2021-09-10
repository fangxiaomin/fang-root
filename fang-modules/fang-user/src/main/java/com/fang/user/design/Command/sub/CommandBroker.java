package com.fang.user.design.Command.sub;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:fxm
 * @createTime:2021/9/10 16:12
 */
public class CommandBroker {
    private List<commandOrder> orderList = new ArrayList<>();

    public void takeOrder(commandOrder order) {
        orderList.add(order);
    }

    public void placeOrders() {
        for (commandOrder order : orderList) {
            order.execute();
        }
        orderList.clear();
    }



}
