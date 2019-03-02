package cooperation;

public class CoTest01 {
public static void main(String[] args) {
	SynContainer container=new SynContainer();
	new Productor(container).start();
	new Consumer(container).start();
}
}
class Productor extends Thread{
	SynContainer container;
	public Productor(SynContainer container) {
		this.container=container;
	}
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("����-->"+i+"����ͷ");
			container.push(new Steamedbun(i));
		}
	}
}
class Consumer extends Thread{
	SynContainer container;
	public Consumer(SynContainer container) {
		this.container=container;
	}
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("����-->"+container.pop().id+"����ͷ");
			container.push(new Steamedbun(i));
		}
	}
}
class SynContainer{
	Steamedbun[] buns=new Steamedbun[10];
	int count=0;
	public synchronized void push(Steamedbun bun) {
		if(count==buns.length) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		buns[count]=bun;
		count++;
		this.notifyAll();
	}
	public synchronized Steamedbun pop() {
		if(count==0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		count--;
		 Steamedbun bun=buns[count];
		 this.notifyAll();
		 return bun;
	}
}
class Steamedbun{
	int id;
	public Steamedbun(int id) {
		this.id = id;
	}
	
}