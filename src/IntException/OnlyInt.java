package IntException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class OnlyInt {
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
			sum += number;
		}
		
		System.out.println("Sum = " + (sum-999));
	}
}
