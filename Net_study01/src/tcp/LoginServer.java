package tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginServer {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket server=new ServerSocket(8888);
		Socket client=server.accept();
		System.out.println("һ���ͻ��˽���������");
		DataInputStream dis=new DataInputStream(client.getInputStream());
		String datas=dis.readUTF();
		String[] dataArray=datas.split("&");
		for(String info:dataArray) {
			String[] userInfo=info.split("=");
			if(userInfo[0].equals("uname")) {
				System.out.println("����û���Ϊ"+userInfo[1]);
				}else if(userInfo[0].equals("upwd")) {
				System.out.println("�������Ϊ"+userInfo[1]);
			}
		}
		dis.close();
		client.close();
		server.close();
	}

}
