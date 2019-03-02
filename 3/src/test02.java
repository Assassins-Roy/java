
public class test02 {
/*public test02() {
	try {
		int i=0,j=0,f;
		Array();
		f=i/j;
		
	}
	catch(ArithmeticException e) {
		System.out.println("除数为0"+e);
		
	}
}

public void Array() {
	// TODO Auto-generated method stub
try {
	int[] a= {1};
	a[1]=3;
	
	
}
catch(ArrayIndexOutOfBoundsException e) {
	System.out.println("数组下标越界"+e);
	
}
}
public static void main(String[] args) {
	new test02();
	
}
}
*/
	
	
	public static void divide() throws ArithmeticException
	{
		throw new ArithmeticException();
		
		
	}
	public static void main(String[] args) {
		try {
			divide();
			
		}
		catch(ArithmeticException e) {
			System.out.println(e);
			
		}
	}
		
	}
	
	