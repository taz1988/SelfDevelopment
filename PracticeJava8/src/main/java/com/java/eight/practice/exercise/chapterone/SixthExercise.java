package com.java.eight.practice.exercise.chapterone;

import java.util.ArrayList;
import java.util.List;

public class SixthExercise {


    public static void main(String... args) {
        String[] names = { "Peter", "Paul", "Mary" };
        List<Runnable> runners = new ArrayList<>();
        for (String name : names)
            runners.add(() -> System.out.println(name));
    }

}
