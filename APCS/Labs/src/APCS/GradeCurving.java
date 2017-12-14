package APCS;
import java.util.*;

public class GradeCurving
{

	public static void main(String[] args)
	{
		Scanner console = new Scanner(System.in);
		System.out.print("How many grades will you enter? ");
		int[] grades = new int[console.nextInt()];
		for (int i = 0; i < grades.length; i++) {
			System.out.print("Enter grade " + (i + 1) + ": ");
			grades[i] = console.nextInt();
		}
		console.close();
		int curve = 100 - findMax(grades);

		for (int i = 0; i < grades.length; i ++) {
			System.out.println("Original: " + grades[i] + " With curve: " + (grades[i] + curve));
		}


	}

	public static int findMax(int[] grades) {
		int max = 0;
		for (int i = 0; i<grades.length; i ++) {
			if (grades[i] > max) {
				max = grades[i];
			}
		}
		return max;
	}
}
