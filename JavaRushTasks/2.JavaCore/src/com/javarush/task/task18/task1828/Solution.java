package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws Exception {
        if(args.length == 0 || (!args[0].equals("-u") && !args[0].equals("-d"))) {return;}

        Scanner scanner = new Scanner(System.in);
        String file = scanner.nextLine();
        scanner.close();
        BufferedReader reader = new BufferedReader(new FileReader(file));

        /**
          Перебираем все строки из файла.
          Если ID в строке не совпадает с искомым, то добавляем ее в list.
          Если совпадает, то в зависимости от первого параметра (-u или -d)
          либо ничего не добавляем в массив и переходим к след. строке в файле,
          либо добавляем новую строку, собраную из переданных аргументов.  */

        Pattern pattern = Pattern.compile("^\\d{1,8}");
        ArrayList<String> list = new ArrayList<>();
        while (reader.ready()) {
            String line = reader.readLine();
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                if (matcher.group().equals(args[1])) {
                    if (args[0].equals("-u")) {
                        list.add(String.format("%-8d%-30s%-8.2f%-4d", Integer.parseInt(matcher.group()), args[2], Float.parseFloat(args[3]), Integer.parseInt(args[4])));
                    }
                } else {
                    list.add(line);
                }
            }
        }
        reader.close();

        // очищаем файл
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.close();

        // выводим все строки из list в файл
        writer = new BufferedWriter(new FileWriter(file, true));
        int u = 10;
        for (int i = 0; i < list.size(); i++) {
            writer.write(list.get(i));
            if (i < list.size()-1) {
                writer.write("\n");
            }
        }

        writer.flush();
        writer.close();

    }
}
