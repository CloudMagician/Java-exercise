package ComputeTime;

public class ComputeTime {

	public static void main(String args[]) {
		Common temp = null;
		int A = 0;
		int B = 0;
		int C = 0;
		
		try {
			temp = (Common) Class.forName(args[0]).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			A = Integer.parseInt(args[1]);
			B = Integer.parseInt(args[2]);
			C = Integer.parseInt(args[3]);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		System.out.print(temp.getspeed(A, B, C));
	}
}
