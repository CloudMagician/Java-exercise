package Tests;

public final class Test {
	enum Day {
	    MONDAY, TUESDAY, WEDNESDAY,
	    THURSDAY, FRIDAY, SATURDAY, SUNDAY
	}
	
	public void testSwitch() {
		byte testbyte = 0;
		short testshort = 0;
		int testint = 0;
		char testchar = 0;
		Day testenum;
		switch (testshort) {
		case 1:
			
			break;

		default:
			break;
		}
	}
	
	public void testArray() {
		int[] ages1 = new int[3];
		int[] ages2 = new int[] {1,2,3};
		int[] ages3 = new int[] {};
//		int[] ages4 = new int[3] {1,2,3};
	}
	
	public void testChangeType() {
		String s = null;
		int i = 0;
		i = Integer.parseInt(s);
		s = Integer.toString(i);
		s = String.valueOf(i);
	}
	
	public static void main() {

	}
}
