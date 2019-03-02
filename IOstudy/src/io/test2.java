package io;

public class test2 {
public static void main(String[] args) {
	Coffee coffee=new Coffee();
	Drink suger=new suger(coffee);
	System.out.println(suger.info()+"-->"+suger.cost());
	Drink milk=new Milk(coffee);
	System.out.println(milk.info()+"-->"+milk.cost());
	milk=new Milk(suger);
	System.out.println(milk.info()+"-->"+milk.cost());
}
}
interface Drink{
	double cost();
	String info();
	
}
 class Coffee implements Drink{
	private String name="¿§·È";
	public double cost() {
		return 10;
	}
	@Override
	public String info() {
		// TODO Auto-generated method stub
		return name;
	}
}
 class Decorate implements Drink{
	private Drink drink;
	public Decorate(Drink drink) {
		this.drink=drink;
	}
	public double cost() {
		return this.drink.cost();
	}
	@Override
	public String info() {
		// TODO Auto-generated method stub
		return this.drink.info();
	}
}
class Milk extends Decorate{

	public Milk(Drink drink) {
		super(drink);
		// TODO Auto-generated constructor stub
	}
	public double cost() {
		return super.cost()+4;
				}
	public String info() {
		return super.info()+"jialeniulai";
	}
	
}
class suger extends Decorate{

	public suger(Drink drink) {
		super(drink);
		// TODO Auto-generated constructor stub
	}
	public double cost() {
		return super.cost()+2;
				}
	public String info() {
		return super.info()+"jialetang";
	}
}