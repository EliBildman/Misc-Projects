package APCS;

public class ForLoopPractice
{
	public static void main(String[] args) {

		int a = 0;
		int b = 0;
		int current = 1;
		
		System.out.println("Fibonnaci series: ");
		System.out.println();
		
		for (int i = 0; i<12; i++) {
			System.out.print(current);
			System.out.print(" ");
			a = b;
			b = current;
			current = a + b;
		}
		System.out.println();
		System.out.println();
		System.out.println("Grid: ");
		System.out.println();
		
		for (int i = 0; i < 5; i++) {
			for (int x = 0; x < 4; x++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}
}
