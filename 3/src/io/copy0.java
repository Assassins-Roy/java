package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class copy0 {

	public static void main(String[] args) {
		
			File src=new File("abc.txt");
			File dest=new File("ab.txt");
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
