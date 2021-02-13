package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader(consoleReader.readLine()));
        consoleReader.close();
        StringBuilder builder = new StringBuilder();
        while (reader.ready()) {
            builder.append(reader.readLine());
        }
        reader.close();

        ArrayList<Item> list = new ArrayList<>();
        Pattern pattern = Pattern.compile("<(/?\\w+)[^>]*>");
        Matcher matcher = pattern.matcher(builder.toString());
        while (matcher.find()) {
            list.add(new Item(matcher.group(1), matcher.group(1).charAt(0) != '/' ? matcher.start() : matcher.end()));
        }

        Stack stack = new Stack();
        Map<Integer, Integer> sequences = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            if (!stack.empty()) {
                Item item = (Item) stack.peek();
                if (("/" + item.tag).equals(list.get(i).tag)) {
                    stack.pop();
                    if (item.tag.equals(args[0])) sequences.put(item.index, list.get(i).index);
                } else {
                    stack.push(list.get(i));
                }
            } else {
                stack.push(list.get(i));
            }
        }

        TreeMap<Integer, Integer> tree = new TreeMap<>(sequences);
        tree.forEach((k, v) -> System.out.println(builder.substring(k, v)));

        // C:\Users\Admin\Desktop\Test2.txt
    }
}
