package com.javarush.task.task19.task1913;

/* 
Выводим только цифры
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        PrintStream consol = System.out;
        ByteArrayOutputStream ar = new ByteArrayOutputStream();
        System.setOut(new PrintStream(ar));

        testString.printSomething();

        BufferedReader reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(ar.toByteArray())));
        StringBuilder bild = new StringBuilder();

        while (reader.ready()) {
            String s = reader.readLine();
            System.out.println(s);
            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(s);
            while (matcher.find()) {
                bild.append(matcher.group());
            }
        }
        reader.close();

        System.setOut(consol);
        System.out.println(bild.toString());

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}
