package com.javarush.task.task14.task1414;

/* 
MovieFactory
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();  //собирать слова в список
        while (true) {
            list.add(reader.readLine());
            // если слово не соответствует ни одному ключу, закончить ввод
            if (!list.get(list.size()-1).equals("soapOpera") &&
                    !list.get(list.size()-1).equals("cartoon") &&
                    !list.get(list.size()-1).equals("thriller")) {
                break;
            }
        }

        Movie movie;
        for (int i=0; i<list.size(); i++) {
            movie = Solution.MovieFactory.getMovie(list.get(i));
            if (i != list.size() - 1) System.out.println(movie.getClass().getSimpleName());;
        }

        /*
8 Создать переменную movie класса Movie и для каждой введенной строки(ключа):
8.1 получить объект используя MovieFactory.getMovie и присвоить его переменной movie
8.2 вывести на экран movie.getClass().getSimpleName()
        */

    }

    static class MovieFactory {

        static Movie getMovie(String key) {
            Movie movie = null;

            // создание объекта SoapOpera (мыльная опера) для ключа "soapOpera"
            if ("soapOpera".equals(key)) {
                movie = new SoapOpera();
            }

            // создание объекта Cartoon (мультфильм) для ключа "cartoon"
            if ("cartoon".equals(key)) {
                movie = new Cartoon();
            }

            // создание объекта Thriller (триллер) для ключа "thriller"
            if ("thriller".equals(key)) {
                movie = new Thriller();
            }

            return movie;
        }
    }

    static abstract class Movie {
    }

    static class SoapOpera extends Movie {
    }

    static class Cartoon extends Movie {
    }

    static class Thriller extends Movie {
    }
}
