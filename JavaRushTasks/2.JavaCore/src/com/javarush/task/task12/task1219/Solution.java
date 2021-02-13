package com.javarush.task.task12.task1219;

/* 
Создаем человека
*/

public class Solution {
    public static void main(String[] args) {

    }

    public interface CanFly {
        public void fly();
    }

    public interface CanRun {
        public void run();
    }

    public interface CanSwim {
        public void swim();
    }


    public abstract class Human implements CanRun, CanSwim {

    }

    public abstract class Duck implements CanRun, CanSwim, CanFly {

    }

    public abstract class Penguin implements CanRun, CanSwim {

    }

    public abstract class Airplane implements CanFly, CanRun {

    }
}