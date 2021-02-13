package com.javarush.task.task10.task1019;

/* 
Функциональности маловато!
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {

        // Формируем список значений, введенных с клавиатуры, элементы с нечетным
        // индексом - ключи, а с четным индексом - значения.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String str = reader.readLine();
            list.add(str);
            if (str.equals("") || str.isEmpty()) {
                break;
            }
        }

        // Создаем карту из списка значений
        HashMap<String, String > map = new HashMap<>();
        for (int i=0; i<list.size()-1; i=i+2) {
            map.put(list.get(i+1), list.get(i));
        }

        // Выводим карту на экран
        map.forEach((k, v) -> System.out.println(v + " " + k));
    }
}
