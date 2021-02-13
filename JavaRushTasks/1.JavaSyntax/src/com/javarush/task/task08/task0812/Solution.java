package com.javarush.task.task08.task0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<Integer>();
        for (int i=0; i<10; i++) {
            list.add(Integer.parseInt(reader.readLine()));
        }
        dlina(list);

    }

    public static void dlina(List list) {
        int povtori = 1;
        for (int i=0; i<list.size(); i++){
            int pov = 1;
            for (int ii=i+1; ii<list.size(); ii++){
                if (list.get(i).equals(list.get(ii)))
                    pov++;
                else break;
            }
            if (povtori<pov) povtori = pov;
        }
        System.out.println(povtori);
    }
}