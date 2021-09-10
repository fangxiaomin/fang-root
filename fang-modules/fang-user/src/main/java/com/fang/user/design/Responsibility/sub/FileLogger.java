package com.fang.user.design.Responsibility.sub;

/**
 * @author:fxm 创建扩展了该记录器类的实体类。
 * @createTime:2021/9/10 15:22
 */
public class FileLogger extends AbstractLogger{
    public FileLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("File::Logger: " + message);
    }
}
