package com.javarush.task.task09.task0902;

/* 
И снова StackTrace
*/

import com.javarush.task.task06.task0607.Cat;

import java.util.Comparator;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        method1();
    }

    public static String method1() {
        method2();
        StackTraceElement[] element = Thread.currentThread().getStackTrace();
        return element[2].getMethodName();
    }

    public static String method2() {
        method3();
        StackTraceElement[] element = Thread.currentThread().getStackTrace();
        return element[2].getMethodName();
    }

    public static String method3() {
        method4();
        StackTraceElement[] element = Thread.currentThread().getStackTrace();
        return element[2].getMethodName();
    }

    public static String method4() {
        method5();
        StackTraceElement[] element = Thread.currentThread().getStackTrace();
        return element[2].getMethodName();
    }

    public static String method5() {
        StackTraceElement[] element = Thread.currentThread().getStackTrace();
        return element[2].getMethodName();
    }
}
