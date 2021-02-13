package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream reader = new FileInputStream(args[0]);
        byte[] bytes = new byte[reader.available()];
        reader.read(bytes);
        int quantity = 0;
        int quantitySpace = 0;

        for (byte b : bytes) {
            if (b == 32) {
                quantitySpace++;
                quantity++;
            } else {
                quantity++;
            }
        }


        double result = ((double) quantitySpace / quantity) * 100;
        System.out.printf("%.2f%n", result);

        reader.close();

    }
}
