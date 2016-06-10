package com.java.eight.practice.stream;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class PlayWithStreams {

    public static void main(String[] args) {
        List<String> words = asList("first", "second", "third", "four");

        //count the number of long words in java 7
        int count = 0;
        for (String word : words) {
            if (word.length() > 4) {
                count++;
            }
        }
        System.out.println("Long words length in java 7 : " + count);

        //count the long words in java 8
        System.out.println("Long words length in java 8 : " + words.stream().filter(word -> word.length() > 4).count());

        //create streams different ways
        Stream<String> song = Stream.of("gently", "down", "the", "stream");
        Stream<String> silence = Stream.empty();
        //infinite streams
        Stream<Double> randoms = Stream.generate(Math::random);
        Stream<BigInteger> integers = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE));
    }
}
