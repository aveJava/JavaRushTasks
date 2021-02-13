package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();     //   создаем список list
        while (true) {                                  //   заполняем список строками
            String s = reader.readLine();               //   введенными с клавиатуры
            if (s.isEmpty()) {
                break;
            }
            list.add(s);
        }

        String[] array = list.toArray(new String[0]);   //   превращаем список в массив
        sort(array);                                 //   сортируем массив методом sort

        for (String x : array) {                     // выводим отсортированный массив
            System.out.println(x);                   // на экран
        }
    }


                                        // Методы

    // метод сортировки массива (sort)
    public static void sort(String[] array) {
        ArrayList<String> slova = new ArrayList<>();   //   создание массивов под слова
        ArrayList<Long> chisla = new ArrayList<>();    //   и числа (раздельно)


        for (String st : array)     //раскидывание слов и чисел по своим массивам
        if (isNumber(st)) chisla.add(Long.parseLong(st));
        else slova.add(st);

        String[] sl = slova.toArray(new String[0]); //  получаем массив слов из списка
        long[] arr = new long[chisla.size()];       //  Объявляем массив чисел
        for (int r=0; r<chisla.size(); r++) {       //  и заполняем его из
            arr[r] = chisla.get(r);                 //  списка чисел
        }

        for (int i=1; i<arr.length; i++) {          //  сортировка массива чисел
            for (int p=1; p<arr.length; p++) {      //  методом пузырька
                long u = arr[p];
                if (arr[p-1] < arr[p]) {
                    arr[p] = arr[p-1];
                    arr[p-1] = u;
                }
            }
        }

        String[] ar = new String[arr.length];       //  переносим числа
        for (int i=0; i<arr.length; i++) {          //  из массива типа long[]
            ar[i] = String.valueOf(arr[i]);         //  в массив типа String[]
        }

        for (int i=1; i<sl.length; i++) {           //  сортировка массива слов
            for (int p=1; p<sl.length; p++) {       //  методом пузырька
                String u = sl[p];
                if (isGreaterThan(sl[p-1], sl[p])) {    //   для сравнения пар слов
                    sl[p] = sl[p-1];                    //   по возрастанию
                    sl[p-1] = u;                        //   вызывается метод
                }                                       //   isGreaterThan
            }
        }

        // Формирование итогового массива "String[] array" из двух
        // уже отсортированных по возрастанию и убыванию массиов
        // (массива слов "String[] sl" и массива чисел "String[] ar").
        // Принцип такой: перебираем список слов, введенных с клавиатуры, и когда в нем
        // попадается число, добавляем в итоговый массив один элемент из массива чисел,
        // когда слово - один элемент из массива слов.

        int i1 = 0;     //   индекс для массива чисел
        int i2 = 0;     //   индекс для массива слов

        for (int i=0; i<array.length; i++) {
            if (isNumber(array[i])) {
                array[i] = ar[i1];
                i1++;
            } else {
            array[i] = sl[i2]; i2++;
            }
        }
    }


    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) {
            return false;
        }

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // Строка содержит '-'
                    || (!Character.isDigit(c) && c != '-') // или не цифра и не начинается с '-'
                    || (chars.length == 1 && c == '-')) // или одиночный '-'
            {
                return false;
            }
        }
        return true;
    }
}

