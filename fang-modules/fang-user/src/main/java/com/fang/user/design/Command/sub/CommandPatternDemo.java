package com.fang.user.design.Command.sub;

import com.sun.corba.se.pept.broker.Broker;

/**
 * @author:fxm
 * @createTime:2021/9/10 16:14
 */
public class CommandPatternDemo {
    public static void main(String[] args) {
        CommandStock stock = new CommandStock();

        CommandBuyStock buyStockOrder = new CommandBuyStock(stock);
        CommandSellStock sellStock = new CommandSellStock(stock);

        CommandBroker broker = new CommandBroker();
        broker.takeOrder(buyStockOrder);
        broker.takeOrder(sellStock);

        broker.placeOrders();
    }
}
