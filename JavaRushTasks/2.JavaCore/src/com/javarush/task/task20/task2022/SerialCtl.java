package com.javarush.task.task20.task2022;

import java.io.*;

public class SerialCtl implements Serializable {

        private String a;
        private transient String b;

        public SerialCtl(String aa, String bb) {	// Конструктор
            a = "Not Transient: " + aa;
            b = "Transient: " + bb;
        }

        public String toString() { return a + "\n" + b; }

        private void writeObject(ObjectOutputStream stream) throws IOException {
            stream.defaultWriteObject();
            stream.writeObject(b);
        }

        private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
            stream.defaultReadObject();
            b = (String) stream.readObject();
        }
        public static void main(String[] args) throws IOException, ClassNotFoundException {
            SerialCtl sc = new SerialCtl("Test1", "Test2");
            System.out.println("Before:\n" + sc);

            // Выводим объект sc в буфер buf:
            ByteArrayOutputStream buf= new ByteArrayOutputStream();
            ObjectOutputStream o = new ObjectOutputStream(buf);
            o.writeObject(sc);

            // Теперь получаем объект sc обратно:
            ByteArrayInputStream input = new ByteArrayInputStream(buf.toByteArray());
            ObjectInputStream in = new ObjectInputStream(input);
            SerialCtl sc2 = (SerialCtl) in.readObject();

            System.out.println("After:\n" + sc2);
        }

}
