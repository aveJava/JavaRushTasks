package com.javarush.task.task10.task1020;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[30];
        for (int i = 0; i < 30; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        System.out.println(array[9]);
        System.out.println(array[10]);
    }

    public static void sort(int[] array) {
        for (int t = 0; t < array.length - 1; t++) {
            for (int i1 = 0; i1 < array.length - 1; i1++) {
                if (array[i1]>array[i1+1]) {
                    int k = array[i1+1];
                    array[i1+1] = array[i1];
                    array[i1] = k;
                }
            }
        }

    }
}
