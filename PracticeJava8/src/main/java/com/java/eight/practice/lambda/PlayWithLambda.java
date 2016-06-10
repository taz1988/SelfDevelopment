package com.java.eight.practice.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PlayWithLambda {
	
	private static void threadLambda() {
		System.out.println("This is a thread lambda");
	}
	
	interface Person {
		long getId();
		default String getName() { return "John Q. Public"; }
		}

    public static void main(String[] args) {
    	
        //See how you implement Comparator with Lambda expression
    	String testOne = "ABC";
        String testTwo = "EFGHIJKL";
        Comparator<String> comparator = (first, second) -> Integer.compare(first.length(), second.length());
        
        //Use a method reference to create a lambda expression, which create a comparator.
        Comparator<String> comparator2 = String::compareToIgnoreCase;
        System.out.println(comparator.compare(testOne, testTwo));
        System.out.println(comparator2.compare(testOne, testTwo));
        
        //Use Runnable lambda
        Thread thread = new Thread(PlayWithLambda::threadLambda);
        thread.start();
        
        //Use constructor reference
        List<StringBuffer> numbers = Arrays.asList(new StringBuffer("haha"), new StringBuffer("hihi"));
        Stream<String> stream = numbers.stream().map(String::new);
        List<String> finalConversion = stream.collect(Collectors.toList());
    }

}
