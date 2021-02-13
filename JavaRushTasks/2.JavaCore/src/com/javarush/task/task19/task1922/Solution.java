package com.javarush.task.task19.task1922;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();
        reader = new BufferedReader(new FileReader(file));

        while (reader.ready()) {
            String s = reader.readLine();
            String[] words = s.split(" ");
            Pattern pattern = Pattern.compile("\\p{Punct}$");
            for (int i = 0; i < words.length; i++) {
                Matcher matcher = pattern.matcher(words[i]);
                if (matcher.find()) {
                    words[i] = words[i].substring(0, words[i].length() - 1);
                }
            }

            int d = 0;  // количество совпадений в текущей строке
            for (int t = 0; t < Solution.words.size(); t++) {
                String word = Solution.words.get(t);
                for (int i = 0; i < words.length; i++) {
                    if (word.equals(words[i])) {
                        d++;
                    }
                }
            }

            if (d == 2) {
                System.out.println(s);
                System.out.println();
            }
        }

        reader.close();
    }
}
