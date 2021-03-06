package com.javarush.task.task18.task1804;

/* 
Самые редкие байты
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
        Map<Byte, Integer> map = new HashMap<>(); // карта: байт - количество повторов


        while (inputStream.available() > 0) {   // пока в файле есть байты
            byte[] buff = new byte[1000];
            int read = inputStream.read(buff);  // читаем 1000 байтов
            for (int i=0; i<read; i++) {        // проходим по всем байтам
                // если мар не содержит ключа, как этот байт, то добавляем его
                // с нулем повторенй
                if (!map.containsKey(buff[i])) map.put(buff[i], 0);
                // увеличиваем значение для данного байта на 1
                map.put(buff[i], map.get(buff[i]) + 1);
            }
        }

        inputStream.close();
        reader.close();

        // находим минимальное число повторений min
        ArrayList<Integer> values = new ArrayList<>(map.values());
        int min = values.get(0);
        for (int p=1; p<values.size(); p++) {
            if (values.get(p) < min) {
                min = values.get(p);
            }
        }

        // распечатываем все байты с количеством повторений min через пробел
        for (Map.Entry<Byte, Integer> pair : map.entrySet()) {
            if (pair.getValue() == min) {
                System.out.print(pair.getKey() + " ");
            }
        }

        // C:\JavaRushTasks\2.JavaCore\src\com\javarush\task\task18\task1804\Non.txt
    }
}
