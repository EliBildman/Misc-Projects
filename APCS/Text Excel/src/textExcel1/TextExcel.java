/**********************************************************
 * Assignment: Lowest terms calculator
 *
 * Author: Eli Bildman
 *
 * Description: uses spreadsheet object and user input to create tet excel program	
 *
 * Academic Integrity: I pledge that this program represents my own work. I
 * received help from no one in designing and debugging
 * my program.
 **********************************************************/

package textExcel1;
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
            takeInput(input, sheet);
        	input = getInput(console);
        }
        
        System.out.println("Farewell!");
        console.close();
    }
    

    public static String getInput(Scanner console){
    	System.out.print("Enter a command: ");
        return console.nextLine();
    }
    
    public static void takeInput(String input, Spreadsheet sheet) {
    	switch (input.toLowerCase()) {
    		case "print":
    			sheet.print();
    			break;
    		default:
    			System.out.println("Invalid Input");
    			break;
    	}
    }

}