package com.javarush.task.task18.task1802;

/* 
Минимальный байт
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        FileInputStream inputStream = new FileInputStream(s);
        int i = inputStream.read();
        int p;
        while (inputStream.available() > 0) {
            p = inputStream.read();
            if (p < i) i = p;
        }
        System.out.println(i);
        inputStream.close();
    }
}
