package io;
import java.io.*;
public class test3 {
public static void main(String[] srgs) {
	try(BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter writer =new BufferedWriter(new OutputStreamWriter(System.out));){
		String msg="";
		while(!msg.equals("exit")) {
			msg=reader.readLine();
			writer.write(msg);
			writer.newLine();
			writer.flush();
		}
	}catch(IOException e) {
		System.out.println("“Ï≥£");
		
	}
}
}
