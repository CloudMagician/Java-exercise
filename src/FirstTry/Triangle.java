package FirstTry;
import java.awt.geom.Point2D;

public class Triangle {
	Point2D.Double p1,p2,p3;

	public Triangle(double x1,double x2,double x3,
			double y1,double y2,double y3) {		
		p1 = new Point2D.Double(); p1.x = x1; p1.y = y1;
		p2 = new Point2D.Double(); p2.x = x2; p2.y = y2;
		p3 = new Point2D.Double(); p3.x = x3; p3.y = y3;
	}
	
	public double Area() {
		double result = 0;
		result = 0.5*Math.abs((p1.x*(p2.y-p3.y))+Math.abs(p2.x*(p1.y-p3.y))+
				Math.abs(p3.x*(p1.y-p2.y)));
		return result;
	}
	
	public static void main(String args[]) {
		Triangle test = new Triangle(1,2,3,0,0,1);
		System.out.println(test.Area());
	}
}
