/**********************************************************
 * Assignment: Lowest terms calculator
 *
 * Author: Eli Bildman
 *
 * Description:takes a set of integers and returns max min and mean		
 *
 * Academic Integrity: I pledge that this program represents my own work. I
 * received help from no one in designing and debugging
 * my program.
 **********************************************************/


package APCS;
import java.util.*;

public class TemperatureStats
{
	public static void main(String [] args) {
		Scanner console = new Scanner(System.in);
		System.out.print("How many temperatures will you enter? ");
		int number = console.nextInt();
		int current = 0;
		int highestTemp = 0;
		int lowestTemp = 0;
		int total = 0;
		for(int i = 0; i < number; i++) {
			System.out.print("Enter temperature #" + (i + 1) + ": ");
			current = console.nextInt();
			if (i == 0) {
				highestTemp = number;
				lowestTemp = number;
			} else {
				if (current > highestTemp) {
					highestTemp = current;
				}
				if (current < lowestTemp) {
					lowestTemp = current;
				}
			}
			total += current;
		}
		System.out.println("The highest temperature was: " + highestTemp);
		System.out.println("The lowest temperature was: " + lowestTemp);
		System.out.println("The average temperature was: " + ((int) ((double) total / number + 0.5)));
	}
	
}
