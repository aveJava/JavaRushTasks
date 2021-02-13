package com.javarush.task.task14.task1415;

import java.util.ArrayList;
import java.util.List;

/* 
Клининговый центр
*/

public class Solution {
    public static void main(String[] args) {
        List<Apartment> apartments = new ArrayList<Apartment>();
        apartments.add(new OneRoomApt());
        apartments.add(new TwoRoomApt());
        apartments.add(new ThreeRoomApt());

        cleanAllApartments(apartments);
    }

    public static void cleanAllApartments(List<Apartment> apartments) {
        for (int i = 0; i <apartments.size(); i++) {
            Apartment apartment = apartments.get(i);

            if (apartment instanceof OneRoomApt) {
                OneRoomApt room = (OneRoomApt) apartment;
                room.clean1Room();
            }

            if (apartment instanceof TwoRoomApt) {
                TwoRoomApt room = (TwoRoomApt) apartment;
                room.clean2Rooms();
            }

            if (apartment instanceof ThreeRoomApt) {
                ThreeRoomApt room = (ThreeRoomApt) apartment;
                room.clean3Rooms();
            }
        }
    }

    static interface Apartment {
    }

    static class OneRoomApt implements Apartment {
        void clean1Room() {
            System.out.println("1 room is cleaned");
        }
    }

    static class TwoRoomApt implements Apartment {
        void clean2Rooms() {
            System.out.println("2 rooms are cleaned");
        }
    }

    static class ThreeRoomApt implements Apartment {
        void clean3Rooms() {
            System.out.println("3 rooms are cleaned");
        }
    }
}
