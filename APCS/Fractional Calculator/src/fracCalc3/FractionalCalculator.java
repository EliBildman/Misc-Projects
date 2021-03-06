/**********************************************************
 * Assignment: Lowest terms calculator
 *
 * Author: Eli Bildman
 *
 * Description: takes an expression with two operands and an operator, returns the expression solved 		
 *
 * Academic Integrity: I pledge that this program represents my own work. I
 * received help from no one in designing and debugging
 * my program.
 **********************************************************/

package fracCalc3;
import java.util.*;


public class FractionalCalculator
{
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.println("Welcome to the Fraction Calculator!");
		System.out.print("Enter an expression (or \"quit\"): ");
		String input = console.nextLine();
		while (!input.toLowerCase().equals("quit")) {
			
		System.out.println(calculate(convertToFraction(findOperand(input, "left")), findOperator(input) + "", convertToFraction(findOperand(input, "right"))));
			
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
	
	public static String calculate(String oper1, String operand, String oper2) {
		int num1 = Integer.parseInt(oper1.substring(0, oper1.indexOf('/')));
		int den1 = Integer.parseInt(oper1.substring(oper1.indexOf('/') + 1));
		int num2 = Integer.parseInt(oper2.substring(0, oper2.indexOf('/')));
		int den2 = Integer.parseInt(oper2.substring(oper2.indexOf('/') + 1));
		
		switch (operand) {
			case "+":
				return (num1 * den2 + num2 * den1) + "/" + (den1 * den2);
			case "-":
				return (num1 * den2 - num2 * den1) + "/" + (den1 * den2);
			case "*":
				return (num1 * num2) + "/" + (den1 * den2);
			case  "/":
				return (num1 * den2) + "/" + (den1 * num2);
			default:
				return "Invalid Input";
		}
		
	}
	
	public static String toLowestTerms(String input) {
		int num = Integer.parseInt(input.substring(0, input.indexOf('/')));
		int den = Integer.parseInt(input.substring(input.indexOf('/') + 1));
		int gcf = 1;
		
		for (int i = num; i > 0 ; i--) {
			if (num % i == 0 && den % i == 0) {
				gcf = i;
				break;
			}
		}
		
		int finNum;
		int finDen;
		
		if ((num < 0 && den < 0) || (num > 0 && den > 0)){
			finNum = Math.abs(num)/gcf;
		} else {
			finNum = Math.abs(num)/gcf * -1;
		}
		finDen = Math.abs(den)/gcf;
		
		return finNum + "/" + finDen;
		
	}
	
	
}