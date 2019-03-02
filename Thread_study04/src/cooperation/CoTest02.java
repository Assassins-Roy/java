package cooperation;

public class CoTest02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tv tv=new Tv();
		new Player(tv).start();
		new Watcher(tv).start();
		
	}

	
}
class Player extends Thread{
	Tv tv;

	public Player(Tv tv) {
		
		this.tv = tv;
	}
	public void run() {
		for(int i=0;i<20;i++){
		if(i%2==0) {
			this.tv.play("����˵");
		}else {
			this.tv.play("��ƿ����");
		}
		}
	}
}
class Watcher extends Thread{
	Tv tv;

	public Watcher(Tv tv) {
		
		this.tv = tv;
	}
	public void run() {
		for(int i=0;i<20;i++){
			tv.watch();
			}
	}
}
class Tv{
	String voice;
	boolean flag=true;
	
	public synchronized void play(String voice) {
		if(!flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("�����ˣ�"+voice);
		this.voice=voice;
		this.notifyAll();
		this.flag=!this.flag;
	}
	public synchronized void watch() {
		if(flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("�����ˣ�"+voice);
		this.notifyAll();
		this.flag=!this.flag;
	}
}