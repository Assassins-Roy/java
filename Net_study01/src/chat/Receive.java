package chat;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Receive implements Runnable{
	private DataInputStream dis;
	private Socket client;
	private boolean isRunning=true;
	public Receive( Socket client) {
		this.client=client;
		try {
			dis=new DataInputStream(client.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("====2====");
			release();
		}
	}
	private String receive() {
		String msg="";
		try {
			msg=dis.readUTF();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("====4====");
	release();
		}
		return msg;
	}
	public void run() {
		// TODO Auto-generated method stub
		while(isRunning) {
			String msg=receive();
			if(!msg.equals("")) {
				System.out.println(msg);
			}
		}
	}
	private void release() {
		this.isRunning=false;
		SxtUtils.close(dis,client);
	}
}
