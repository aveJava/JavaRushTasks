package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String file = buffer.readLine();
        buffer.close();
        FileOutputStream outputStream = new FileOutputStream(file);

        PrintStream consol = System.out;

        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(byteArray);
        System.setOut(stream);

        testString.printSomething();

        System.setOut(consol);

        String result = byteArray.toString();
        outputStream.write(result.getBytes());
        outputStream.close();
        System.out.println(result);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

