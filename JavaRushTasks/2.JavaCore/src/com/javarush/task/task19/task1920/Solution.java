package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

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

        ArrayList<String> list = new ArrayList<>(map.keySet());
        double max = map.get(list.get(0));
        for (String s : list) {
            double temp = map.get(s);
            if (temp>max) {
                max = temp;
            }
        }

        Collections.sort(list);
        for (String s : list) {
            double temp = map.get(s);
            if (temp == max) {
                System.out.println(s);
            }
        }
reader.close();
    }
}
