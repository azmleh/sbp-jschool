package com.sbt.jschool;

import org.w3c.dom.ls.LSOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    public static HashMap<String, Integer> read(String filename) {
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            ArrayList list = new ArrayList();
            HashMap<String, Integer> words = new HashMap<String, Integer>();
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split("\\s+");
                for (int i = 0; i < parts.length; i++) {
                    if (parts[i].isEmpty()) continue;
                    Integer count = 1;
                    if (words.containsKey(parts[i])) count = words.get(parts[i]) + 1;
                    words.put(parts[i], count);
                }
            }
            return words;
        } catch (FileNotFoundException ex) {
            return null;
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> words = Main.read("src/com/sbt/jschool/Main.java");
        System.out.println(words.size());
        List<String> sorted = new ArrayList<String>();
        sorted.addAll(words.keySet());
        Collections.sort(sorted, new Comparator<String>() {
            public int compare(String str1, String str2) {
                Integer l1 = str1.length();
                Integer l2 = str2.length();
                if (l1 == l2) return str1.compareTo(str2);
                return (l1 > l2 ? -1 : 1);
            }
        });
        sorted.forEach(str -> System.out.println(str + ": " + words.get(str)));

    }
}
