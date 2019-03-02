package tcp;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class FileClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		Socket client=new Socket("localhost",8888);
		InputStream is=new BufferedInputStream(new FileInputStream("src/ndl.png"));
		OutputStream os=new BufferedOutputStream(client.getOutputStream());
		byte[] flush=new byte[1024];
		int len=-1;
		while((len=is.read(flush))!=-1) {
			os.write(flush, 0, len);
		}
		os.flush();
		os.close();
		is.close();
		client.close();
	}

}
