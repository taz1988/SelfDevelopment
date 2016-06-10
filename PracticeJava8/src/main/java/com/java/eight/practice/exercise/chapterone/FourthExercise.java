package com.java.eight.practice.exercise.chapterone;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class FourthExercise {

    private static List<File> sortDirectories(File[] filesAndDirectories) {
        Stream<File> sortedDirectories = asList(filesAndDirectories).stream().filter(File::isDirectory).sorted((dir1, dir2) -> dir1.getName().compareTo(dir2.getName()));
        return sortedDirectories.collect(Collectors.toList());
    }

    private static List<File> sortFiles(File[] filesAndDirectories) {
        Stream<File> sortedFiles = asList(filesAndDirectories).stream().filter(File::isFile).sorted((dir1, dir2) -> dir1.getName().compareTo(dir2.getName()));
        return sortedFiles.collect(Collectors.toList());
    }

    private static List<File> sort(File[] filesAndDirectories) {
        List<File> files = sortDirectories(filesAndDirectories);
        files.addAll(sortFiles(filesAndDirectories));
        return files;
    }

    public static void main(String... args) {
        File[] files = new File[]{new File("d:\\c20.png"),new File("d:\\tranings"), new File("D:\\c11.png"), new File("D:\\")};
        sort(files).forEach(System.out::println);
    }
}
