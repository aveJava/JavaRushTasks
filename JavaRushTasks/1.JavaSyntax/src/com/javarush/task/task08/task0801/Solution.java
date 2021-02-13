package com.javarush.task.task08.task0801;

/* 
Set из растений
*/

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Set<String> s = new HashSet<>();
        s.add("арбуз");
        s.add("банан");
        s.add("вишня");
        s.add("груша");
        s.add("дыня");
        s.add("ежевика");
        s.add("женьшень");
        s.add("земляника");
        s.add("ирис");
        s.add("картофель");
        for (String l : s) {
            System.out.println(l);
        }
    }
}
