package com.study.algorithm;

public class Singleton5 {

    private Singleton5 single5;
    private Singleton5() {
        single5 = new Singleton5();
    }

    static enum SingletonEnum {
        INSTANCE;
        private Singleton5 singleton5;
        private SingletonEnum() {
            singleton5 = new Singleton5();
        }
        public Singleton5 getInstance() {
            return singleton5;
        }
    }

    public static Singleton5 getInstance() {
        return SingletonEnum.INSTANCE.getInstance();
    }
}
