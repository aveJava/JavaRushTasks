package com.javarush.task.task08.task0815;

import jdk.nashorn.internal.ir.LiteralNode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Перепись населения
*/

public class Solution {
    public static Map<String, String> createMap() {
        Map<String, String> map = new HashMap<>();

        map.put("Петров", "Иван");
        map.put("Сидоров", "Антон");
        map.put("Кошкина", "Оксана");
        map.put("Палкина", "Екатерина");
        map.put("Храбров", "Констансин");
        map.put("Ильин", "Семен");
        map.put("Кармен", "Петров");
        map.put("Ольга", "Нестерова");
        map.put("Сидорова", "Клавдия");
        map.put("Антонов", "Иван");

        return map;
    }

    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
        int count = 0;

        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> pair = it.next();
            if (pair.getValue().equals(name)) count++;
        }

        return count;
    }

    public static int getCountTheSameLastName(Map<String, String> map, String lastName) {
        int count = 0;

        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> pair = it.next();
            if (pair.getKey().equals(lastName)) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        Map<String, String> map = createMap();
        int i = getCountTheSameFirstName(map, "Иван");
        int ii = getCountTheSameLastName(map, "Сидоров");
    }
}
