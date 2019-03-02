package io;

import java.io.*;

public class copy {
public static void main(String[] args) {
	copy1("src/io/abc.txt","abcd.txt");
}
	public static void copy1(String srcpath,String destPath) {
		File src=new File("srcpath");
		File dest=new File("destPath");
		InputStream is=null;
		OutputStream os=null;
		
		try {
			is=new FileInputStream(src);
			os=new FileOutputStream(dest,false);
			String msg="change";
			byte[] flush=new byte[1024];
			int len=-1;
			while((len=is.read(flush))!=-1) {
			os.write(flush,0,len);
			}
			os.flush();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		} finally {
	        try {
	           
	            if (null != os) {
	                os.close();
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
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

