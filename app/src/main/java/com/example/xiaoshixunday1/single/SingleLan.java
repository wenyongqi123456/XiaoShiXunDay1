package com.example.xiaoshixunday1.single;
//懒汉单例加双检锁
//优点：线程安全，延迟了对象的创建
public class SingleLan {
    private volatile static SingleLan singleLan;

    private SingleLan() {
    }

    public static SingleLan getInstance() {
        if (singleLan == null) {
            synchronized (SingleLan.class) {
                if (singleLan == null) {
                    singleLan = new SingleLan();
                }

            }
        }
        return singleLan;
    }
}
