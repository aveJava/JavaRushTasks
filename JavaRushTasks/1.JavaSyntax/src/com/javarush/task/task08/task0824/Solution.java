package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        Human grandfather1 = new Human("name1", true, 86);
        Human grandmather1 = new Human("name2", false, 85);
        Human grandfather2 = new Human("name3", true, 84);
        Human grandmather2 = new Human("name4", false, 81);
        Human father = new Human("name5", true, 56);
        Human mather = new Human("name6", false, 53);
        Human son = new Human("name7", true, 24);
        Human daughter1 = new Human("name8", false, 26);
        Human daughter2 = new Human("name9", false, 22);

        grandfather1.children.add(father);
        grandmather1.children.add(father);
        grandfather2.children.add(mather);
        grandmather2.children.add(mather);
        father.children.add(son);
        father.children.add(daughter1);
        father.children.add(daughter2);
        mather.children.add(son);
        mather.children.add(daughter1);
        mather.children.add(daughter2);

        System.out.println(grandfather1.toString());
        System.out.println(grandmather1.toString());
        System.out.println(grandfather2.toString());
        System.out.println(grandmather2.toString());
        System.out.println(father.toString());
        System.out.println(mather.toString());
        System.out.println(son.toString());
        System.out.println(daughter1.toString());
        System.out.println(daughter2.toString());
    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<>();

        public Human (String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public String toString () {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }
}
