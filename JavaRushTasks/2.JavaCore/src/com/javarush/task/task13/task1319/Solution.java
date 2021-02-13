package com.javarush.task.task13.task1319;

/* 
Писатель в файл с консоли
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new FileWriter(reader.readLine()));

        boolean b = false;
        while (true) {
            String s = reader.readLine();
            if (b) writer.write("\n"); else b = true;
            writer.write(s);
            if ("exit".equals(s)) { break; }
        }

        reader.close();
        writer.close();
    }
}
