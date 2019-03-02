package chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TMultiChat {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("---Server---");
		ServerSocket server=new ServerSocket(8888);
		while(true) {
		Socket client=server.accept();
		System.out.println("一个客户端建立了连接");
		
		new Thread(()-> {
		DataInputStream dis = null;
		try {
			dis = new DataInputStream(client.getInputStream());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		DataOutputStream dos = null;
		try {
			dos = new DataOutputStream(client.getOutputStream());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		boolean isRunning=true;
		while(isRunning) {
		String msg;
		try {
			msg=dis.readUTF();
			dos.writeUTF(msg);
			dos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			isRunning=false;
		}
		
		}
		try {
			dos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			dis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			client.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}).start();
		 
		 
	}
	}
}
