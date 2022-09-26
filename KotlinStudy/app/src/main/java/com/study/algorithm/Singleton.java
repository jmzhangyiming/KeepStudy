package com.study.algorithm;

public class Singleton {

//    private static Singleton singleton= new Singleton();
//    private Singleton() {
//
//    }
//    public static Singleton getInstance() {
//        return singleton;
//    }

//    private static Singleton singleton = new Singleton();
//    private Singleton() {
//
//    }
//    public static synchronized Singleton getInstance() {
//        if (null == singleton) {
//            singleton = new Singleton();
//        }
//        return singleton;
//    }

//    private static volatile Singleton singleton = null;
//    private Singleton() {
//
//    }
//    public static Singleton getInstance() {
//        if (null == singleton) {
//            synchronized (Singleton.class) {
//                if (null == singleton) {
//                    singleton = new Singleton();
//                }
//            }
//        }
//        return singleton;
//    }

    private static class INSTANCE {
        private static Singleton instance = new Singleton();
    }

    private Singleton() {

    }

    public static Singleton getInstance() {
        return INSTANCE.instance;
    }

    enum Singleton11 {
        INSTANCE;
        public void whatever() {

        }
    }

    public static void main(String[] args) {
        Singleton.getInstance();
        Singleton11.INSTANCE.whatever();
        // 创建型模式
        // 简单工厂，工厂，抽象工厂，建造者，原型，单例
        // 结构型模式
        // 适配器模式（）、装饰型模式、组合模式、桥接模式、外观模式、享元模式、代理模式
        //
        // 行为型模式

    }



}
