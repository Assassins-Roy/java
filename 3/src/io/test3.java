package io;

import java.io.*;

public class test3 {
public static void main(String[] args) {
	File src=new File("abc.txt");
	InputStream is =null;
	try {
		is=new FileInputStream(src);
		int temp;
		while((temp=is.read())!=-1 ) {
			System.out.println((char)temp);
			
	}
	}catch (FileNotFoundException e) {
		e.printStackTrace();
	}catch (IOException e) {
		e.printStackTrace();
	}finally {
		try {
			if(null!=is) {
				is.close();
				
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
}
