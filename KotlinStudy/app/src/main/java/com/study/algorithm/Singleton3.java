package com.study.algorithm;

/**
 * 双重校验锁模式
 */
public class Singleton3 {

    private static volatile Singleton3 singleton3 = null;

    private Singleton3() {

    }

    public static Singleton3 getInstance() {
        if (null == singleton3) {
            synchronized (Singleton3.class) {
                if (null == singleton3) {
                    singleton3 = new Singleton3();
                }
            }
        }
        return singleton3;
    }





}
