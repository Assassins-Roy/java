package chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiChat {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("---Server---");
		ServerSocket server=new ServerSocket(8888);
		Socket client=server.accept();
		System.out.println("һ���ͻ��˽���������");
		DataInputStream dis=new DataInputStream(client.getInputStream());
		DataOutputStream dos=new DataOutputStream(client.getOutputStream());
		boolean isRunning=true;
		while(isRunning) {
		String msg=dis.readUTF();
		dos.writeUTF(msg);
		dos.flush();
		}
		 dos.close();
		    dis.close();
		    client.close();
	}
	
}
