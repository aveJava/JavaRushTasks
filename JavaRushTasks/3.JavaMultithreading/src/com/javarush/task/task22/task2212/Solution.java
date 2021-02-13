package com.javarush.task.task22.task2212;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null || telNumber.length() < 9) return false;
        String num = telNumber.replaceAll("\\D", "");
        if ((telNumber.charAt(0) == '+' && num.length() != 12) || (telNumber.charAt(0) != '+' && num.length() != 10))
            return false;

        Pattern pattern = Pattern.compile("(\\+?\\d*(\\(\\d{3}\\))?\\d*\\-?\\d+-?\\d+)");
        Matcher matcher = pattern.matcher(telNumber);
        if (matcher.find()) {
            if (telNumber.equals(matcher.group())) return true;
            else return false;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
