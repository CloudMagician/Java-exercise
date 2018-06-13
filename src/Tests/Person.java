package Tests;

public final class Person {
	int age;
	
	public Person (int age) {
		this.age = age;
	}
	
	public void print () {
		System.out.print(" " + age);
	}
	
	public Person increasement() {
		age++;
		return this;
	}
	
	public static void main(String[] args) {
		Person p = new Person(23);
		p.increasement().increasement().print();
		System.out.print(1+2+"a"+(2+1+4)+"b");
	}
}
