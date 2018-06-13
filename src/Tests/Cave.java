package Tests;

public class Cave implements Runnable {

	@Override
	synchronized public void run() {
		// TODO Auto-generated method stub
		System.out.print(Thread.currentThread().getName()+"\n");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Cave cave = new Cave();
		Thread[] people = new Thread[10];
		for (int i = 0; i < 10; i++) {
			people[i] = new Thread(cave,String.valueOf(i));
		}
		for (int i = 0; i < 10; i++) {
			people[i].start();
		}
	}
}
