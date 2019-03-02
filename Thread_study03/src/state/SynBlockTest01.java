package state;

public class SynBlockTest01 {
public static void main(String[] args) {
	Account account=new Account(500,"���");
	SynDrawing you=new SynDrawing(account,80,"��");
	SynDrawing wife=new SynDrawing(account,90,"��");
	you.start();
	wife.start();
}
}
class SynDrawing extends Thread{
	Account account;
	int drawingMoney;
	int packetTotal;
	
	public SynDrawing(Account account, int drawingMoney, String name) {
		super(name);
		this.account = account;
		this.drawingMoney = drawingMoney;
		
	}


	public void run() {
		test();
}
	public void test() {
		synchronized(account) {
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
		System.out.println(this.getName()+"-->�˻���ʣ��Ϊ:"+account.money);
		System.out.println(this.getName()+"-->�ڴ���ʣ��Ϊ:"+packetTotal);
	}
	}
	}