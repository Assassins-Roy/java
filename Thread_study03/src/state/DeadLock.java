package state;

public class DeadLock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Markup g1=new Markup(1,"��֥");
		Markup g2=new Markup(0,"����");
		g1.start();
		g2.start();
	}

}
class Lipstick{
	
}
class Mirror{
	
}
class Markup extends Thread{
	static Lipstick lipstick=new Lipstick();
	static Mirror mirror=new Mirror();
	int choice;
	String girl;
	public Markup(int choice,String gril) {
		this.choice=choice;
		this.girl=gril;
	}
	public void run() {
		markup();
	}
	private void markup(){
		if(choice==0) {
			synchronized (lipstick) {
				System.out.println(this.girl+"��ÿں�");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			/*
			synchronized (mirror) {
				System.out.println(this.girl+"�վ���");
			}*/
		}
			synchronized (mirror) {
				System.out.println(this.girl+"�վ���");
			}
		}else {
			synchronized(mirror) {
				System.out.println(this.girl+"�վ���");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}/*
				synchronized(lipstick) {
					System.out.println(this.girl+"Ϳ�ں�");
				}*/
			}
			synchronized(lipstick) {
				System.out.println(this.girl+"Ϳ�ں�");
			}
		}
	}
}
