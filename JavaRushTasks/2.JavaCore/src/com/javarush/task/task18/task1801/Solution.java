package com.javarush.task.task18.task1801;

/* 
Максимальный байт
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File file = new File(reader.readLine());
        FileInputStream inputStream = new FileInputStream(file);
        int i = inputStream.read();
        while (inputStream.available() > 0) {
            int p = inputStream.read();
            if (p>i) i = p;
        }
        System.out.println(i);
        inputStream.close();
    }
}
