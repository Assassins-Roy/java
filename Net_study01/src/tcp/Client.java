package tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		Socket client=new Socket("localhost",8888);
		DataOutputStream dos=new DataOutputStream(client.getOutputStream());
		String data="hello";
		dos.writeUTF(data);
		dos.flush();
		dos.close();
		client.close();
	}

}
