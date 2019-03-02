package state;

public class SynTest01 {
	public static void main(String[] args) {
		SafeWeb12306 web=new SafeWeb12306();
		new Thread(web,"1").start();
		new Thread(web,"2").start();
		new Thread(web,"3").start();
	}
}
 class SafeWeb12306 implements Runnable {
private int ticketNums=10;
private boolean flag=true;
public void run() {
	while (flag) {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test();
	}
}
public synchronized void test() {
	if(ticketNums<=0) {
		flag=false;
		return;
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
