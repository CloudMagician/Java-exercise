package Tests;

public final class FightForLove {
	private class Yongshi implements Runnable {
		String name;
		int time;
		
		private Yongshi(String name) {
			this.name = name;
			this.time = 0;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			int temp = 0;
			for (int i = 0; i < 5; i++) {
				temp = (int)(Math.random()*100);
				System.out.print(name+"打出第："+(i+1)+"拳。耗时："+temp+"\n");
				time += temp;
			}
			System.out.print(name+"总耗时："+time+"\n");
		}
	}
	
	public void fight() {
		Yongshi gy = new Yongshi("关羽");
		Yongshi zf = new Yongshi("张飞");
		Thread gyt = new Thread(gy);
		Thread zft = new Thread(zf);
		gyt.start();
		zft.start();
		
		while (Thread.activeCount() != 1) {
			
		}
		
		if (gy.time == zf.time) {
			System.out.print("平局"+"\n");
		} else if (gy.time < zf.time) {
			System.out.print(gy.name+"赢得美人归!"+"\n");
		} else {
			System.out.print(zf.name+"赢得美人归!"+"\n");
		}
	}
	
	public static void main(String[] args) {
		FightForLove test = new FightForLove();
		test.fight();
	}
}
