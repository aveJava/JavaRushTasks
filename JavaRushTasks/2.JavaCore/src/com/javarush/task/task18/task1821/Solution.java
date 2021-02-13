package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        // получаем в массив byteArray все байты из файла
        FileInputStream input = new FileInputStream(args[0]);
        byte[] byteArray = new byte[input.available()];
        input.read(byteArray);
        input.close();

        // массив bytes заполняем так, чтобы в каждой ячейке хранилось количество
        // повторений символа, кодом которого является индекс этой ячейки
        int[] bytes = new int[256];
        for (int i = 0; i < byteArray.length; i++) {
            bytes[byteArray[i]]++;
        }

        // выводим на экран в формате "символ_ASCII количество_повторений"
        for (int i = 0; i < 256; i++) {
            if (bytes[i] != 0) {
                System.out.println((char) i + " " + bytes[i]);
            }
        }
    }
}
