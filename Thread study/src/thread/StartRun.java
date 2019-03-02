package thread;

public class StartRun implements Runnable {
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<20;i++) {
			System.out.println("Ìý¸è");
		}}
	
public static void main(String[] args) {
	StartRun st=new StartRun();
	Thread t=new Thread(st);
	t.start();
	for(int i=0;i<20;i++) {
		System.out.println("coding");
	}
}




}
