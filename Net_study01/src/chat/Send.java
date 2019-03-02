package chat;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Send implements Runnable{
	private BufferedReader console;
	private DataOutputStream dos;
	private Socket client;
	private boolean isRunning=true;
	private String name;
	public Send(Socket client,String name) {
		this.client=client;
		console=new BufferedReader(new InputStreamReader(System.in));
		this.name=name;
	try {
		 dos=new DataOutputStream(client.getOutputStream());
		 send(name);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println("====1====");
		this.release();
	}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(isRunning) {
			String msg=getStrFromConsole();
			if(!msg.equals("")) {
				send(msg);
			}
		}
	}
	private void send(String msg) {
		try {
			dos.writeUTF(msg);
			dos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("====3====");
			release();
		}
		
	}
	private String getStrFromConsole() {
		try {
			return console.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	private void release() {
		this.isRunning=false;
		SxtUtils.close(dos,client);
	}
}
