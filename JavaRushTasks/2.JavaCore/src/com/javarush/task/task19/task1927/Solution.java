package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        testString.printSomething();
        StringBuilder builder = new StringBuilder(out.toString());
        ArrayList<String> list = new ArrayList<>(Arrays.asList(builder.toString().split("\\n")));
        for (int i=2; i<list.size()+1; i=i+2) {
            list.add(i, "JavaRush - курсы Java онлайн");
            i++;
        }


        System.setOut(console);
        list.forEach((v) -> System.out.println(v));
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
