package com.javarush.task.task09.task0922;

/* 
Какое сегодня число?
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String st = reader.readLine();

        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        SimpleDateFormat new_ft = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
        Date date = ft.parse(st);
        System.out.println(new_ft.format(date).toUpperCase());
    }
}

