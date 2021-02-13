package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));



            StringBuilder bild = new StringBuilder();
            while (reader.ready()) {
                String str = reader.readLine();
                String[] words = str.split(" ");

                for (String s : words) {
                    if (s.length() > 6) {
                        bild.append(s).append(",");  // .trim()
                    }
                }


            }

            bild.deleteCharAt(bild.length()-1);
            writer.write(bild.toString());

            reader.close();
            writer.close();

        }

}


//    boolean b1 = true;
//        while (reader.ready()) {
//                String str = reader.readLine();
//                String[] words = str.split(" ");
//                StringBuilder bild =
//
//                boolean b = true;
//                for (String s : words) {
//                if (s.length() > 6) {
//                if (!b1) writer.write(","); else b1 = false;
//                if (!b) writer.write(","); else b = false;
//                writer.write(s);
//                }
//                }
//                }
//
//                reader.close();
//                writer.close();
