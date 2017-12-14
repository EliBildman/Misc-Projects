
public class Pixel
{
	int x;
	int y;
	boolean isWall;
	boolean traveled = false;
	
	
	public Pixel(int x, int y, boolean isWall) {
		this.x = x;
		this.y = y;
		this.isWall = isWall;
	}
	
	public String toString() {
		return "(" + x + ", " + y + ") " + (isWall? "Wall" : "Path"); 
	}
}
