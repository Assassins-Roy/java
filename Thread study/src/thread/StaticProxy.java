package thread;

public class StaticProxy {
public static void main(String[] args) {
	new WeddingCompany(new You()).happyMarry();
	
}
}
interface Marry{
	void happyMarry();
	
}
 class You implements Marry {
	public void happyMarry() {
		System.out.println("dark souls");
	}
}
 class WeddingCompany implements Marry{
	 private Marry target;
	 public WeddingCompany(Marry target) {
		 this.target=target;
		 
	 }
	 public void happyMarry() {
	this.target.happyMarry();	 
	 }
 }
