package com.javarush.task.task19.task1904;

/* 
И еще один адаптер
*/



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    public static void main(String[] args) throws Exception {
//
//        PersonScannerAdapter adapter = new PersonScannerAdapter(new Scanner(new FileReader("C:\\Users\\Admin\\Desktop\\Test.txt")));
//
//            System.out.println(adapter.read());
//            System.out.println(adapter.read());

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String line = fileScanner.nextLine();
            Pattern pattern = Pattern.compile("([^\\s]+)\\s([^\\s]+)\\s([^\\s]+)\\s(\\d+?\\s\\d+\\s\\d+)");
            Matcher matcher = pattern.matcher(line);
            matcher.find();
            String firstName = matcher.group(2);
            String middleName = matcher.group(3);
            String lastName = matcher.group(1);
            SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH);
            Date birthDate = new Date();
            try {
                birthDate  = format.parse(matcher.group(4));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return new Person(firstName, middleName, lastName, birthDate);
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }

    }
}
