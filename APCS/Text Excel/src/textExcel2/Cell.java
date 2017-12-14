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

package textExcel2;

public abstract class Cell
{
	protected String contents;
	
	public Cell(String contents){
		this.contents = contents;
	}
	
	public abstract String getValue();
	
	
}
