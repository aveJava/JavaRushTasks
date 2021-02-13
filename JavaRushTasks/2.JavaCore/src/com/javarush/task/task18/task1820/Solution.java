package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.math.BigDecimal;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();

        reader = new BufferedReader(new InputStreamReader(new FileInputStream(file1)));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file2)));
        while (reader.ready()) {
            String s = reader.readLine();
            String[] realNumbers = s.split(" ");
            for (String s1 : realNumbers) {
                System.out.println(s1);
            }

            for (int i=0; i<realNumbers.length; i++) {
                writer.write(Math.round(Double.parseDouble(realNumbers[i])) + " ");
            }
        }

        reader.close();
        writer.close();
    }
}
