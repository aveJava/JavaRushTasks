package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws  Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();
        reader.close();
        FileInputStream fis = new FileInputStream(file1);
        FileOutputStream fos1 = new FileOutputStream(file2);
        FileOutputStream fos2 = new FileOutputStream(file3);
        int amountBytesInFile = fis.available(); // количество байт в файле
        // номер байта, до которого надо считывать в первый файл
        int indexByte = amountBytesInFile/2;
        byte[] bytesOfFile2 = new byte[indexByte + amountBytesInFile%2];
        byte[] bytesOfFile3 = new byte[indexByte];
        fis.read(bytesOfFile2);
        fis.read(bytesOfFile3);
        if (fis.read() != -1) System.out.println("Ошибка алгоритма");
        fos1.write(bytesOfFile2);
        fos2.write(bytesOfFile3);

        fis.close();
        fos1.close();
        fos2.close();
    }
}
