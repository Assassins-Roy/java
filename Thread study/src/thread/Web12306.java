package thread;

public class Web12306 implements Runnable {
private int ticketNums=99;
public void run() {
	while (true) {
		if(ticketNums<0) {
			break;
		}
		System.out.println(Thread.currentThread().getName()+"-->"+ticketNums--);
	}
}
public static void main(String[] args) {
	Web12306 web=new Web12306();
	new Thread(web,"1").start();
	new Thread(web,"2").start();
	new Thread(web,"3").start();
}
}
