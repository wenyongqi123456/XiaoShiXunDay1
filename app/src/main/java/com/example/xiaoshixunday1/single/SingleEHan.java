package com.example.xiaoshixunday1.single;
//饿汉单例一开始就创建对象，可能造成内存浪费
//优点：线程安全的
public class SingleEHan {
    private static SingleEHan singleEan = new SingleEHan();

    private SingleEHan() {
    }

    public static SingleEHan getInstance() {
        return singleEan;
    }


}
