package io;

import java.io.*;


public class FileUtils {
	public static void main(String[] args) {
		
		try {
			InputStream is=new FileInputStream("abc.txt");
			OutputStream os=new FileOutputStream("abc-copy.txt");
			copy(is,os);
			}catch(IOException e) {
				e.printStackTrace();
			}
		byte[] datas=null;
		try {
			InputStream is=new FileInputStream("img_ss_06.jpg");
			ByteArrayOutputStream os=new ByteArrayOutputStream();
			copy(is,os);
			  datas=os.toByteArray();
			System.out.println(datas.length);
			}catch(IOException e) {
				e.printStackTrace();
			}
		try {
			InputStream is=new ByteArrayInputStream(datas);
			OutputStream os=new FileOutputStream("img.jpg");
			copy(is,os);
			}catch(IOException e) {
				e.printStackTrace();
			}
	
	}

	public static void copy(InputStream is,OutputStream os) {
		
		
		try {
			
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
