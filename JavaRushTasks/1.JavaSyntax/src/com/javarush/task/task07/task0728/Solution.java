package com.javarush.task.task07.task0728;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
В убывающем порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < 20; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }
        sort(array);

        for (int x : array) {
            System.out.println(x);
        }
    }

    public static void sort(int[] array) {
        for (int i = 0; i < 20; i++) {
            int num = i;
            int element1 = array[i];
            int max = array[i];
            for (int i2 = i+1; i2 < 20; i2++) {
                if (max<=array[i2]) {
                    max=array[i2];
                    num = i2;
                }
            }

            array[i] = max;
            array[num] = element1;
        }
    }

}




