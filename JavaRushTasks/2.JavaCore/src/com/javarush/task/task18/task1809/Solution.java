package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File file1 = new File(reader.readLine());
        File file2 = new File(reader.readLine());
        reader.close();
        FileInputStream inputStream = new FileInputStream(file1);
        FileOutputStream outputStream = new FileOutputStream(file2);
        byte[] b = new byte[inputStream.available()];
        inputStream.read(b);
        inputStream.close();
        for (int i=b.length - 1; i!=-1; i--) {
            outputStream.write(b[i]);
        }


        outputStream.close();
    }
}
