package io;

import java.io.*;


public class test4 {
public static void main(String[] args) {
	File dest=new File("dest.txt");
	OutputStream os=null;
	
	
	try {
		os=new FileOutputStream(dest,false);
		String msg="change";
		byte[] datas=msg.getBytes();
		os.write(datas,0,datas.length);
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
    }
	
}
}
