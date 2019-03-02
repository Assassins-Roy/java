package chat02;

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
		System.out.println("һ���ͻ��˽���������");
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
				this.send("��ӭ��ĵ���");
				sendOthers(this.name+"������������",true);
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
			boolean isPrivate=msg.startsWith("@");
			if(isPrivate) {
				int idx=msg.indexOf(":");
				String targetName=msg.substring(1,idx);
				msg=msg.substring(idx+1);
				for(Channel other:all) {
					if(other.name.equals(targetName)) {
						other.send(this.name+"����˵"+msg);
					}
				}
			}else {
				for(Channel other:all) {
				if(other==this) {
					continue;
				}
				if(!isSys) {
				other.send(this.name+"��������˵��"+msg);
				}else {
					other.send(msg);
				}
			}
			}
		}
		private void release() {
			this.isRunning=false;
			SxtUtils.close(dis,dos,client);
			all.remove(this);
			sendOthers(this.name+"�뿪���ͥ",true);
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