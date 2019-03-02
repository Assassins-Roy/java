package thread;

public class StartThread extends Thread{
	
	public void run() {
		for(int i=0;i<20;i++) {
			System.out.println("Ìý¸è");
		}
	}
public static void main(String[] srgs) {
	StartThread st=new StartThread();
	st.start();
	for(int i=0;i<20;i++) {
		System.out.println("code");
	}
}
}
