package com.javarush.task.task08.task0827;

/* 
Работа с датой
*/

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Solution {
    public static void main(String[] args) {
        System.out.println(isDateOdd("MAY 1 2013"));
    }

    public static boolean isDateOdd(String date)  {
        SimpleDateFormat ft = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Date date1 = new Date();

        try {
            date1 = ft.parse(date);
        } catch (ParseException e) {
            System.out.println(e);
            System.out.println("Неподходяцая запись даты");
        }

        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date1);
        int chislo = calendar.get(Calendar.DAY_OF_YEAR);
        boolean a = false;
        if ((chislo%2) != 0) a = true;

        return a;
    }
}
