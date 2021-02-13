package com.javarush.task.task16.task1632;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new oneThread());
        threads.add(new twoThread());
        threads.add(new threeThread());
        threads.add(new fourThread());
        threads.add(new fiveThread());
    }

    public static void main(String[] args) {

    }

    public static class oneThread extends Thread {
        @Override
        public void run() {
            while (true) {

            }
        }
    }

    public static class twoThread extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");;
            }
        }
    }

    public static class threeThread extends Thread {
        @Override
        public void run() {
            while (true) {
                System.out.println("Ура");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class fourThread extends Thread implements Message {

        @Override
        public void run() {
            while (!isInterrupted()) {

            }
            
        }

        @Override
        public void showWarning() {
            this.interrupt();
        }
    }

    public static class fiveThread extends Thread {
        @Override
        public void run() {
            int sum = 0;
            while (true) {
                Scanner scanner = new Scanner(System.in);
                String s = scanner.nextLine();
                if ("N".equals(s) || s.isEmpty()) {
                    System.out.println(sum);
                    break;
                }
                int arg = 0;
                try {
                    arg = Integer.parseInt(s);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                sum = sum + arg;
            }
        }
    }

}

