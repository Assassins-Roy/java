package Thread;

import java.lang.Thread.State;

public class AllState {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t=new Thread(()->{
			for(int i=0;i<5;i++) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			System.out.println("...");
			}
		});
		
		State state=t.getState();
		System.out.println(state);
		t.start();
		state=t.getState();
		System.out.println(state);
		while(state !=Thread.State.TERMINATED) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			state=t.getState();
			System.out.println(state);
		}
	}

}
