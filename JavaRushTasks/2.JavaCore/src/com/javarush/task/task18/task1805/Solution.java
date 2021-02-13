package com.javarush.task.task18.task1805;

/* 
Сортировка байт
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File file = new File(reader.readLine());
        FileInputStream inputStream = new FileInputStream(file);
        Set<Byte> set = new HashSet<>(); // множество всех прочитанных байт


        while (inputStream.available() > 0) {   // пока в файле есть байты
            byte[] buff = new byte[1000];
            int read = inputStream.read(buff);  // читаем 1000 байтов
            for (int i=0; i<read; i++) {        // проходим по всем байтам
                set.add(buff[i]);
            }
        }

        inputStream.close();
        reader.close();

        // сортируем в возрастающем порядке
        ArrayList<Byte> values = new ArrayList<>(set);
        Collections.sort(values);

        // печатаем
        for (int p=0; p<values.size(); p++) {
            System.out.print(values.get(p) + " ");
        }

        // C:\JavaRushTasks\2.JavaCore\src\com\javarush\task\task18\task1804\Non.txt
        // 10 13 -119 -120
    }
}
