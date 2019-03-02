package udp;

public class TalkTeacher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Thread(new TalkReceive(9999)).start();
		new Thread(new TalkSend(5555,"localhost",8888)).start();
	}

}
