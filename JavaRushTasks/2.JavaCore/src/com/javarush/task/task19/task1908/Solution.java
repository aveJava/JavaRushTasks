package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File file1 = new File(reader.readLine());
        File file2 = new File(reader.readLine());
        reader.close();
        reader = new BufferedReader(new FileReader(file1));
        BufferedWriter outputStream = new BufferedWriter(new FileWriter(file2));

        while (reader.ready()) {
            String s = reader.readLine();
            Pattern pattern = Pattern.compile("\\b\\d+\\b");
            Matcher matcher = pattern.matcher(s);
            while (matcher.find()) {
                outputStream.write(matcher.group() + " ");
            }
        }

        reader.close();
        outputStream.close();
    }
}
