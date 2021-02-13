package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws Exception  {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();
        BufferedReader reader1 = new BufferedReader(new FileReader(file1));
        BufferedWriter writer2 = new BufferedWriter(new FileWriter(file2));
        while (reader1.ready()) {
            String s =reader1.readLine();
            Pattern pattern = Pattern.compile("");
            s.replaceAll(".", "!");
            writer2.write(s);
        }
        reader1.close();
        writer2.close();
    }
}
