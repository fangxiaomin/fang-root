package com.fang.user.design.Command.sub;

/**
 * @author:fxm
 * @createTime:2021/9/10 16:10
 */
public class CommandBuyStock implements commandOrder{

    private CommandStock abcStock;

    public CommandBuyStock(CommandStock abcStock) {
        this.abcStock = abcStock;
    }

    @Override
    public void execute() {
        abcStock.buy();
    }
}
