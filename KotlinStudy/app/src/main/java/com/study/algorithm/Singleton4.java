package com.study.algorithm;

/**
 * 静态内部类
 */
public class Singleton4 {

    private Singleton4() {

    }

    private static class INSTANCE {
        public static Singleton4 single4 = new Singleton4();
    }

    public static Singleton4 getInstance() {
        return INSTANCE.single4;
    }

}
