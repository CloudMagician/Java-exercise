package Tests;

abstract class Computer {
	void use() {
	}
}

final class Windows extends Computer {
	void use() {
		System.out.print("WINDOWS");
	}
}

final class Linux extends Computer {
	void use() {
		System.out.print("LINUX");
	}
}

public class Eperson {
	Computer com;
	
	public Eperson(Computer temp) {
		com = temp;
	}
	
	private void useMyComputer() {
		com.use();
	}
	
	public static void main(String[] args) {
		Eperson p1 = new Eperson(new Windows());
		Eperson p2 = new Eperson(new Linux());
		p1.useMyComputer();
		p2.useMyComputer();
	}
}
