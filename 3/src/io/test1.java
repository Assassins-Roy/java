package io;

import java.io.*;

public class test1 {
public static void main(String[] args) {
	String path="D:/workplace/3/src/io/img_ss_06.jpg";
	File src=new File(path);
	System.out.println(src.length());
	src=new File("D:/workplace/3/src/io/img_ss_06.jpg");
	System.out.println(src.length());	
}
}
