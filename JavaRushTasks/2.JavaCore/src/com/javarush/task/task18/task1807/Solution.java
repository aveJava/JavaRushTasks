package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File file = new File(reader.readLine());
        FileInputStream inputStream = new FileInputStream(file);
        int num = 0;

        while (inputStream.available() > 0) {   // пока в файле есть байты
            byte[] buff = new byte[1000];
            int read = inputStream.read(buff);  // читаем 1000 байтов
            for (int i=0; i<read; i++) {        // проходим по всем байтам
                if (buff[i] == 44) num++;
            }
        }

        inputStream.close();
        reader.close();
        System.out.println(num);
    }
}
