package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {
        String[] s = getTokens("level22.lesson13.task01", ".");

        for (String p : s) {
            System.out.println(p);
        }
    }

    public static String[] getTokens(String query, String delimiter) {
        if (query == null) return new String[0];
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        ArrayList<String> list = new ArrayList<>();
        while (tokenizer.hasMoreElements()) {
            list.add(tokenizer.nextToken());
        }

        String[] s = list.toArray(new String[0]);



//        int k = 0;
//        for (int i=0; i<query.length(); i++) {
//            if (query.substring(i, i+delimiter.length()).equals(delimiter)) {
//                list.add(query.substring(k, i));
//                k = i + delimiter.length();
//                i = i + delimiter.length() - 1;
//            }
//
//        }
//        list.add(query.substring(k));
//
//        String[] s = list.toArray(new String[0]);

        return s;
    }
}
