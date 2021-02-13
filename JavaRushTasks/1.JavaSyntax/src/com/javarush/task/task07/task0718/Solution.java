package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> list = new ArrayList<String>(10);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 1; i < 11; i++) {
            list.add(reader.readLine());
        }

        boolean up = true;
        for (int i = 1; up&&(i<10); i++) {
            int d = list.get(i).length() - list.get(i-1).length();
            up = d>=0;
            if (up==false) {
                System.out.println(i);
                break;
            }
        }


    }
}

