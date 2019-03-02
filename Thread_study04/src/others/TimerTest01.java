package others;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTest01 {
public static void main(String[] args) {
	Timer timer=new Timer();
	timer.schedule(new MyTask(), 1000,200);
}
}
class MyTask extends TimerTask{
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("·Å¿Õ´óÄÔÐÝÏ¢");
		}
		System.out.println("end");
	}
}