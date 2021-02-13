package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));

        while (reader.ready()) {
            String str = reader.readLine();
            String[] words = str.split(" ");

            Pattern pattern = Pattern.compile("\\d");
            for (String s : words) {
                Matcher matcher = pattern.matcher(s);
                if (matcher.find()) {
                    writer.write(s + " ");
                }
            }
        }

        reader.close();
        writer.close();

    }
}
