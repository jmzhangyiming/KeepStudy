package com.study.java;

import com.study.kotlinstudy.CaseInsenssitiveFileComparator;
import com.study.kotlinstudy.LearnStudy2;
import com.study.kotlinstudy.LearnStudy8Kt;
import com.study.kotlinstudy.StringFunction;

import java.util.ArrayList;
import java.util.List;

import kotlin.Unit;
import kotlin.collections.CollectionsKt;

public class JavaStudy1 {

    public static void main(String[] args) {
        char c = StringFunction.lastChar("Java");
        System.out.println(StringFunction.getLastChar("Java"));
        System.out.println(StringFunction.getLastChar("JAVA"));

//        CaseInsenssitiveFileComparator.INSTANCE.compare();
        LearnStudy8Kt.processTheAnswer((it, he) -> it + he);
        System.out.println("111");

        List<String> strings = new ArrayList<>();
        strings.add("42");
        CollectionsKt.forEach(strings, s-> {
            System.out.println(s);
            return Unit.INSTANCE;
        });
    }

    public static void hehe() {

    }



}
