package com.javarush.task.task07.task0707;

/* 
Что за список такой?
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> st = new ArrayList<>();
        st.add("sf");
        st.add("sfsf");
        st.add("sfsf");
        st.add("sfsff");
        st.add("sfsfsfsf");
        System.out.println(st.size());
        for (String s : st) {
            System.out.println(s);
        }
    }
}
