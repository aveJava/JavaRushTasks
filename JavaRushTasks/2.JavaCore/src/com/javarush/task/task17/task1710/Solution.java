package com.javarush.task.task17.task1710;

import java.io.BufferedReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static com.javarush.task.task17.task1710.Sex.FEMALE;
import static com.javarush.task.task17.task1710.Sex.MALE;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat ft1 = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        SimpleDateFormat ft2 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);


        if ("-c".equals(args[0])) {
            if ("м".equals(args[2])) {
                allPeople.add(Person.createMale(args[1], ft1.parse(args[3])));
            }
            if ("ж".equals(args[2])) {
                allPeople.add(Person.createFemale(args[1], ft1.parse(args[3])));
            }
            System.out.println(allPeople.size()-1);
        }

        if ("-u".equals(args[0])) {
            Person person = allPeople.get(Integer.parseInt(args[1]));
            person.setSex(("м".equals(args[3])) ? MALE : FEMALE);
            person.setName(args[2]);
            person.setBirthDate(ft1.parse(args[4]));
        }

        if ("-d".equals(args[0])) {
            allPeople.get(Integer.parseInt(args[1])).setBirthDate(null);
            allPeople.get(Integer.parseInt(args[1])).setName(null);
            allPeople.get(Integer.parseInt(args[1])).setSex(null);
        }

        if ("-i".equals(args[0])) {
            Person person = allPeople.get(Integer.parseInt(args[1]));
            String sex = null;

            switch (person.getSex()) {
                case MALE:
                    sex = "м";
                    break;
                case FEMALE:
                    sex = "ж";
                    break;
            }

            System.out.println(person.getName() + " " + sex + " " + ft2.format(person.getBirthDate()));

        }
    }

}
