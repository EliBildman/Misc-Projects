package APCS;

public class Point
{
	int x;
	int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void translate(int dx, int dy) {
		x += dx;
		y += dy;
	}
	
	public void invert() {
		int z = x;
		x = y;
		y = z;
	}
}
