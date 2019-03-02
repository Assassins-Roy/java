package tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginTwoServer {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket server=new ServerSocket(8888);
		Socket client=server.accept();
		System.out.println("一个客户端建立了连接");
		DataInputStream dis=new DataInputStream(client.getInputStream());
		String datas=dis.readUTF();
		String uname="";
		String upwd="";
		String[] dataArray=datas.split("&");
		for(String info:dataArray) {
			String[] userInfo=info.split("=");
			if(userInfo[0].equals("uname")) {
				System.out.println("你的用户名为"+userInfo[1]);
				uname=userInfo[1];
				}else if(userInfo[0].equals("upwd")) {
				System.out.println("你的密码为"+userInfo[1]);
				upwd=userInfo[1];
			}
		}
		DataOutputStream dos=new DataOutputStream(client.getOutputStream());
		if(uname.equals("shsxt")&&upwd.equals("laopei")) {
			dos.writeUTF("登陆成功");
		}else {
			dos.writeUTF("用户名或密码错误");
		}
		dos.flush();
		dis.close();
		client.close();
		server.close();
	}

}
