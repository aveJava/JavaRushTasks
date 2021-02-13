package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String> params = new HashMap<>();
        params.put("name", null);
        params.put("country", null);
        params.put("city", null);
        params.put("age", null);

        System.out.println(getQuery(params));
    }

    public static String getQuery(Map<String, String> params) {
        if (params == null) return "";
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, String> pair : params.entrySet()) {
            if (pair.getKey() != null && pair.getValue() != null) {
                if (!pair.getValue().equals("null")) {
                    builder.append(pair.getKey() + " = '" + pair.getValue() + "' and ");
                }
            }
        }
        if (builder.length() > 5) builder.delete(builder.lastIndexOf(" and") , builder.length());

        return builder.toString();
    }
}
