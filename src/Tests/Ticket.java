package Tests;

import java.util.*;

public final class Ticket implements Runnable {
	class Queue<T> {
		private LinkedList<T> list = new LinkedList<T>();
		
		public void in(T o) { 
			list.addLast(o);
		}
		
		public T top() { 
			return list.getFirst();
		}
		
		public T out() {
			return list.removeFirst();
		}
	}
	
	private class Tic {
		private int id;
		
		private Tic() {
			id = 0;
		}
		
		private Tic(int id) {
			this();
			this.id = id;
		}
	}
	
	private Queue<Tic> queue;
	
	@Override
	synchronized public void run() {
		// TODO Auto-generated method stub
		while (queue.list.size() > 0) {
			System.out.print(Thread.currentThread().getName()+"\tTicket:"+queue.out().id+"\t\n");
		}
		System.out.print("No tickets left!");
	}
	
	public Ticket() {
		queue = new Queue<Tic>();
	}
	
	public Ticket(int num) {
		this();
		Tic temptic;
		for (int i = 0; i < num; i++) {
			temptic = new Tic(i);
			queue.in(temptic);
		}
	}
	
	public static void main(String[] args) {
		Ticket ticket = new Ticket(100);
		for (int i = 0; i < 4; i++) {
        	Thread temp = new Thread(ticket, "售票点:" + i);
        	temp.start();
		}
	}
}
