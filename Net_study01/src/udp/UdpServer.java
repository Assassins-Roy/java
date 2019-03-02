package udp;

import java.net.*;

public class UdpServer {
public static void main(String[] args) throws Exception {
	System.out.println("接受方启动中。。。");
	DatagramSocket server=new DatagramSocket(6666);
	byte[] container=new byte[1024*60];
	DatagramPacket packet=new DatagramPacket(container,0,container.length);
	server.receive(packet);
	byte[] datas=packet.getData();
	int len=packet.getLength();	
	System.out.println(new String(datas,0,len));
}
}
