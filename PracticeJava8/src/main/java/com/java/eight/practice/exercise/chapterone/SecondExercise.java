package com.java.eight.practice.exercise.chapterone;

import static java.util.Arrays.asList;

import java.io.File;
import java.io.FileFilter;

public class SecondExercise {

	//This is how you do before java 8
	public static File[] returnAllDirectory(File file) {
		if (!file.isDirectory()) {
			return null;
		}
		FileFilter fileFilter = new FileFilter() {
			
			@Override
			public boolean accept(File subFile) {
				return subFile.isDirectory();
			}
		};
		return file.listFiles(fileFilter);
	}
	
	//this is how you do with Lambda
	public static File[] returnAllDirectoryWithoutFileFilter(File file) {
		if (!file.isDirectory()) {
			return null;
		}
		return file.listFiles((subFile) -> {return subFile.isDirectory();});
	}
	
	//this is how you do with method reference
	public static File[] returnAllDirectoryWithoutLambda(File file) {
		if (!file.isDirectory()) {
			return null;
		}
		return file.listFiles(File::isDirectory);
	}
	
	public static void main(String[] args) {
		System.out.println(asList(returnAllDirectory(new File("D:\\"))).containsAll(asList(returnAllDirectoryWithoutFileFilter(new File("D:\\")))));
		System.out.println(asList(returnAllDirectory(new File("D:\\"))).containsAll(asList(returnAllDirectoryWithoutLambda(new File("D:\\")))));
	}

}
