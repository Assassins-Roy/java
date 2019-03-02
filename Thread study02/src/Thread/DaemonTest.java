package Thread;

public class DaemonTest {
public static void main(String[] args) {
	God god=new God();
	You you=new You();
	Thread t=new Thread(god);
	t.setDaemon(true);
	t.start();
	new Thread(you).start();
}
}

class You  implements Runnable{
	public void run() {
		for(int i=0;i<=365*100;i++) {
			System.out.println("happy life");
		}
		System.out.println("ooooo....");
	}
}

class God  implements Runnable{
	public void run() {
		for(;true;) {
			System.out.println("bless you");
		}
	}
}