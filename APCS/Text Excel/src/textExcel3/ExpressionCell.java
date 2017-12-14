package textExcel3;

/**********************************************************
 * Assignment: text excel
 *
 * Author: Eli Bildman
 *
 * Description: defines expression cell object that takes a string with an expression, stores it, and simplifies when called
 *
 * Academic Integrity: I pledge that this program represents my own work. I
 * received help from no one in designing and debugging
 * my program.
 **********************************************************/

import java.util.ArrayList;

public class ExpressionCell extends Cell
{
	
	ArrayList<Double> operands  = new ArrayList<Double>();
	ArrayList<Character> operators = new ArrayList<Character>();
	
	public ExpressionCell(String input) {
		super(input);
		if (!input.startsWith("(") || !input.endsWith(")")) {
			throw new IllegalArgumentException("Expression values must start and end with parenthesis. '" + input + "' did not.");
		}
		
		findOperands(input);
		findOperators(input);
		
		
	}
	
	public void findOperands(String input) {
		input = " " + input.substring(1, input.length() - 1);
		for (int i = 0; i < input.length(); i ++) {
			if (input.charAt(i) == ' ' && Character.isDigit(input.charAt(i + 1))) {
				if (input.substring(i + 1).indexOf(' ') != -1) {
					operands.add(Double.parseDouble(input.substring(i + 1, input.substring(i + 1).indexOf(' ') + i + 1)));
				} else {
					operands.add(Double.parseDouble((input.substring(i + 1))));
				}
			}
		}
	}
	
	public void findOperators(String input) {
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '/' || input.charAt(i) == '*') {
				operators.add(input.charAt(i));
			}
		}
	}
	
	public String getDisplayValue () {
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
			switch (operators.get(index)) {
				case '+':
					operands.set(index, operands.get(index) + operands.get(index + 1));
					break;
				case '-':
					operands.set(index, operands.get(index) - operands.get(index + 1));
					break;
				case '/':
					operands.set(index, operands.get(index) / operands.get(index + 1));
					break;
				case '*':
					operands.set(index, operands.get(index) * operands.get(index + 1));
					break;
			}
			operands.remove(index + 1);
			operators.remove(index);
		}
		return operands.get(0) + "";
	}
	
	public static void main(String[] argz) {
		ExpressionCell yam = new ExpressionCell("(5 * 36 - 7 sum b4:e6 / 8 / 11 / 456845 / 800)");
		System.out.println(yam.operands);
		System.out.println(yam.operators);


	}
}
