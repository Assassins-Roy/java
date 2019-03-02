package io;

public class test1 {
public static void main(String[] args) {
	Person p=new Person();
	p.say();
	
	Amplifier am=new Amplifier(p);
	am.say();
	
}
interface Say{
	void say();
	
}
public static class Person implements Say{
	private int voice=1;
	public void say(){
		System.out.println(this.getVoice());
		
	}
	public int getVoice() {
		return voice;
	}

}
public static class Amplifier implements Say{
	private Person p;
	 Amplifier(Person p){
		 this.p=p;
	 }
	public void say() {
		System.out.println(p.getVoice()*10);
	}
}
}
