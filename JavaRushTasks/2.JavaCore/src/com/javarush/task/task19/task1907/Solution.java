package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        reader.close();
        reader = new BufferedReader(new FileReader(s));
        int i = 0;
        while (reader.ready()) {
            String string = reader.readLine();
            Pattern pattern = Pattern.compile("\\bworld\\b");
            Matcher matcher = pattern.matcher(string);
            while (matcher.find()) {
                i++;
            }
        }
        reader.close();
        System.out.println(i);
    }
}
