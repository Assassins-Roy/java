package thread;

public class LambdaTest01 {
	
	static class Like2 implements ILike{
		public void lambda() {
			System.out.println("i like lambda2");
		}}
public static void main(String[] args) {
	ILike like=new Like();
	like.lambda();
	like=new Like2();
	like.lambda();
	
	
}
}
interface ILike{
	void lambda();
	
}
class Like implements ILike{
	public void lambda() {
		System.out.println("i like lambda");
	}
}
