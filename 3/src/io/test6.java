package io;

import java.io.ByteArrayInputStream;

import java.io.IOException;
import java.io.InputStream;

public class test6 {
	public static void main(String[] args) {
		byte[] src="talk is cheap".getBytes();
		InputStream is =null;
		try {
			is=new ByteArrayInputStream(src);
			byte[] flush=new byte[7];
			int len=-1;
			while((len=is.read(flush))!=-1 ) {
				String str=new String(flush,0,len);
				System.out.println(str);
				
		}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
