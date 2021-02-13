package com.javarush.task.task15.task1504;

import java.util.LinkedList;
import java.util.List;

/* 
ООП - книги
*/

public class Solution {
    public static void main(String[] args) {
        List<Book> books = new LinkedList<Book>();
        books.add(new MarkTwainBook("Tom Sawyer"));
        books.add(new AgathaChristieBook("Hercule Poirot"));
        System.out.println(books);
    }

    abstract static class Book {
        private String author;

        public Book (String author) {
            this.author = author;
        }

        public abstract Book getBook();

        public abstract String getTitle();

        private String getOutputByBookType() {
            String agathaChristieOutput = author + ": " + getBook().getTitle() + " is a detective";
            String markTwainOutput = getBook().getTitle() + " was written by " + author;

            String output = "output";
            if (this.author.equals("Mark Twain")) {
                output = markTwainOutput;
            }
            if (this.author.equals("Agatha Christie")) {
                output = agathaChristieOutput;
            }

            return output;
        }

        public String toString() {
            return this.getOutputByBookType();
        }
    }


    public static class MarkTwainBook extends Book {
        private String title;
        public MarkTwainBook(String name) {
            super("Mark Twain");
            this.title = name;
        }

        @Override
        public MarkTwainBook getBook() {
            return this;
        }

        @Override
        public String getTitle() {
            return this.title;
        }
    }

    public static class AgathaChristieBook extends Book {
        private String title;
        public AgathaChristieBook (String name) {
            super("Agatha Christie");
            this.title = name;
        }

        @Override
        public AgathaChristieBook getBook() {
            return this;
        }

        @Override
        public String getTitle() {
            return this.title;
        }
    }
}
