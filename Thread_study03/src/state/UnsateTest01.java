package state;



public class UnsateTest01 {
	public static void main(String[] args) {
		UnsafeWeb12306 web=new UnsafeWeb12306();
		new Thread(web,"1").start();
		new Thread(web,"2").start();
		new Thread(web,"3").start();
	}
}
 class UnsafeWeb12306 implements Runnable {
private int ticketNums=10;
private boolean flag=true;
public void run() {
	while (flag) {
		test();
	}
}
public void test() {
	if(ticketNums<0) {
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
