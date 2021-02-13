package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String file = scanner.nextLine();
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        BufferedReader reader1 = new BufferedReader(new FileReader(file));
        BufferedReader reader2 = new BufferedReader(new FileReader(scanner.nextLine()));
        scanner.close();

        while (reader2.ready()) {
            writer.write(reader2.readLine());
        }

        while (reader1.ready()) {
            writer.write(reader1.readLine());
        }

        reader1.close();
        reader2.close();
        writer.close();

    }
}
