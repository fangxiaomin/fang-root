package com.fang.user.design.prototype;

import java.io.*;

/**
 * @description:
 * @projectName:fang-root
 * @see:com.fang.user.design.prototype
 * @author:fxm
 * @createTime:2021/8/27 13:50
 * @version:1.0
 */
public class ShallowCopy {
    public static void main(String[] args) {
        Age a=new Age(20);
        Student stu1=new Student("TestMan",a,175);
        //通过调用重写后的clone方法进行浅拷贝
        Student stu2=(Student)stu1.deepClone();
        System.out.println(stu1.toString());
        System.out.println(stu2.toString());
        //尝试修改stu1中的各属性，观察stu2的属性有没有变化
        stu1.setName("大傻子");
        //改变age这个引用类型的成员变量的值
//        a.setAge(99);     //由于Age是一个对象，进行的是浅复制，后面修改其中一个对象的Age值，最后两者的值会被修改
        stu1.setaAge(new Age(99));    //使用这种方式修改age属性值的话，stu2是不会跟着改变的。因为创建了一个新的Age类对象而不是改变原对象的实例值
        stu1.setLength(216);
        System.out.println(stu1.toString());
        System.out.println(stu2.toString());
    }
}
class Age implements Serializable{
    //年龄类的成员变量（属性）
    private int age;
    //构造方法
    public Age(int age) {
        this.age=age;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return this.age+"";
    }
}


/*
 * 创建学生类
 */
class Student implements Cloneable, Serializable {
    //学生类的成员变量（属性）,其中一个属性为类的对象
    private String name;
    private Age aage;
    private int length;
    //构造方法,其中一个参数为另一个类的对象
    public Student(String name,Age a,int length) {
        this.name=name;
        this.aage=a;
        this.length=length;
    }
    //eclipe中alt+shift+s自动添加所有的set和get方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Age getaAge() {
        return this.aage;
    }

    public void setaAge(Age age) {
        this.aage=age;
    }

    public int getLength() {
        return this.length;
    }

    public void setLength(int length) {
        this.length=length;
    }
    //设置输出的字符串形式
    @Override
    public String toString() {
        return "姓名是： "+this.getName()+"， 年龄为： "+this.getaAge().toString()+", 长度是： "+this.getLength();
    }
    //重写Object类的clone方法
    @Override
    public Object clone() {
        Object obj=null;
        //调用Object类的clone方法，返回一个Object实例
        try {
            obj= super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return obj;
    }

    /*深复制*/
    public Object deepClone()  {
        /*写入当前对象的二进制流*/
        Student student = null;
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos =new ObjectOutputStream(bos);
            oos.writeObject(this);
            /* 读出二进制流产生的新对象 */
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            student = (Student) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return student;
    }
}