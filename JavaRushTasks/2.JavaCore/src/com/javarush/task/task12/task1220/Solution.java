package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

/*
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static Map<String, Date> createMap() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Map<String, Date> map = new HashMap<>();
        map.put("Сталлоне", dateFormat.parse("MAY 1 2012"));

        //напишите тут ваш код
        map.put("Панталлоне1", dateFormat.parse("AUGUST 2 2011"));
        map.put("Фанталлоне", dateFormat.parse("SEPTEMBER 3 2002"));
        map.put("Иваналлоне2", dateFormat.parse("JULY 14 1996"));
        map.put("Миланаллоне", dateFormat.parse("MARCH 16 1993"));
        map.put("Портаналлоне3", dateFormat.parse("JUNE 14 1996"));
        map.put("Фарталлоне", dateFormat.parse("NOVEMBER 14 1996"));
        map.put("Фарталлоне20", dateFormat.parse("JANUARY 14 1996"));
        map.put("Фарталлоне30", dateFormat.parse("FEBRUARY 14 1997"));
        map.put("Фарталлоне40", dateFormat.parse("APRIL 14 1998"));
        return map;
    }

    /*
    И второй момент. Программа то так и не заработала. Так получается потому, что в
    42-ой строчке конструкция "it.next().getValue().getMonth()" каждый раз возвращает
    новое значение. То есть получается:
    if ("Первое значение" > 4 && "Новое значение" < 8)

    Получается что ли, что при каждом вызове "it.next().getValue().getMonth()"
    итеретор перескакивает на новое значение? Тут самому непонятно.


     */


    public static void removeAllSummerPeople(Map<String, Date> map) {
        //напишите тут ваш код
      /*  for (Map.Entry<String, Date> pair : map.entrySet()){
          Date date = pair.getValue();
          if (date.getMonth()>4 && date.getMonth()<8)
              map.remove(pair.getKey());
        }*/
        Iterator<Map.Entry<String, Date>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Date date = it.next().getValue();
            if (date.getMonth()>4 && date.getMonth()<8)
                it.remove();
        }
    }

    public static void main(String[] args) throws ParseException {
        Map<String, Date> map = createMap();
        removeAllSummerPeople(map);
        map.forEach((K, V) -> System.out.println(K + " : " + V));
    }
}
