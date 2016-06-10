package com.java.eight.practice.exercise.chapterone;

import static java.util.Arrays.asList;

import java.io.File;
import java.io.FilenameFilter;

public class ThirdExercise {
	
	//this is how you do it in java 7
	private static File[] listFiles(File directory, String extension) {
		if (!directory.isDirectory()) {
			return null;
		}
		FilenameFilter filenameFilter = new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				return name.contains(extension);
			}
		};
		return directory.listFiles(filenameFilter);
	}
	
	//this is how you do it with lambda
	private static File[] listFilesWithLambda(File directory, String extension) {
		if (!directory.isDirectory()) {
			return null;
		}
		//extension free variable will be captured in our lambda expression
		return directory.listFiles((File subDir, String name) -> { return name.contains(extension);});
	}

	public static void main(String[] args) {
		System.out.println(asList(listFiles(new File("D:\\"), "pdf")).containsAll(asList(listFilesWithLambda(new File("D:\\"), "pdf"))));

	}

}
