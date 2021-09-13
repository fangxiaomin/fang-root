package com.fang.user.design.memento;

/**
 * @author:fxm  类似于撤回，可以拿到之前的存储记录
 * @createTime:2021/9/13 13:46
 */
public class MementoPatternTest {
    public static void main(String[] args) {
        Original original = new Original();
        Storage storage = new Storage();

        original.setValue("State #1");
        original.setValue("State #2");
        storage.add(original.createMemento());
        original.setValue("State #3");
        storage.add(original.createMemento());
        original.setValue("State #4");

        System.out.println("Current State: " + original.getValue());
        original.restoreMemento(storage.get(0));
        System.out.println("First saved State: " + original.getValue());
        original.restoreMemento(storage.get(1));
        System.out.println("Second saved State: " + original.getValue());


    }
}
