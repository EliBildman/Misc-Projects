/**********************************************************
 * Assignment: text excel
 *
 * Author: Eli Bildman
 *
 * Description: uses spreadsheet object and user input to create text excel program	
 *
 * Academic Integrity: I pledge that this program represents my own work. I
 * received help from lucas in designing and debugging
 * my program.
 **********************************************************/

package textExcel2;
import java.util.*;
public class TextExcel

{

    public static void main(String[] args)
    {
    	
    	Scanner console = new Scanner(System.in);
        // create a new spreadsheet first
        Spreadsheet sheet = new Spreadsheet();
        // show the welcome message
        System.out.println("Welcome to TextExcel!");
        // set up a scanner to get input
        String input = getInput(console);
        

        while (!input.toLowerCase().equals("quit"))
        {
            
           // System.out.println((int) findCol(input) + " " + findRow(input) + " " + findData(input));
            takeInput(input, sheet, console);
        	input = getInput(console);
        }
        
        System.out.println("Farewell!");
        console.close();
    }
    
    public static boolean isPartialSet(String input) {
    	boolean number = true;
    	try { Integer.parseInt(input.charAt(1) + ""); }
    	catch(Exception e) { number = false; }
    	return (Character.isLetter(input.charAt(0)) && number);
    }
    
    public static boolean isFullSet(String input) {
    	int space = input.indexOf(' ');
    	return input.indexOf(' ') != -1 && isPartialSet(input) && input.substring(space, space + 3).equals(" = ") && input.substring(space).length() > 3;    	
    }
    
    public static String getInput(Scanner console){
    	System.out.print("Enter a command: ");
        return console.nextLine();
    }
    
    public static char findCol(String input) {
    	return input.charAt(0);
    }
    
    public static int findRow(String input) {
    	if (input.indexOf(' ') != -1) {
    		return Integer.parseInt(input.substring(1, input.indexOf(' ')));
    	} else {
    		return Integer.parseInt(input.substring(1));
    	}
    }
    
    public static String findData(String input) {
    	return input.substring(input.indexOf('=') + 2);
    }

    public static void takeInput(String input, Spreadsheet sheet, Scanner console) {
    	String lowerInput = input.toLowerCase();
    	if (!input.equals("")) {
	    	if (lowerInput.equals("print")) {
	    		sheet.print();
	    	} else if (isFullSet(lowerInput)) {
	    		sheet.set(findCol(lowerInput) - 97, findRow(lowerInput) - 1, findData(input));
	    	} else if (isPartialSet(input)) {
	    		//System.out.print(findRow(input) + "" + (findCol(input) - 97));
	    		System.out.println(input.toUpperCase() + " = " + sheet.getTrue(findRow(lowerInput) - 1, findCol(lowerInput) - 97));
	
	    	}
    	}
    	
    }

}