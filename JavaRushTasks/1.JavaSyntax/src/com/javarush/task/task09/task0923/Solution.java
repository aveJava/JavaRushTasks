package com.javarush.task.task09.task0923;

/* 
Гласные и согласные
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        int i = s.length();
        char[] c = new char[i];
        c = s.toCharArray();
        ArrayList<Character> vowel = new ArrayList<>();
        ArrayList<Character> consonants = new ArrayList<>();

        for (int a=0; a<i; a++) {
            if (isVowel(c[a])) vowel.add(c[a]);
            else
                if (!Character.isWhitespace(c[a]))
                consonants.add(c[a]);
        }

        for (Character f : vowel) {
            System.out.print(f + " ");
        }

        System.out.println();

        for (Character f : consonants) {
            System.out.print(f + " ");
        }
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам
        for (char d : vowels) {  // ищем среди массива гласных
            if (c == d) {
                return true;
            }
        }
        return false;
    }
}