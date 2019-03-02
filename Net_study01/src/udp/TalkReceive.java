package udp;

import java.io.IOException;
import java.net.*;

public class TalkReceive implements Runnable{
	private DatagramSocket server;
	public TalkReceive(int port) {
		try {
			server=new DatagramSocket(port);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			byte[] container=new byte[1024*60];
			DatagramPacket packet=new DatagramPacket(container,0,container.length);
			try {
				server.receive(packet);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			byte[] datas=packet.getData();
			int len=packet.getLength();	
			String data=new String(datas,0,len);
			System.out.println(data);
			if(data.equals("bye")) {
				break;
			}
			}
		server.close();
	}
	
}
