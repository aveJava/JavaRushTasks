package com.javarush.task.task16.task1630;

import java.io.*;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();  // <- это я добавил, этого тут не было

        try {
            System.out.println(f.getFileContent());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent() throws IOException;

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface {
        private String fileName;
        StringBuilder str = new StringBuilder();

        @Override
        public void setFileName(String fullFileName) {
            this.fileName = fullFileName;
        }

        @Override
        public String getFileContent() {

            return str.toString();
        }

        @Override
        public void run() {

            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
                while (reader.ready()) {
                    str.append(reader.readLine() + " ");  // \n возможно лишнее!
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            getFileContent();
        }
    }
}
