package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream reader = new FileInputStream(args[0]);
        byte[] bytes = new byte[reader.available()];
        reader.read(bytes);
        int quantity = 0;

        for (byte b : bytes) {
            if ((b>64 && b<91) || (b>69 && b<123)) {
                quantity++;
            }
        }

        System.out.println(quantity);
        reader.close();
    }
}
