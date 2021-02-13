package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String s = reader.readLine();
            if ("exit".equals(s)) break;
            ReadThread t = new ReadThread(s);
            t.start();
        }
        reader.close();
    }

    public static class ReadThread extends Thread {
        String fileName;
        int[] bytes = new int[256];
        int nextByte;

        public ReadThread(String fileName) throws IOException {
            this.fileName = fileName;
        }

        @Override
        public void run() {
            try {
                /**  читаем все байты из файла с массив байт buffer  */
                FileInputStream fis = new FileInputStream(fileName);
                int av = fis.available();
                byte[] buffer = new byte[av];
                fis.read(buffer);
                fis.close();
                /**
                     считаем количество повторений для каждого байта по очереди
                     если повронений получается >=, чем до этого - добавляем
                     в мар. значения в мар будут каждый раз перезатираться.
                 */
                int mAx = 0; // максимальное количество повторений на данный момент
                for (int i = 0; i < av; i++) {
                    int max = 0; // найденное количество повторений текучего байта
                    for (int p = 0; p < av; p++) {
                        if (buffer[i] == buffer[p]) {
                            max++;
                        }
                    }
                    if (max >= mAx) {
                        mAx = max;
                        resultMap.put(fileName, (int) buffer[i]);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }
}
