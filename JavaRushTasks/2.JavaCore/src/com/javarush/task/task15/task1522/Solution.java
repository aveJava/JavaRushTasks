package com.javarush.task.task15.task1522;

/* 
Закрепляем паттерн Singleton
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static {
        readKeyFromConsoleAndInitPlanet();
    }

    public static void main(String[] args)  throws IOException {

    }

    public static Planet thePlanet;

    //add static block here - добавьте статический блок тут

    public static void readKeyFromConsoleAndInitPlanet() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = null;

        try {
            s = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        switch (s) {
            case "sun": thePlanet = Sun.getInstance(); break;
            case "moon": thePlanet = Moon.getInstance(); break;
            case "earth": thePlanet = Earth.getInstance(); break;
            default: thePlanet = null; break;
        }
    }
}
