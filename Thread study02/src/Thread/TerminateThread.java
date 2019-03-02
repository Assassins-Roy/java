package Thread;

public class TerminateThread implements Runnable {
private boolean flag =true;
private String name;

public TerminateThread(String name) {
	this.name=name;
}
	
public void run() {
	int i=0;
	while(flag) {
		System.out.println(name+"-->"+i++);
	}
}
public void terminate() {
	this.flag=false;
}
public static void main(String[] args) {
	// TODO Auto-generated method stub
TerminateThread tt=new TerminateThread("me");
	new Thread(tt).start();
	for(int i=0;i<=99;i++) {
		if(i==88) {
			tt.terminate();
			System.out.println("game over");
		}
		System.out.println("main"+i);
	}
}
}
