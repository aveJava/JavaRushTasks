package com.javarush.task.task22.task2212;

import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        ArrayList<Character> punct = new ArrayList<>();
        System.out.println(punct.toString());
        punct.add('+');
        System.out.println(punct.toString());
        punct.add('(');
        punct.add(')');
        punct.add('-');
        System.out.println(punct.toString().equals("[+, (, ), -]"));
    }
}
