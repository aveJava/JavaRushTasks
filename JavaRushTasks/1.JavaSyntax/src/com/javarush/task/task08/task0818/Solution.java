package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static Map<String, Integer> createMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("фамилия1", 100);
        map.put("фамилия2", 200);
        map.put("фамилия3", 300);
        map.put("фамилия4", 400);
        map.put("фамилия5", 500);
        map.put("фамилия6", 600);
        map.put("фамилия7", 700);
        map.put("фамилия8", 500);
        map.put("фамилия9", 200);
        map.put("фамилия10", 300);
        return map;
    }

    public static void removeItemFromMap(Map<String, Integer> map) {
        Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> pair = it.next();
            if (pair.getValue() < 500) {
                it.remove();
            }
        }
        System.out.println(map);
    }

    public static void main(String[] args) {

    }
}