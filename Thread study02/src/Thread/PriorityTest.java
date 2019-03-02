package Thread;

public class PriorityTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getPriority());
	MyPriority mp=new MyPriority();
	Thread t1=new Thread(mp);
	Thread t2=new Thread(mp);
	Thread t3=new Thread(mp);
	Thread t4=new Thread(mp);
	Thread t5=new Thread(mp);
	Thread t6=new Thread(mp);
	t1.start();
	t2.start();
	t3.start();
	t4.start();
	t5.start();
	t6.start();
	}

}
class MyPriority implements Runnable{
	public void run() {
		System.out.println(Thread.currentThread().getName()+Thread.currentThread().getPriority());
	}
}