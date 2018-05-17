package SaleTicket;

public class SaleTicket implements Runnable {
	public int total;
	
    public SaleTicket() {
        total = 100;
    }
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (total > 0) {
            synchronized (this) {
                if(total > 0) {
                    try {
                    	Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    total--;
                    System.out.println(Thread.currentThread().getName() + "\t火车票：" + (100 - total));
                }
            }
        }
	}
	
    public static void main(String[] args) {
        SaleTicket st = new SaleTicket();
        for(int i = 5; i >= 1; i--) {
        	Thread temp = new Thread(st, "售票点:" + i);
        	temp.start();
        }
    }
}
