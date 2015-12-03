package com.tcl.mie.mail;

public class FileNameTest {

	public static void main(String[] args) {
		String name = "one(123).zip";
		String fileName  = name.substring(0, name.indexOf("(")) + name.substring(name.indexOf("."));
		Long categoryId = Long.parseLong(name.substring(name.indexOf("(")+1, name.indexOf(")")));
		
		
		System.out.println("fileName:  " + fileName);
		System.out.println("categoryId:  " + categoryId);
	}

}
