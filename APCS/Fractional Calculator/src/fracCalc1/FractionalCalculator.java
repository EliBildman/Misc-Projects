package fracCalc1;
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

import java.util.*;

public class FractionalCalculator
{
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.println("Welcome to the Fraction Calculator!");
		System.out.print("Enter an expression (or \"quit\"): ");
		String input = console.nextLine();

		System.out.println("Left operand: " + findOperand(input, "left"));
		System.out.println("Operator: " + findOperator(input));
		System.out.println("Right operand: " + findOperand(input, "right"));
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
		return "Inalid Input";

				
	}
	public static char findOperator(String input) {
		for(int i=0; i<input.length(); i++){
			if(input.charAt(i) == ' ') {
				return input.charAt(i + 1);


			} 

		} return ' ';
	}
}