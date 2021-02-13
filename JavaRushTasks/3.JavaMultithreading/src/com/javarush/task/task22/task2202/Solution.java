package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        if (string == null)  throw new TooShortStringException();
        int index1 = string.indexOf(" ") + 1;
        int index2 = index1;
        for (int i = 0; i < 4; i++) {
            index2 = string.indexOf(" ", index2 + 1);
            if (i == 2 && index2 == -1) throw new TooShortStringException();
        }
        if (index2 == -1) index2 = string.length();

        return string.substring(index1, index2);
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
