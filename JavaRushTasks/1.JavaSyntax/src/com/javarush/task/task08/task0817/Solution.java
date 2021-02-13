package com.javarush.task.task08.task0817;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static Map<String, String> createMap() {
        Map<String, String> map = new HashMap<>();
        map.put("1","1212");
        map.put("2","121");
        map.put("3","12");
        map.put("4","122");
        map.put("5","12");
        map.put("6","123");
        map.put("7","1212");
        map.put("8","124");
        map.put("9","125");
        map.put("10","1212");

        return map;
    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        ArrayList<String> list = new ArrayList<>(map.values());
        for (int i=0; i<list.size(); i++) {
            for (int f=0; f<list.size(); f++) {
                if (i != f && list.get(i).equals(list.get(f))) {
                    removeItemFromMapByValue(map, list.get(i));
                }
            }
        }

    }


    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }

    }

    public static void main(String[] args) {
        Map<String, String> map = createMap();
        removeTheFirstNameDuplicates(map);
    }
}
