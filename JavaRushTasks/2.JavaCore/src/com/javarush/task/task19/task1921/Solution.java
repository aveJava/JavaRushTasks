package com.javarush.task.task19.task1921;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));

        while (reader.ready()) {
            Pattern pattern = Pattern.compile("(.+ )+?(\\d+ \\d+ \\d+)");
            Matcher matcher = pattern.matcher(reader.readLine());
            matcher.find();
            SimpleDateFormat format = new SimpleDateFormat("d M yyyy");
            PEOPLE.add(new Person(matcher.group(1).trim(), format.parse(matcher.group(2))));
        }

        reader.close();
    }
}
