package chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TMultiChat2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("---Server---");
		ServerSocket server=new ServerSocket(8888);
		while(true) {
		Socket client=server.accept();
		System.out.println("一个客户端建立了连接");
		new Thread(new Channel(client)).start();
		
		 
	}
	}
	static class Channel implements Runnable{
		private DataInputStream dis;
		private DataOutputStream dos;
		private Socket client;
		private boolean isRunning;
		public Channel(Socket client) {
			this.client=client;
			try {
				dis = new DataInputStream(client.getInputStream());
				dos = new DataOutputStream(client.getOutputStream());
				isRunning=true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				release();
			}
			
		}
		private String receive() {
			String msg="";
			try {
				msg=dis.readUTF();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				release();
			}
			return msg;
		}
		private void send(String msg) {
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				release();
			}
			
		}
		private void release() {
			this.isRunning=false;
			SxtUtils.close(dis,dos,client);
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(isRunning) {
				String msg=receive();
				if(!msg.equals("")) {
				send(msg);	
				}
			}
		}
	}
}
