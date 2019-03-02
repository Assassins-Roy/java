package io;
import java.io.*;
import java.net.URL;

public class test4 {
public static void main(String[] args) {
	try(InputStreamReader is=new InputStreamReader(new URL("http://www.baidu.com").openStream(),"UTF-8");){
		int temp;
		while((temp=is.read())!=-1) {
			System.out.print((char)temp);
		}
	}catch(IOException e) {
		System.out.println("“Ï≥£");
	}
}
}
