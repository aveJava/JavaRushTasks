package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void c_Method (String[] argS) throws ParseException {
        SimpleDateFormat ft1 = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        int amount = (argS.length - 1) / 3;
        for (int i = 0; i < amount; i++) {
            String[] args = {"", argS[1 + 3*i], argS[2 + 3*i], argS[3 + 3*i]};
            if ("м".equals(args[2])) {
                allPeople.add(Person.createMale(args[1], ft1.parse(args[3])));
            }
            if ("ж".equals(args[2])) {
                allPeople.add(Person.createFemale(args[1], ft1.parse(args[3])));
            }
            System.out.println(allPeople.size()-1);
        }
    }

    public static void u_Method (String[] argS) throws ParseException {
        SimpleDateFormat ft1 = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        int amount = (argS.length - 1) / 4;
        for (int i = 0; i < amount; i++) {
            String[] args = {"", argS[1 + 4 * i], argS[2 + 4 * i], argS[3 + 4 * i], argS[4 + 4 * i]};
            Person person = allPeople.get(Integer.parseInt(args[1]));
            person.setSex(("м".equals(args[3])) ? Sex.MALE : Sex.FEMALE);
            person.setName(args[2]);
            person.setBirthDate(ft1.parse(args[4]));
        }
    }

    public static void d_Method (String[] args) {
        int amount = args.length - 1;
        for (int i = 1; i <= amount; i++) {
            allPeople.get(Integer.parseInt(args[i])).setBirthDate(null);
            allPeople.get(Integer.parseInt(args[i])).setName(null);
            allPeople.get(Integer.parseInt(args[i])).setSex(null);
        }
    }

    public static void i_Method (String[] args) {
        SimpleDateFormat ft2 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        int amount = args.length - 1;
        for (int i = 1; i <= amount; i++) {
            Person person = allPeople.get(Integer.parseInt(args[i]));
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

    public static void main(String[] args) throws ParseException {

        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    c_Method(args);
                    break;
                }
            case "-u":
                synchronized (allPeople) {
                    u_Method(args);
                    break;
                }
            case "-d":
                synchronized (allPeople) {
                    d_Method(args);
                    break;
                }
            case "-i":
                synchronized (allPeople) {
                    i_Method(args);
                    break;
                }
        }
    }
}
