package textExcel4;

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
	Spreadsheet sheet;
	
	public ExpressionCell(String input, Spreadsheet sheet) {
		super(input);
		if (!input.startsWith("(") || !input.endsWith(")")) {
			throw new IllegalArgumentException("Expression values must start and end with parenthesis. '" + input + "' did not.");
		}
		
		this.sheet = sheet;
		
		
	}
	
	public ArrayList<Double> replaceCellReferences(ArrayList<String> input) {
		ArrayList<Double> end = new ArrayList<Double>();
		for (int i = 0; i < input.size(); i++) {
			String oper = input.get(i);
			if (oper.equals("sum")) {
				String oper2 = input.get(i + 1);
				end.add(sum(oper2));
			} else if (oper.equals("avg")) {
				String oper2 = input.get(i + 1);
				end.add(avg(oper2));
			} else if (sheet.isCellReference(oper)) {
				end.add(Double.parseDouble(parseAndGet(oper, sheet)));
			} else if (Character.isDigit(oper.charAt(0))){
				end.add(Double.parseDouble(oper));
			}
		}
		return end;
	}
	
	private boolean isOperator(char input) {
		return input == '+' || input == '-' || input == '/' || input == '*';
	}
	

	public Double sum(String input) {
		Double sum = 0.0;
		for (int x = sheet.getCol(parseColon(input, 0)); x <= sheet.getCol(parseColon(input, 1)); x++){
			for (int y = sheet.getRow(parseColon(input, 0)); y <= sheet.getRow(parseColon(input, 1)); y++) {
				sum += Double.parseDouble(sheet.get(y, x).getDisplayValue());
			}
		}
		return sum;
	}
	
	public Double avg(String input) {
		Double sum = 0.0;
		int total = 0;
		for (int x = sheet.getCol(parseColon(input, 0)); x <= sheet.getCol(parseColon(input, 1)); x++){
			for (int y = sheet.getRow(parseColon(input, 0)); y <= sheet.getRow(parseColon(input, 1)); y++) {
				sum += Double.parseDouble(sheet.get(y, x).getDisplayValue());
				total++;
			}
		}
		return (sum / total);
	}
	
	private static String parseColon(String ref, int i) {
		if (i == 0) {
			return ref.substring(0, ref.indexOf(':'));
		}
		return ref.substring(ref.indexOf(':') + 1);
	}
	
	private static String parseAndGet(String ref, Spreadsheet sheet) {
		return sheet.get(sheet.getRow(ref), sheet.getCol(ref)).getDisplayValue();
	}
	

	
	public void findOperands(String input) {
		ArrayList<String> found = new ArrayList<String>();
		input = " " + input.substring(1, input.length() - 1);
		for (int i = 0; i < input.length(); i ++) {
			if (input.charAt(i) == ' ' && !(isOperator(input.charAt(i + 1)))) {
				if (input.substring(i + 1).indexOf(' ') != -1) {
					found.add(input.substring(i + 1, input.substring(i + 1).indexOf(' ') + i + 1));
				} else {
					found.add((input.substring(i + 1)));
				}
			}
		}
		
		operands = replaceCellReferences(found);
	}
	
	public void findOperators(String input) {
		for (int i = 0; i < input.length(); i++) {
			if (isOperator(input.charAt(i))) {
				operators.add(input.charAt(i));
			}
		}
	}
	
	public String getDisplayValue () {
		findOperands(originalValue);
		findOperators(originalValue);
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
	
}
