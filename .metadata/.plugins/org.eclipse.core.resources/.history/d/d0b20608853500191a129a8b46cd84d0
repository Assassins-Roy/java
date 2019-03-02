package chat01;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		System.out.println("---Client---");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请输入用户名");
		String name=br.readLine();
		Socket client=new Socket("localhost",8888);
		new Thread(new Send(client,name)).start();
		new Thread(new Receive(client)).start();
		
		
		
	
	 
		}
	}


