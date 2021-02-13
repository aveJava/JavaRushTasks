package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();
        BufferedReader reader1 = new BufferedReader(new FileReader(file1));
        BufferedReader reader2 = new BufferedReader(new FileReader(file2));
        ArrayList<String> stringsFile1 = new ArrayList<>();
        ArrayList<String> stringsFile2 = new ArrayList<>();
        // заносим все строки из первого файла в массив stringsFile1
        while (reader1.ready()) {
            stringsFile1.add(reader1.readLine());
        }
        // заносим все строки из второго файла в массив stringsFile2
        while (reader2.ready()) {
            stringsFile2.add(reader2.readLine());
        }
        int i1 = 0;     // каретка для строк из первого списка
        int i2 = 0;     // каретка для строк из второго списка
        while (true) {

            // блок выхода за границу массивов строк
            if (i1==stringsFile1.size() && i2==stringsFile2.size()) break;
            if (i1==stringsFile1.size()) {
                lines.add(new LineItem(Type.ADDED, stringsFile2.get(i2)));
                break;
            }
            if (i2==stringsFile2.size()) {
                lines.add(new LineItem(Type.REMOVED, stringsFile1.get(i1)));
                break;
            }

            // если строки одинаковы добавить SAME
            if (stringsFile1.get(i1).equals(stringsFile2.get(i2))) {
                lines.add(new LineItem(Type.SAME, stringsFile1.get(i1)));
                i1++;
                i2++;
            } else if (stringsFile1.get(i1).equals(stringsFile2.get(i2+1))) {
                lines.add(new LineItem(Type.ADDED, stringsFile2.get(i2)));
                i2++;
            } else if (stringsFile1.get(i1+1).equals(stringsFile2.get(i2))) {
                lines.add(new LineItem(Type.REMOVED, stringsFile1.get(i1)));
                i1++;
            } // else System.out.println("Ошибка алгоритма 1");

        }

        reader1.close();
        reader2.close();

//        for (LineItem item : lines) {
//            System.out.println(item.type + " " + item.line);
//        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }

}
