package com.javarush.task.task14.task1419;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {      //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        try {                                   // 2
            int[] iu = new int[5];
            int a = iu[6];

        } catch (ArrayIndexOutOfBoundsException e) {
            exceptions.add(e);
        }

        try {                                   // 3
            Object o = new Character('p');
            int a = (Integer) o;

        } catch (ClassCastException e) {
            exceptions.add(e);
        }

        try {                                   // 4
            int[] iu = new int[-5];

        } catch (NegativeArraySizeException e) {
            exceptions.add(e);
        }

        try {                                   // 5
            int[] nNulArray = null;
            int a = nNulArray.length;

        } catch (NullPointerException e) {
            exceptions.add(e);
        }

        try {                                   // 6
            char a = "afafaffa".charAt(50);

        } catch (StringIndexOutOfBoundsException e) {
            exceptions.add(e);
        }

        exceptions.add(new OneException());
        exceptions.add(new TwoException());
        exceptions.add(new ThreeException());
        exceptions.add(new FourException());

    }

    public static class OneException extends Exception {}
    public static class TwoException extends Exception {}
    public static class ThreeException extends Exception {}
    public static class FourException extends Exception {}

}
