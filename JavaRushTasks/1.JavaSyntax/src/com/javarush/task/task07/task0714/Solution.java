package com.javarush.task.task07.task0714;

/* 
Слова в обратном порядке
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> st = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0; i<5; i++) {
        st.add(reader.readLine());}
        st.remove(2);

        for (int i=3; i>-1; i--) {
            System.out.println(st.get(i));
        }
    }
}
