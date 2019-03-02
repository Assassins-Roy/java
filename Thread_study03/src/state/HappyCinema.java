package state;

import java.util.ArrayList;
import java.util.List;

public class HappyCinema {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> available=new ArrayList<Integer>();
		available.add(1);
		available.add(2);
		available.add(3);
		available.add(6);
		available.add(7);
		List<Integer> seats1=new ArrayList<Integer>();
		seats1.add(1);
		seats1.add(2);
		List<Integer> seats2=new ArrayList<Integer>();
		seats2.add(3);
		seats2.add(7);
		seats2.add(6);
		Cinema c=new Cinema(available,"happy");
		new Thread(new Customer(c,seats1),"zzy").start();
		new Thread(new Customer(c,seats2),"aaa").start();
	}

}
class Customer implements Runnable{
	Cinema cinema;
	List<Integer> seats;
	public Customer(Cinema cinema,List<Integer> seats) {
		this.cinema=cinema;
		this.seats=seats;
		
	}
	public void run() {
		synchronized(cinema) {
		boolean flag=cinema.bookTickets(seats);
		if(flag) {
			System.out.println("出票成功"+Thread.currentThread().getName()+"位置为"+seats);
		}else {
			System.out.println("出票失败"+Thread.currentThread().getName()+"位置不够");
		}
		}
	}
}
class Cinema {
	List<Integer> available;
	String name;

	public Cinema(List<Integer> available, String name) {
		
		this.available = available;
		this.name = name;
	}
	public boolean bookTickets(List<Integer> seats) {
		System.out.println("可用位置为："+available);
		List<Integer> copy=new ArrayList<Integer>();
		copy.addAll(available);
		
		copy.removeAll(seats);
		if(available.size()-copy.size()!=seats.size()) {
			return false;
		}
		available=copy;
		return true;
	}
}