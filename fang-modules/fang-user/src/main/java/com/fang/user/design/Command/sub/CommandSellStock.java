package com.fang.user.design.Command.sub;

/**
 * @author:fxm
 * @createTime:2021/9/10 16:11
 */
public class CommandSellStock implements commandOrder{
    private CommandStock abcStock;

    public CommandSellStock(CommandStock abcStock) {
        this.abcStock = abcStock;
    }

    @Override
    public void execute() {
        abcStock.sell();
    }
}
