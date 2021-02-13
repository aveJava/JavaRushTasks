package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, String> names = new HashMap<>();
        String name = "";

        // читаем имена, раскладываем по карте: 2 - Lion.avi.part2
        while (true) {
            String s = reader.readLine();
            if (s.equals("end")) break;
            name = s.replaceAll("\\.part\\d+", "");
            int part = Integer.parseInt(s.substring(name.length() + 5));
            names.put(part, s);
        }

        // лист с номерами частей
        ArrayList<Integer> list = new ArrayList<>(names.keySet());
        Collections.sort(list);
        // сортируем карту
        Map<Integer, String> namesSort = new HashMap<>(names.size());
        for (int i = 0; i < names.size(); i++) {
            namesSort.put(list.get(i), names.get(list.get(i)));
        }

        // перебираем карту, открываем поток чтения для каждого файла и записываем данные этой части в общий файл
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(name, true)));
        for (Map.Entry pair : namesSort.entrySet()) {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(name + ".part" + pair.getKey())));
            while (reader.ready()) {
                writer.write(reader.readLine());
            }
            reader.close();
        }


        /*

L:\Test\Lion.avi.part1
L:\Test\Lion.avi.part4
L:\Test\Lion.avi.part2
L:\Test\Lion.avi.part3
end

L:\Test\Lion.avi.part1.txt
L:\Test\Lion.avi.part4.txt
L:\Test\Lion.avi.part2.txt
L:\Test\Lion.avi.part3.txt
end
         */

        writer.close();
    }
}
