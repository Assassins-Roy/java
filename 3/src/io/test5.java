package io;

import java.io.File;
import java.io.FileNotFoundException;

import java.io.FileReader;
import java.io.IOException;

import java.io.Reader;

public class test5 {
	public static void main(String[] args) {
		File src=new File("dest.txt");
		Reader reader=null;
		
		
		try {
			reader=new FileReader(src);
			char[] flush=new char[8];
			int len=-1;
			while((len=reader.read(flush))!=-1) {
				String str=new String(flush,0,len);
				System.out.println(str);
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		} finally {
	        try {
	           
	            if (null != reader) {
	                reader.close();
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
		
	}
}
