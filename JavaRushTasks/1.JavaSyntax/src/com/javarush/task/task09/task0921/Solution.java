package com.javarush.task.task09.task0921;

/* 
Метод в try..catch
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        while (true) {
            try {
                list.add(Integer.parseInt(reader.readLine()));
            } catch (Exception e) {
                Iterator<Integer> it = list.iterator();
                while (it.hasNext()) {
                    System.out.println(it.next());
                }
                return;
            }
        }
    }
}
