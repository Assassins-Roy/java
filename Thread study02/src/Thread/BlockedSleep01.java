package Thread;



public class BlockedSleep01 {
	public static void main(String[] args) {
		Web12306 web=new Web12306();
		new Thread(web,"1").start();
		new Thread(web,"2").start();
		new Thread(web,"3").start();
	}
}
 class Web12306 implements Runnable {
private int ticketNums=99;
public void run() {
	while (true) {
		if(ticketNums<0) {
			break;
		}
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"-->"+ticketNums--);
	}
}

}
