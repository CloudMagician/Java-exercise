package ShoppingCart;

import java.util.HashMap;
import java.util.Scanner;

class book {  
    String	name;  
    double 	price;  
    int 	number;  
}

public class ShoppingCart {
	private static Scanner input;
	
    static double getSum(HashMap<Integer, book> books) {  
        book tempbook = new book();  
        double sum = 0;  
        for(int i = 0; i < books.size(); i++) {  
        	tempbook = (book)books.get(i);  
            sum += tempbook.price * tempbook.number;
        }
        return sum;  
    }
    
	public static void main(String[] args) {
		input = new Scanner(System.in);
        HashMap<Integer, book> books = new HashMap<Integer, book>();    
        System.out.print("请输入书的种类");  
        int n=input.nextInt();
        System.out.print("请依次输入各种书的名字、价格与数量");
        
        for(int i=0;i<n;i++) {
            book book = new book(); 
            book.name=input.next();  
            book.price=input.nextDouble();  
            book.number=input.nextInt();  
            books.put(i, book);
        }  
        
        double sum=getSum(books);
        System.out.print("总价为"+sum);
	}
}
