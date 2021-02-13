package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.*;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(scanner.nextLine()), "UTF-8"));
        StringBuilder builder = new StringBuilder();
        while (reader.ready()) {
            builder.append(reader.readLine() + " ");
        }
        ArrayList<String> words = new ArrayList<>(Arrays.asList(builder.toString().split(" ")));
        boolean b = false;
        while (true) {
            for (int i = 1; i < words.size(); i++) {
                // если пара слов соответствует, то создаем Pair
                if (words.get(0).equals(new StringBuilder(words.get(i)).reverse().toString())) {
                    Solution.Pair pair = new Pair();
                    pair.first = words.get(0);
                    pair.second = words.get(i);
                    // если Pair получился уникальный, то с = false
                    boolean c = false;
                    for (Solution.Pair pair1 : result) {
                        if (pair.equals(pair1)) {
                            c = true;
                            break;
                        }
                    }
                    // если уникальный, то добавляем его, удаляем оба элемента из
                    // words и выходим из ццикла, если нет - то ничего не делаем
                    if (!c) {
                        result.add(pair);
                        words.remove(i);
                        words.remove(0);
                        break;
                    }

                }
                if (i + 1 == words.size()) words.remove(0);
            }
            if (words.size() < 2) break;
        }
        // System.out.println(result);      <- проверка
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }
// C:\Users\Admin\Desktop\Test2.txt
}
