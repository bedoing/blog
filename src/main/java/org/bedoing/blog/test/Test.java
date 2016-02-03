package org.bedoing.blog.test;

import java.io.File;

public class Test {

	public static void main(String[] args) {
		File f = new File("TileTest.doc");
		System.out.println(getFileExtension(f.getName()));
	}
	
	private static String getFileExtension(String fileName) {
		return fileName.substring(fileName.lastIndexOf("."));
	}
}
