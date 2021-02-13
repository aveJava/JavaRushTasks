package com.javarush.task.task20.task2022;

import jdk.internal.org.objectweb.asm.commons.SerialVersionUIDAdder;

import java.io.*;
import java.lang.reflect.Field;  //  <- это убрать

/* 
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    private static final long serialVersionUID = 1L;

    private transient FileOutputStream stream;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        //out.writeObject(out);

        String path = null;
        try {
            Field pathField = FileOutputStream.class.getDeclaredField("path");
            pathField.setAccessible(true);
            path = (String) pathField.get(stream);
            System.out.println(path);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        out.writeObject(path);

        //String s = stream.getFD();

        //out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();

        stream = new FileOutputStream(String.valueOf(in.readObject()), true);
        //stream =
        //in.close();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws Exception {
        // создаем и записываем строку в объект
        Solution sol = new Solution("C:\\Users\\Admin\\Desktop\\Test2.txt");
        sol.writeObject("This is a data for test.");

        // сериализуем
        FileOutputStream outStream = new FileOutputStream("C:\\Users\\Admin\\Desktop\\Test1.txt");
        ObjectOutputStream out = new ObjectOutputStream(outStream);
        out.writeObject(sol);
        out.close();

        // десериализуем
        FileInputStream inStream = new FileInputStream("C:\\Users\\Admin\\Desktop\\Test1.txt");
        ObjectInputStream in = new ObjectInputStream(inStream);
        Solution sol2 = (Solution) in.readObject();
        in.close();

        // записываем в новый объект данные
        sol2.writeObject("One more line");

        sol2.close();
    }
}

//class Cat {
//    String name;
//    int weight;
//    int age;
//
//    public Cat(String name, int weight, int age) {
//        this.name = name;
//        this.weight = weight;
//        this.age = age;
//    }
//}
