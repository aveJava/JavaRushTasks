package com.javarush.task.task15.task1527;





/*
Парсер реквестов
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        ArrayList<String> list = new ArrayList<>(5);
        s = s.substring(s.indexOf("?") + 1);
        String[] param = s.split("&");

        for (String u : param) {
            if (u.contains("=")) {
                System.out.print(u.substring(0, u.indexOf("=")) + " ");
            } else System.out.print(u + " ");
        }

        for (String u : param) {
            if (u.contains("obj")) {
                System.out.println();
                try {
                    alert(Double.parseDouble(u.substring(u.indexOf("=") + 1)));
                } catch (Exception e) {
                    alert(u.substring(u.indexOf("=") + 1));
                }
            }
        }

    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
