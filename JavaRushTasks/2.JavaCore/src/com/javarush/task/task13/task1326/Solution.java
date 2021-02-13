package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File file = new File(reader.readLine());
        FileInputStream inputStream = new FileInputStream(file);
        Reader reader1 = new InputStreamReader(inputStream);
        BufferedReader r = new BufferedReader(reader1);
        ArrayList<Integer> list = new ArrayList<>();

        while (r.ready()) {
            int i = Integer.parseInt(r.readLine());
            if (i%2 == 0) list.add(i);
        }

        r.close();
        reader.close();

        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        Iterator it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        //C:\Users\Admin\Desktop\Test.txt
    }
}
