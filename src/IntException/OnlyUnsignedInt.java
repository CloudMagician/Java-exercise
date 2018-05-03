package IntException;

import java.util.InputMismatchException;
import java.util.Scanner;

class UnsignedException extends Exception {
	private static final long serialVersionUID = 1L;

	public UnsignedException() {
		System.out.println("Negative Number Appear!!!");
	}
}

public class OnlyUnsignedInt {
	private static Scanner input;
	private static int sum = 0;
	
	public static void main(String[] args) {		
		int number = 0;
		
		input = new Scanner(System.in);
		
		while (number != 999) {
			try {
				number = input.nextInt();
			} catch (InputMismatchException e) {
				e.printStackTrace();
				input.next();
				continue;
			}
			
			if (number < 0) {
				new UnsignedException();
				number = 0;
			}
			
			sum += number;
		}
		
		System.out.println("Sum = " + (sum-999));
	}
}
