package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String file = scanner.nextLine();
        scanner.close();

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        Pattern pattern = Pattern.compile("^\\d+");
        while (reader.ready()) {
            String line = reader.readLine();
            Matcher matcher = pattern.matcher(line);
            matcher.find();
            if (args[0].equals(matcher.group())) {
                System.out.println(line);
            }
        }
        reader.close();
    }
}
