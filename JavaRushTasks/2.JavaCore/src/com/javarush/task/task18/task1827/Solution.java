package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.Formatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws Exception {
        if(args.length == 0 || !args[0].equals("-c")) {return;}

        Scanner scanner = new Scanner(System.in);
        String file = scanner.nextLine();
        scanner.close();
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));

        Pattern pattern = Pattern.compile("^\\d{1,8}");
        int maxID = 0;

        while (reader.ready()) {
            String s = reader.readLine();
            Matcher matcher = pattern.matcher(s);
            if (matcher.find()) {
                int thisLineID = Integer.parseInt(matcher.group());
                if (thisLineID > maxID) {
                    maxID = thisLineID;
                }
            }
        }
        reader.close();

        writer.write(String.format("\n%-8d%-30s%-8.2f%-4d", (maxID + 1), args[1], Float.parseFloat(args[2]), Integer.parseInt(args[3])));
        writer.flush();
        writer.close();

    }
}
