package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        BufferedWriter writer = new BufferedWriter(new FileWriter(scanner.nextLine()));
        BufferedReader reader1 = new BufferedReader(new FileReader(scanner.nextLine()));
        BufferedReader reader2 = new BufferedReader(new FileReader(scanner.nextLine()));
        scanner.close();

        while (reader1.ready()) {
            writer.write(reader1.readLine());
        }
        reader1.close();
        writer.flush();

        while (reader2.ready()) {
            writer.write(reader2.readLine());
        }
        reader2.close();

        writer.close();
    }
}
