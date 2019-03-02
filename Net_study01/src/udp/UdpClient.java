package udp;


import java.net.*;


public class UdpClient {
public static void main(String[] args) throws Exception {
	System.out.println("发送方启动中。。。");
	DatagramSocket client=new DatagramSocket(8888);
	String data="深圳";
	byte[] datas=data.getBytes();
	DatagramPacket packet=new DatagramPacket(datas,0,datas.length,
			new InetSocketAddress("localhost",9999));
	client.send(packet);
	client.close();
}
}
