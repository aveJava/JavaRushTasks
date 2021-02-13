package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> list = new ArrayList<>();
        Queue<Path> queue = new LinkedList<>();
        queue.add(Paths.get(root));

        while (!queue.isEmpty()) {
            Path path = queue.poll();
            if (!Files.isDirectory(path)) {
                list.add(path.toString());
            } else {
                try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path)) {
                    directoryStream.forEach(queue::add);
                }
            }
        }

        return list;
    }

    public static void main(String[] args) throws IOException {

    }
}
