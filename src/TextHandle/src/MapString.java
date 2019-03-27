import java.util.*;
public class MapString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s=sc.next();
		int opt=sc.nextInt();
		int m=sc.nextInt();
		for(int i=0;i<m;i++) {
			String st=sc.next();
			if(opt==1) {
				if(st.contains(s)) {
					System.out.println(st);
				}
			}
			else {
				if(st.toUpperCase().contains(s.toUpperCase())){
					System.out.println(st);
				}
			}
		}
		sc.close();
	}
}