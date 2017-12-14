/**********************************************************
 * Assignment: Lowest terms calculator
 *
 * Author: Eli Bildman
 *
 * Description: takes a input with any amount of operators, tries to fix input if possible	
 *
 * Academic Integrity: I pledge that this program represents my own work. I
 * received help from no one in designing and debugging
 * my program.
 **********************************************************/
	
package fracCalcBonus;
import java.util.*;


public class FractionalCalculator
{
	public static void main(String[] args) {
		String input = "";
		Scanner console = new Scanner(System.in);
		System.out.println("Welcome to the Fraction Calculator!");
		System.out.print("Enter an expression (or \"quit\"): ");
		input = fixInput(console.nextLine());
		while (!input.toLowerCase().equals("quit")) {
			ArrayList<String> operands = new ArrayList<String>();
			ArrayList<Character> operators = new ArrayList<Character>();
			for (int i = 0; i < countOperands(input); i++) {
				operands.add(convertToFraction(findOperand(input, i)));
			}
			for (int i = 0; i < countOperands(input) - 1; i++) {
				operators.add(findOperator(input, i));
			}
			
			System.out.println(convertToMixed(reduce(smartCalc(operands, operators))));
			
			System.out.print("Enter an expression (or \"quit\"): ");
			input = console.nextLine();
		}	
		System.out.println("Goodbye!");
		console.close();
	}

	// returns the operand
	public static String findOperand(String input, int index) {
		input += " ";
		int start = 0;
		int end = -3;
		for (int i = 0; i <= index; i++) {
			start = end + 3;
			end = input.substring(start).indexOf(' ') + start;
		}
		return input.substring(start, end);
	}
	
	// returns the operator
	public static char findOperator(String input, int index) {
		int itteration = 0;
		char[] operators = new char[countOperands(input) - 1];
		for(int i = 0; i < input.length(); i ++) {
			if (input.charAt(i) == '+' || input.charAt(i) == '-' || (input.charAt(i) == '/' && input.charAt(i + 1) == ' ') || input.charAt(i) == '*') {
				operators[itteration] = input.charAt(i);
				itteration ++;
			}
		}
		return operators[index];
	}  
	
	public static String smartCalc (ArrayList<String> operands, ArrayList<Character> operators) {
		int index = 0;
		while (operands.size() > 1) {
			if (operators.indexOf('*') != -1 || operators.indexOf('/') != -1) {
				if ((operators.indexOf('*') < operators.indexOf('/') && operators.indexOf('*') != -1) || operators.indexOf('/') == -1) {
					index = operators.indexOf('*');
				} else {
					index = operators.indexOf('/');
				}
			} else {
				if ((operators.indexOf('+') < operators.indexOf('-') && operators.indexOf('+') != -1) || operators.indexOf('-') == -1) {
					index = operators.indexOf('+');
				} else {
					index = operators.indexOf('-');
				}
			}
			operands.set(index, calculate(operands.get(index), operators.get(index) + "", operands.get(index + 1)));
			operands.remove(index + 1);
			operators.remove(index);
		}
		return operands.get(0);
	}
	
	// returns the fraction equvilent of the input
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
	
	// returns one fraction thats the sum/product/etc of the inputs
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
	
	// reduces the fraction to lowest terms
	public static String reduce(String input) {
		int num = Integer.parseInt(input.substring(0, input.indexOf('/')));
		int den = Integer.parseInt(input.substring(input.indexOf('/') + 1));
		int gcf = 1;
		String end = "";
		
		//find the gcf
		for (int i = Math.abs(num); i > 0 ; i--) {
			if (num % i == 0 && den % i == 0) {
				gcf = i;
				break;
			}
		}
		//set num/den to positive and lowest terms
		
		if ((num < 0 || den < 0) && !(num < 0 && den < 0)) {
			end += "-";
		}
		
		den = Math.abs(den) / gcf;
		num = Math.abs(num) / gcf;
		
		end += (num + "/" + den);		
		return end;
	}
	
	public static int countOperands(String input) {
		int spaces = 0;
		for (int i = 0; i < input.length(); i++){
			if (input.charAt(i) == ' ') {
				spaces ++;
			}
		}
		return (spaces / 2) + 1;
	}
	
	//converts the fraction to a mixed number if possible
	public static String convertToMixed(String input) {
		
		int num = Integer.parseInt(input.substring(0, input.indexOf('/')));
		int den = Integer.parseInt(input.substring(input.indexOf('/') + 1));
		int wholeNum = 0;
		String end = "";
		//System.out.println(num + " " + den);
		
		while (Math.abs(num) >= den) {
			wholeNum += (Math.abs(num) / num);
			num -= den * (Math.abs(num) / num);
		}
		
		if (num < 0 || wholeNum < 0) {
			end += "-";
		}
		
		num = Math.abs(num);
		wholeNum = Math.abs(wholeNum);
		
		if (wholeNum > 0) {
			end += wholeNum;
		}
		if (wholeNum > 0 && num > 0) {
			end += "_";
		}
		if (num > 0) {
			end += num + "/" + den;
		}
		if (num == 0 && wholeNum == 0) {
			end += "0";
		}
		return end;
	}
	
	public static String fixInput(String input) {
		int i = 0;
		while (i < input.length() - 2){
			//System.out.println(i);
			i ++;
			if (input.charAt(0) == ' ') {
				input = input.substring(1);
				i = 0;
			}
			if (input.substring(i, i+2).equals("  ")) {
				input = input.substring(0, i) + input.substring(i + 1);
				i = 0;
			}
			if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*' || input.charAt(i) == '/') {
				if (input.charAt(i - 1) != ' ') {
					input = input.substring(0, i) + " " + input.substring(i);
					i = 0;
				}
				if (input.charAt(i + 1) != ' ') {
					input = input.substring(0, i + 1) + " " + input.substring(i + 1);
					i = 0;
				}
			}
			if (Character.isLetter(input.charAt(i))) {
				input = input.substring(0, i) + input.substring(i + 1);
				i = 0;
			}
			if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*' || input.charAt(i) == '/') {
				int x = i;
				while (!Character.isDigit(input.charAt(x))) {
					x ++;
					
					//System.out.println(input.charAt(x - 1));
					if (input.charAt(x) == '+' || input.charAt(x) == '-' || input.charAt(x) == '*' || input.charAt(x) == '/') {
						input = input.substring(0, x) + input.substring(x + 1);
					}
				}
			}
		}
		return input;
	}
}



