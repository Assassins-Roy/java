package udp;


import java.net.*;


public class UdpClient {
public static void main(String[] args) throws Exception {
	System.out.println("���ͷ������С�����");
	DatagramSocket client=new DatagramSocket(8888);
	String data="����";
	byte[] datas=data.getBytes();
	DatagramPacket packet=new DatagramPacket(datas,0,datas.length,
			new InetSocketAddress("localhost",9999));
	client.send(packet);
	client.close();
}
}
