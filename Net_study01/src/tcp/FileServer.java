package tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer {
public static void main(String[] args) throws IOException {
	ServerSocket server=new ServerSocket(8888);
	Socket client=server.accept();
	System.out.println("һ���ͻ��˽���������");
	InputStream is=new BufferedInputStream(client.getInputStream() );
	OutputStream os=new BufferedOutputStream(new FileOutputStream("src/tcp.png"));
	byte[] flush=new byte[1024];
	int len=-1;
	while((len=is.read(flush))!=-1) {
		os.write(flush, 0, len);
	}
	os.flush();
	os.close();
	is.close();
	server.close();
}
}
