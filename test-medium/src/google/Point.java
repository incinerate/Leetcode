package google;

public class Point implements Comparable<Point>{

	int x, y;
	int distence;
	String record;

	@Override
	public int compareTo(Point p) {
		// TODO Auto-generated method stub
		return distence==p.distence?record.compareTo(p.record):distence-p.distence;
	}
	
	public Point(int _x, int _y) {
		x = _x;
		y = _y;
	}
	
	public Point(int _x, int _y, int _d) {
		x = _x;
		y = _y;
		distence = _d;
	}
	
	public Point(int _x, int _y, int _d, String s) {
		x = _x;
		y = _y;
		distence = _d;
		record = s;
	}
}
