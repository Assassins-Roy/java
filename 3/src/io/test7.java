package io;

import java.io.*;

public class test7 {
	public static void main(String[] args) {
		File src=new File("dest.txt");
		InputStream is=null;
		BufferedInputStream bis=null;
		
		
		try {
			is=new FileInputStream(src);
			bis=new BufferedInputStream(is);
			
			byte[]flush=new byte[1024];
			int len=-1;
			while((len=is.read(flush))!=-1) {
				String str=new String(flush,0,len);
				System.out.println(str);
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		} finally {
	        try {
	           
	            if (null != bis) {
	                bis.close();
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
		
	}
}
