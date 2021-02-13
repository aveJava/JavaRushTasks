package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {

    public static Map<String, Date> createMap() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Map<String, Date> map = new HashMap<>();
        map.put("Сталлоне", dateFormat.parse("MAY 1 2012"));
        map.put("Кондратов", dateFormat.parse("MAY 12 2012"));
        map.put("Октябринина", dateFormat.parse("DECEMBER 1 2012"));
        map.put("Кардашов", dateFormat.parse("FEBRUARY 1 2012"));

        map.put("Польских", dateFormat.parse("JUNE 1 2012"));
        map.put("Северский", dateFormat.parse("JULY 21 2012"));
        map.put("Полянская", dateFormat.parse("AUGUST 1 2012"));
        map.put("Юдина", dateFormat.parse("MAY 19 2012"));

        map.put("Толоконникова", dateFormat.parse("OCTOBER 1 2012"));
        map.put("Седых", dateFormat.parse("NOVEMBER 1 2012"));

        return map;
    }

    public static void removeAllSummerPeople(Map<String, Date> map) {
        Iterator<Map.Entry<String, Date>> it = map.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<String, Date> pair = it.next();
            Date date = pair.getValue();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            int m = calendar.get(Calendar.MONTH);
            if (m>4 && m<8) it.remove();
        }

    }

    public static void main(String[] args) throws ParseException {
        Map<String, Date> map = createMap();
        removeAllSummerPeople(map);
    }
}
