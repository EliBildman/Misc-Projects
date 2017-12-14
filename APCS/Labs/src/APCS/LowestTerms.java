/**********************************************************
 * Assignment: Lowest terms calculator
 *
 * Author: Eli Bildman
 *
 * Description: takes a fraction and expresses it in lowest terms
 *
 * Academic Integrity: I pledge that this program represents my own work. I
 * received help from no one in designing and debugging
 * my program.
 **********************************************************/

package APCS;
import java.util.*;
	
public class LowestTerms
{
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.print("Enter a numerator: ");
		int num = console.nextInt();
		int den = 0;
		while (den == 0) {
			System.out.print("Enter a denominator: ");
			den = console.nextInt();
		}
		console.close();

		int finNum;
		int finDen;
		
		int GCF = greatestCommonFactor(Math.abs(num), Math.abs(den));
		
		if ((num < 0 && den < 0) || (num > 0 && den > 0)){
			finNum = Math.abs(num)/GCF;
		} else {
			finNum = Math.abs(num)/GCF * -1;
		}
		finDen = Math.abs(den)/GCF;
		
		System.out.println(num + "/" + den + " reduced to lowest terms is " + finNum + '/' + finDen);
		

	}
	
	public static int greatestCommonFactor(int num, int den) {
		for (int i = num; i > 0 ; i--) {
			if (num % i == 0 && den % i == 0) {
				return i;
			}
		}
		return 1;
	}
	
	
	
}
