package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedWriter write = new BufferedWriter(new FileWriter(args[2]));
        BufferedReader reade = new BufferedReader(new FileReader(args[1]));

        FileInputStream reader = new FileInputStream(args[1]);
        FileOutputStream writer = new FileOutputStream(args[2]);


        if ("-e".equals(args[0])) {
            while (reader.available() > 0) {
                writer.write(reader.read() + 1);
            }
        }

        if ("-d".equals(args[0])) {
            while (reader.available() > 0) {
                writer.write(reader.read() - 1);
            }
        }








//        if ("-e".equals(args[0])) {
//            while (reader.ready()) {
//                String s = new StringBuilder(reader.readLine()).reverse().toString();
//                if (reader.ready()) writer.write(s + "\n");
//                else writer.write(s);
//            }
//        }
//
//        if ("-d".equals(args[0])) {
//            while (reader.ready()) {
//                String s = new StringBuilder(reader.readLine()).reverse().toString();
//                if (reader.ready()) writer.write(s + "\n");
//                else writer.write(s);
//            }
//        }

        reader.close();
        writer.close();

    }

}
