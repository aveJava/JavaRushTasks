package com.javarush.task.task20.task2002;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.*;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream("C:\\Users\\Admin\\Desktop\\Test2.txt");
            InputStream inputStream = new FileInputStream("C:\\Users\\Admin\\Desktop\\Test2.txt");

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.users.add(new User("Anastasia", "S", new Date(), false, User.Country.OTHER));
            javaRush.users.add(new User("Kirill", "D", new Date(), true, User.Country.RUSSIA));
            javaRush.users.add(new User("Oleg", "F", new Date(), true, User.Country.RUSSIA));

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);

            outputStream = new FileOutputStream("C:\\Users\\Admin\\Desktop\\Test1.txt");
            loadedObject.save(outputStream);

            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            if (javaRush.hashCode() == loadedObject.hashCode()) {
                if (javaRush.equals(loadedObject)) {
                    System.out.println(true);
                } else System.out.println(false);
            } else System.out.println(false);

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));

            if (users.size()>0) {
                for (User u : users) {
                    // имя
                    if (!"null".equals(u.getFirstName())) {
                        writer.write(u.getFirstName() + "\n");
                    } else { writer.write("!null!\n"); }
                    // фамилия
                    if (!"null".equals(u.getLastName())) {
                        writer.write(u.getLastName() + "\n");
                    } else { writer.write("!null!\n"); }
                    // дата
                    if (!"null".equals(String.valueOf(u.getBirthDate()))) {
                        writer.write(Long.toString(u.getBirthDate().getTime()) + "\n");
                    } else { writer.write("!null!\n"); }
                    // пол
                    if ("false".equals(String.valueOf(u.isMale()))) {
                        writer.write("false\n");
                    } else { writer.write("true\n"); }
                    // страна
                    if (!"null".equals(u.getCountry().toString())) {
                        writer.write(u.getCountry().getDisplayName() + "\n");
                    } else { writer.write("!null!\n"); }
                }
            }

            writer.close();
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            while (reader.ready()) {
                User user = new User();

                String nextString;
                // имя
                if (!(nextString = reader.readLine()).equals("!null!")) {
                    user.setFirstName(nextString);
                }
                // фамилия
                if (!(nextString = reader.readLine()).equals("!null!")) {
                    user.setLastName(nextString);
                }
                // дата
                if (!(nextString = reader.readLine()).equals("!null!")) {
                    user.setBirthDate(new Date(Long.parseLong(nextString)));
                }
                // пол
                if (!(nextString = reader.readLine()).equals("false")) {
                    user.setMale(true);
                }
                // страна
                if (!(nextString = reader.readLine()).equals("!null!")) {
                    switch (nextString) {
                        case "Russia":
                            user.setCountry(User.Country.RUSSIA);
                            break;
                        case "Ukraine":
                            user.setCountry(User.Country.UKRAINE);
                            break;
                        case "Other":
                            user.setCountry(User.Country.OTHER);
                            break;
                    }
                }

                users.add(user);
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
