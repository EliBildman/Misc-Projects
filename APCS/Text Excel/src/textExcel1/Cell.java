/**********************************************************
 * Assignment: Lowest terms calculator
 *
 * Author: Eli Bildman
 *
 * Description: creates a cell object to be used in the excell spreadsheet	
 *
 * Academic Integrity: I pledge that this program represents my own work. I
 * received help from no one in designing and debugging
 * my program.
 **********************************************************/

package textExcel1;
import java.util.Scanner;

public class Cell
{
	Scanner console = new Scanner(System.in);
	
	private String contents;
	
	public String userInput() {
		System.out.print("Input: ");
		return console.nextLine();
	}
	
	public Cell(String contents){
		this.contents = contents;
	}
	
	public String getValue() {
		return contents;
	}
	
	public void setValue(String value) {
		contents = value;
	}
}
