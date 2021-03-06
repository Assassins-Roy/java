package chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Chat {
	private static CopyOnWriteArrayList<Channel> all=new CopyOnWriteArrayList<Channel>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("---Server---");
		ServerSocket server=new ServerSocket(8888);
		while(true) {
		Socket client=server.accept();
		System.out.println("一个客户端建立了连接");
		Channel c=new Channel(client);
		all.add(c);
		new Thread(c).start();
		
		 
	}
	}
	static class Channel implements Runnable{
		private DataInputStream dis;
		private DataOutputStream dos;
		private Socket client;
		private boolean isRunning;
		private String name;
		public Channel(Socket client) {
			this.client=client;
			try {
				dis = new DataInputStream(client.getInputStream());
				dos = new DataOutputStream(client.getOutputStream());
				isRunning=true;
				this.name=receive();
				this.send("欢迎你的到来");
				sendOthers(this.name+"来到了聊天室",true);
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
		private void sendOthers(String msg,boolean isSys) {
			for(Channel other:all) {
				if(other==this) {
					continue;
				}
				if(!isSys) {
				other.send(this.name+"对所有人说："+msg);
				}else {
					other.send(msg);
				}
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
				sendOthers(msg,false);	
				}
			}
		}
	}
}
