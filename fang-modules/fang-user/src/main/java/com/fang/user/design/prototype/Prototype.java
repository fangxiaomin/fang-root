package com.fang.user.design.prototype;

import lombok.Data;

import java.io.*;

/**
 * @description:    原型模式=====?他的所有子类  只有id 不一样，通过这个成员变量的值不同去确定创建那个对象
 * @version:1.0
 */
@Data
public abstract class Prototype implements Cloneable ,Serializable{

    private String id;
    protected String type;
    abstract void draw();

    /*浅复制*/
    @Override
    public Object clone()  {
        Prototype prototype = null;
        try {
            prototype = (Prototype) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return prototype;
    }
    /*深复制*/
    public Object deepClone()  {
        /*写入当前对象的二进制流*/
        Prototype prototype = null;
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos =new ObjectOutputStream(bos);
            oos.writeObject(this);
            /* 读出二进制流产生的新对象 */
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            prototype = (Prototype) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return prototype;
    }


}
