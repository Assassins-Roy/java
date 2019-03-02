package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpTalkServer {
	public static void main(String[] args) throws Exception {
		System.out.println("接受方启动中。。。");
		DatagramSocket server=new DatagramSocket(6666);
		while(true) {
		byte[] container=new byte[1024*60];
		DatagramPacket packet=new DatagramPacket(container,0,container.length);
		server.receive(packet);
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
