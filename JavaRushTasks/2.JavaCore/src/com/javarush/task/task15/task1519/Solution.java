package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String s = reader.readLine();
            if ("exit".equals(s)) break;

            Pattern p1 = Pattern.compile("^-?\\d+\\.\\d+$");
            Pattern p2 = Pattern.compile("[^\\d\\n-]");
            Matcher m1 = p1.matcher(s);
            Matcher m2 = p2.matcher(s);

            if (m1.find()) print(Double.parseDouble(s));
            else if (m2.find()) print(s);
            else if (!m2.find()) {
                int i = Integer.parseInt(s);
                if (i>0 && i<128) print((short) i);
                else print(i);
            } else print(s);

        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}

