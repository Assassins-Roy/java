package chat;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class MultiClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		System.out.println("---Client---");
		Socket client=new Socket("localhost",8888);
		DataOutputStream dos=new DataOutputStream(client.getOutputStream());
		DataInputStream dis=new DataInputStream(client.getInputStream());
		BufferedReader console=new BufferedReader(new InputStreamReader(System.in));
		boolean isRunning=true;
		while(isRunning) {
		String msg = console.readLine();
		
		dos.writeUTF(msg);
		dos.flush();
		
	    msg=dis.readUTF();
	    System.out.println(msg);
		}
	    dos.close();
	    dis.close();
	    client.close();
		}
	}


