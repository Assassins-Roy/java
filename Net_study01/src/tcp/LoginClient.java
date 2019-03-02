package tcp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class LoginClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		BufferedReader console=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请输入用户名");
		String uname=console.readLine();
		System.out.println("请输入密码");
		String upwd=console.readLine();
		Socket client=new Socket("localhost",8888);
		DataOutputStream dos=new DataOutputStream(client.getOutputStream());
		
		
		dos.writeUTF("uname="+uname+"&"+"upwd="+upwd);
		dos.flush();
		dos.close();
		client.close();
	}

}
