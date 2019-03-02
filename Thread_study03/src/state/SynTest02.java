package state;

public class SynTest02 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account account=new Account(100,"���");
		SafeDrawing you=new SafeDrawing(account,80,"��");
		SafeDrawing wife=new SafeDrawing(account,90,"��");
		you.start();
		wife.start();
	}

}

class SafeDrawing extends Thread{
	Account account;
	int drawingMoney;
	int drawingTotal;
	int packetTotal;
	
	public SafeDrawing(Account account, int drawingMoney, String name) {
		super(name);
		this.account = account;
		this.drawingMoney = drawingMoney;
		
	}


	public void run() {
		test();
}
	public synchronized void test() {
		if(account.money-drawingMoney<0) {
			return;
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		account.money-=drawingMoney;
		packetTotal+=drawingMoney;
		System.out.println(this.getName()+"-->�˻���ʣ��Ϊ��"+account.money);
		System.out.println(this.getName()+"-->�ڴ���ʣ��Ϊ��"+packetTotal);
	}
	}
	
