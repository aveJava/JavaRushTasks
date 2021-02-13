package com.javarush.task.task10.task1012;

import javax.swing.text.html.parser.Entity;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* 
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Алфавит
        List<Character> alphabet = Arrays.asList(
                'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж',
                'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о',
                'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц',
                'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я');

        // Ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }

        // создаем карту, где ключами будут буквы из alfabet
        // в значения будем заносить сколько раз они встретятся
        Map<Character, Long> map = new HashMap<>();
        for (int i = 0; i < alphabet.size(); i++) {
            map.put(alphabet.get(i), (long) 0);
        }

        // перебираем по очереди введенные строки и при помощи метода schot
        // считаем сколько раз встретились буквы
        // результаты для каждой буквы заносим в карту

        for (String s : list) {
            schot(s,map);
        }

        // распечатываем полученную карту
        for (int i = 0; i < alphabet.size(); i++) {
            System.out.println(alphabet.get(i) + " " + map.get(alphabet.get(i)));
        }

    }

    public static void schot (String s, Map<Character, Long> map) {
        char[] result = s.toCharArray();
        for (Character c : map.keySet()) {
            for (int i = 0; i < result.length; i++) {
                if (c == result[i]) {map.put(c, map.get(c) + 1);}
            }
        }
    }

}
