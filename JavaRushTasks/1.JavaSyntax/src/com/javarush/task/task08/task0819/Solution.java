package com.javarush.task.task08.task0819;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* 
Set из котов
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();
        ArrayList list = new ArrayList(cats);
        cats.remove(list.get(0));

        printCats(cats);
    }

    public static Set<Cat> createCats() {
        Set cats = new HashSet(3);
        cats.add(new Cat());
        cats.add(new Cat());
        cats.add(new Cat());

        return cats; // тут был null
    }

    public static void printCats(Set<Cat> cats) {
        for (Cat cat : cats) {
            System.out.println(cat);
        }
    }

    public static class Cat {

    }
}
