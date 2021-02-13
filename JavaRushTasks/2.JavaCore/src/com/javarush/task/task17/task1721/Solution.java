package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        /** читаем 2 имени файла
            из первого файла считываем все строки в лист allLines
            из второго файла - в лист forRemoveLines */
        try {
            String file1 = reader.readLine();
            String file2 = reader.readLine();
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file1)));
            BufferedReader reader2 = new BufferedReader(new InputStreamReader(new FileInputStream(file2)));
            while (reader.ready()) {
                allLines.add(reader.readLine());
            }

            while (reader2.ready()) {
                forRemoveLines.add(reader2.readLine());
            }
            reader.close();
            reader2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            new Solution().joinData();
        } catch (CorruptedDataException e) {
            e.printStackTrace();
        }

    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
