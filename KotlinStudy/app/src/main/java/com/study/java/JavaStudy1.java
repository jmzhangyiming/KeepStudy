package com.study.java;

import com.study.kotlinstudy.CaseInsenssitiveFileComparator;
import com.study.kotlinstudy.LearnStudy2;
import com.study.kotlinstudy.StringFunction;

public class JavaStudy1 {

    public static void main(String[] args) {
        char c = StringFunction.lastChar("Java");
        System.out.println(StringFunction.getLastChar("Java"));
        System.out.println(StringFunction.getLastChar("JAVA"));

//        CaseInsenssitiveFileComparator.INSTANCE.compare();

    }

}
