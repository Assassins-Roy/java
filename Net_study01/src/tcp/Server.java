package tcp;

import java.io.DataInputStream;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
public static void main(String[] args) throws IOException {
	ServerSocket server=new ServerSocket(8888);
	Socket client=server.accept();
	System.out.println("һ���ͻ��˽���������");
	DataInputStream dis=new DataInputStream(client.getInputStream());
	String data=dis.readUTF();
	System.out.println(data);
	dis.close();
	client.close();
	server.close();
}
}
