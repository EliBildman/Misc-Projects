package APCS;

public class ObjectTesting
{
	public static void main(String[] gunny) {
		Point yam = new Point(1, 2);
		yam.translate(4, 1);
		yam.invert();
		System.out.println(yam.x + "," + yam.y);
	}
}
