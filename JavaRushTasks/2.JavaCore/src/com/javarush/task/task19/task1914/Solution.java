package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consol = System.out;

        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(byteArray);
        System.setOut(stream);

        testString.printSomething();

        Pattern pattern = Pattern.compile("(\\d+)\\s([\\+\\-\\*])\\s(\\d+)\\s=\\s");
        Matcher matcher = pattern.matcher(byteArray.toString());
        int[] a = new int[2];
        matcher.find();

        int result = 0;

        if ("+".equals(matcher.group(2))) {
            result = Integer.parseInt(matcher.group(1)) + Integer.parseInt(matcher.group(3));
        }
        if ("-".equals(matcher.group(2))) {
            result = Integer.parseInt(matcher.group(1)) - Integer.parseInt(matcher.group(3));
        }
        if ("*".equals(matcher.group(2))) {
            result = Integer.parseInt(matcher.group(1)) * Integer.parseInt(matcher.group(3));
        }

        System.setOut(consol);

        System.out.println(matcher.group() + result);



    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

