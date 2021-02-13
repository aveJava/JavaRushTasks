package com.javarush.task.task07.task0719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Вывести числа в обратном порядке
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> st = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0; i<10; i++) {
            st.add(Integer.parseInt(reader.readLine()));
        }

        for (int i=9; i>-1; i--) {
            System.out.println(st.get(i));
        }

    }
}
