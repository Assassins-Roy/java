package state;

public class UnsateTest02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account account=new Account(100,"���");
		Drawing you=new Drawing(account,80,"��");
		Drawing wife=new Drawing(account,90,"��");
		you.start();
		wife.start();
	}

}

class Drawing extends Thread{
	Account account;
	int drawingMoney;
	int drawingTotal;
	int packetTotal;
	
	public Drawing(Account account, int drawingMoney, String name) {
		super(name);
		this.account = account;
		this.drawingMoney = drawingMoney;
		
	}


	public void run() {
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
