package udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class TalkSend implements Runnable{
	private DatagramSocket client;
	private BufferedReader reader;
	private String tolP;
	private int toPort;
	public TalkSend(int port,String tolP,int toPort) {
		this.tolP=tolP;
		this.toPort=toPort;
		try {
			client=new DatagramSocket(port);
			 reader=new BufferedReader(new InputStreamReader(System.in));
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void run() {
		while(true) {
			String data;
			try {
				data=reader.readLine();
			byte[] datas=data.getBytes();
			DatagramPacket packet=new DatagramPacket(datas,0,datas.length,
					new InetSocketAddress(this.tolP,this.toPort));
			client.send(packet);
			if(data.equals("bye")) {
				break;
			}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		client.close();
	}
}
