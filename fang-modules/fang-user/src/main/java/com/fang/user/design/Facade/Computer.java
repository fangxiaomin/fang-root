package com.fang.user.design.Facade;

import sun.plugin2.gluegen.runtime.CPU;

/**
 * @description:   这个类相当于 是Facade类中   将所有关联的 类整合到这个类里面，然后进行对外统一提供  外观类
 * @version:1.0
 */
public class Computer {

    private Cpu cpu;
    private Memory memory;
    private Disk disk;

    public Computer() {
        cpu = new Cpu();
        memory = new Memory();
        disk = new Disk();
    }

    public void startup(){
        System.out.println("start the computer!");
        cpu.startup();
        memory.startup();
        disk.startup();
        System.out.println("start computer finished!");
    }


    public void shutdown(){
        System.out.println("begin to close the computer!");
        cpu.shutdown();
        memory.shutdown();
        disk.shutdown();
        System.out.println("computer closed!");
    }

    public void startupCpu(){ cpu.startup();}

    public void startupMemory(){ memory.startup();}



}
