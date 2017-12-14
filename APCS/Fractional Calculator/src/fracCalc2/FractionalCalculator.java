/**********************************************************
 * Assignment: Lowest terms calculator
 *
 * Author: Eli Bildman
 *
 * Description: takes an expression with two operands and an operator, return the operands and operators seperated		
 *
 * Academic Integrity: I pledge that this program represents my own work. I
 * received help from no one in designing and debugging
 * my program.
 **********************************************************/

package fracCalc2;
import java.util.*;


public class FractionalCalculator
{
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.println("Welcome to the Fraction Calculator!");
		System.out.print("Enter an expression (or \"quit\"): ");
		String input = console.nextLine();
		while (!input.toLowerCase().equals("quit")) {
			String leftOp = findOperand(input, "left");
			String rightOp = findOperand(input, "right");
			
			System.out.println("Left operand: " + convertToFraction(leftOp));
			System.out.println("Operator: " + findOperator(input));
			System.out.println("Right operand: " + convertToFraction(rightOp));
			
			System.out.print("Enter an expression (or \"quit\"): ");
			input = console.nextLine();
		}
		System.out.println("Goodbye!");
	}


	public static String findOperand(String input, String side) {
		if (side.equals("left")) {
			for(int i=0; i<input.length(); i++) {
				if (input.charAt(i) == ' ') {
					return input.substring(0, i);
				}
			}
		} else if (side.equals("right")) {
			for (int i=input.length() - 1; i > 0; i--) {
				if (input.charAt(i) == ' ') {
					return input.substring(i + 1);
				}
			}
		}
		return "Invalid Input";

				
	}
	public static char findOperator(String input) {
		for(int i=0; i<input.length(); i++){
			if(input.charAt(i) == ' ') {
				return input.charAt(i + 1);


			} 

		} return ' ';
	}
	
	public static String convertToFraction(String input) {
		int wholeNum;
		int num;
		int den;
		int newNum;
		boolean isFraction = false;
		if (input.equals("Invalid Input")) {
			return input;
		}
		for (int i = 0; i < input.length(); i ++) {
			if (input.charAt(i) == '_') {
				wholeNum = Integer.parseInt(input.substring(0, i));
				for (int x = i; x<input.length(); x++) {
					if (input.charAt(x) == '/') {
						num = Integer.parseInt(input.substring(i+1, x));
						den = Integer.parseInt(input.substring(x+1));
						if (wholeNum >= 0) {
							newNum = num + (Math.abs(wholeNum) * den);
						} else {
							newNum = (num + (Math.abs(wholeNum) * den)) * -1;
						}
						return newNum + "/" + den;
					}
				}
			} else if (input.charAt(i) == '/') {
				isFraction = true;
			}
		}
		if (isFraction) {	
			return input;
		} else {
			return input + "/1";
		}
	}
}