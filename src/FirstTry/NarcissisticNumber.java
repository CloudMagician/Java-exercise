package FirstTry;

public class NarcissisticNumber {
	public static void main(String args[]) {
		for (int i = 101; i < 1000; i++) {
			if (i == (i/100)*(i/100)*(i/100)+
					(i%100/10)*(i%100/10)*(i%100/10)+
					(i%10)*(i%10)*(i%10)) {
				System.out.println(i);
			}
		}
	}
}
