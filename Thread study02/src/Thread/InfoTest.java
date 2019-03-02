package Thread;

public class InfoTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
     System.out.println(Thread.currentThread().isAlive());
	MyInfo info=new MyInfo("Õ½¶·»ú");
	Thread t=new Thread(info);
	t.setName("¹«¼¦");
	t.start();
	Thread.sleep(1000);
	System.out.println(t.isAlive());
	}

}
class MyInfo implements Runnable{
	private String name;
	public MyInfo(String name) {
		
		this.name=name;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName()+"-->"+name);
	}
}