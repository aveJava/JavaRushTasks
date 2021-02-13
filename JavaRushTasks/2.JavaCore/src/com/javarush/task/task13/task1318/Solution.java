package com.javarush.task.task13.task1318;

/* 
Чтение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        reader.close();
        FileInputStream reader1 = new FileInputStream(s);
        reader = new BufferedReader(new InputStreamReader(reader1));
        while (reader.ready()) {
            System.out.println(reader.readLine());
        }
        reader1.close();
        reader.close();
    }
}