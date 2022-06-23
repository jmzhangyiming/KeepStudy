package com.study.algorithm;

/**
 * 懒汉模式
 */
public class Singleton2 {
    public static Singleton2 singleton2 = null;

    private Singleton2() {

    }

    public static synchronized Singleton2 getInstance() {
        if (null == singleton2) {
            singleton2 = new Singleton2();
        }
        return singleton2;
    }
}
