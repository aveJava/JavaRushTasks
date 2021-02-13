package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.*;

/* 
Знакомство с properties
*/
public class Solution {

    public static Map<String, String> runtimeStorage = new HashMap<>();

//    static {
//        runtimeStorage.put("one o","1");
//        runtimeStorage.put("two t","2");
//        runtimeStorage.put("three","3");
//    }

    public static void save(OutputStream outputStream) throws Exception {
        Properties pr = new Properties();
        Iterator<Map.Entry<String, String>> iterator = runtimeStorage.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            pr.setProperty(entry.getKey(), entry.getValue());
        }
        pr.store(outputStream, "Map<String, String> runtimeStorage");
    }

    public static void load(InputStream inputStream) throws IOException {
        Properties pr = new Properties();
        pr.load(inputStream);
        pr.forEach((k,v) -> runtimeStorage.put(String.valueOf(k), String.valueOf(v)));
    }

    public static void main(String[] args) throws Exception {
//        FileOutputStream out = new FileOutputStream("C:\\Users\\Admin\\Desktop\\Test2.txt");
//        save(out);
//        runtimeStorage.clear();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fos = new FileInputStream(reader.readLine())) {
            load(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(runtimeStorage);

//        for (Map.Entry s : runtimeStorage.entrySet()) {
//            System.out.println(s.getKey() + "  " + s.getValue());
//        }
    }
    // C:\Users\Admin\Desktop\Test2.txt
}
