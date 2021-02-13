package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        Map<String, Double> map = new HashMap<>();

        while (reader.ready()) {
            String[] s = reader.readLine().split(" ");
            if (map.containsKey(s[0])) {
                map.put(s[0], map.get(s[0]) + Double.parseDouble(s[1]));
            } else {
                map.put(s[0], Double.parseDouble(s[1]));
            }
        }



        ArrayList<Double> list = new ArrayList<>(map.values());
        Collections.sort(list);
        for (int i=0; i<list.size(); i++) {
            String key = null;

            for (Map.Entry s : map.entrySet()) {
                if (s.getValue() == list.get(i)) {
                    key = String.valueOf(s.getKey());
                    System.out.println(s.getKey() + " " + s.getValue());
                    break;
                }
            }
            map.remove(key);

        }

        reader.close();
    }
}
