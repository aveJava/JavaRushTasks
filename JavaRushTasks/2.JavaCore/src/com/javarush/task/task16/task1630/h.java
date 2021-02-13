package com.javarush.task.task16.task1630;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class h {
    public static void main(String[] args) throws Exception {
        StringBuilder str = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\Admin\\Desktop\\Test.txt")));
        while (reader.ready()) {
            str.append(reader.readLine() + "\n");
        }
        System.out.println(str);
    }
}
