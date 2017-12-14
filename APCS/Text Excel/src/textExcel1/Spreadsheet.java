/**********************************************************
 * Assignment: Lowest terms calculator
 *
 * Author: Eli Bildman
 *
 * Description: creates a spreadsheet object to be used in text excel	
 *
 * Academic Integrity: I pledge that this program represents my own work. I
 * received help from no one in designing and debugging
 * my program.
 **********************************************************/

package textExcel1;
public class Spreadsheet
{
    // these constants make it easy to remember the number of rows and 
    // columns to use
    private final static int ROWS = 10;
    private final static int COLS = 7;

    private final static int CELL_WIDTH = 12;

    // the 2D array of cells
    private Cell[][] data;

    // constructor
    public Spreadsheet()
    {
        data = new Cell[ROWS][COLS]; // all the Cells will start with the value null
    }

    // prints the grid to the console
    public void print()
    {
    	printLine();
    	System.out.println();
    	System.out.print('|');
    	printCell(null);
    	System.out.print('|');
    	for (int i = 65; i < 65 + COLS; i++) {
    		printCell((char) i + "");
    		System.out.print('|');
    	}
    	System.out.println();
    	printLine();
    	System.out.println();
    	for (int i = 0; i < ROWS; i ++){
    		System.out.print('|');
    		printCell((""+ (i + 1)));
    		printRow(i);
    		System.out.println();
    		printLine();
    		System.out.println();
    	}
    	
        
    }
    
    private void printLine() {
    	System.out.print("+");
    	for (int i = 0; i < COLS + 1; i++){
    		for (int j = 0; j < CELL_WIDTH; j++) {
    				System.out.print("-");
    		}
    		System.out.print("+");
    	}
    }
    
    private void printRow(int row)
    {
    	System.out.print("|");
        for(int i = 0; i < COLS; i ++) {
        	if (data[row][i] != null) {
        		printCell(data[row][i].getValue());
        	} else {
        		printCell(null);
        	}
        	System.out.print("|");
        }
    }
    
    private void printCell(String data)
    {
        if (data == null) {
           for (int i = 0; i < CELL_WIDTH; i++){
        	   System.out.print(" ");
           }
        } else {
        	int full = CELL_WIDTH - data.length();
        	int avail = (CELL_WIDTH - data.length()) / 2;
        	repeatedChar(' ', avail);
        	System.out.print(data);
	        repeatedChar(' ',full - avail);
        }
    }
    
    private void repeatedChar(char input, int repeats) {
    	for (int i = 0; i < repeats; i ++) {
    		System.out.print(input);
    	}
    }

    public static void main(String[] args) 
    {
        // these lines should create a spreadsheet, add 3 cells to it,
        // and print the whole grid. 
       Spreadsheet sheet = new Spreadsheet();
       sheet.data[0][0] = new Cell("hi");
       sheet.data[3][6] = new Cell("text");
       sheet.data[7][4] = new Cell("excel");
       sheet.print();

    }

}
