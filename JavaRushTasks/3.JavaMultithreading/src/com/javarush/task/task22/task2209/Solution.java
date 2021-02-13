package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(scanner.nextLine())));
        StringBuilder builder = new StringBuilder();
        while (reader.ready()) {
            builder.append(reader.readLine() + " ");
        }
        String[] words = new String(builder).split(" ");


        StringBuilder result = getLine(words);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        if (words.length == 0 || words == null) return new StringBuilder();
        ArrayList<String> list1 = new ArrayList<>(Arrays.asList(words));
        StringBuilder builder = new StringBuilder();
        String last = "";


        // пока не найдем нужную последовательность, повторять цикл,
        // перемешивая исходный массив
        while (true) {
            boolean error = false;
            ArrayList<String> list = new ArrayList<>(list1);

            // каждый раз новое первое слово
            for (int p = 0; p < list.size(); p++) {
                // флаг, обозначающий, что алгоритм не завершился не учачей (true)
                boolean norm = true;

                // добавляем первое слово (каждый раз следующее)
                builder.append(list.get(p) + " ");
                last = list.get(p).substring(list.get(p).length() - 1);
                list.remove(p);

                // подбираем к первому слову все остальные
                // добавленные слова выкидываем из list
                // подбор ведем пока не выкинем все из лист или пока norm
                // не станет false

                while (list.size() != 0 ) {
                    if (norm == false) break;

                    // ищем слудующее подходящее слово и добавляем его
                    for (int i = 0; i < list.size(); i++) {
                        if (last.equalsIgnoreCase(list.get(i).substring(0, 1))) {
                            builder.append(list.get(i) + " ");
                            last = list.get(i).substring(list.get(i).length() - 1);
                            list.remove(i);
                            break;
                        }
                        if (i == list.size() - 1) norm = false;
                    }

                }

                if (list.size() == 0 && norm == true) {
                    break;
                } else {
                    list = new ArrayList<>(list1);
                    builder = new StringBuilder();
                    // если алгоритм закончился, а нужный результат так и не был получен
                    if (p == list.size() - 1) {
                        error = true;
                    }
                }

            }
            if (!error) break;
            else Collections.shuffle(list1);
        }

        return builder;
    }
    // C:\Users\Admin\Desktop\Test2.txt
}
