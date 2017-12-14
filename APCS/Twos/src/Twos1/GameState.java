/**********************************************************
 * Assignment: twos
 *
 * Author: Eli Bildman
 *
 * Description: makes a 2048 game with a GUI
 *
 * Academic Integrity: I pledge that this program represents my own work. I
 * received help from no one in designing and debugging
 * my program.
 **********************************************************/

package Twos1;
import java.util.ArrayList;

/* Represents the game state, including status, score, and the 4x4 grid 
 * of values. Knows how to shift the values around. Notifies all 
 * registered IChangeListeners if anything happens. 
 */
public class GameState 
{
	private int[][] values;
	private String status;
	private int score;
	
	public final static int LEFT = 0;
	public final static int UP = 1;
	public final static int RIGHT = 2;
	public final static int DOWN = 3;
	
	private ArrayList<IChangeListener> listeners;
	
	public GameState()
	{
		// initialize listeners, status, and score
		score = 0;
		status = "New Game Started";
		listeners = new ArrayList<IChangeListener>();
		values = new int[4][4];
	}
	
	public String getStatus() { return status; }
	public int getScore() { return score; }
	
	public void addListener(IChangeListener listener)
	{
		// add the listener to the arrayList of listeners
		listeners.add(listener);
	}
	
	public void newGame()
	{
		// fill values array with 16 random numbers from 0 - 15
		// change status, and update listeners 
		status = "New Game Started";
		for(int i = 0; i < 4; i ++) {
			for(int j = 0; j < 4; j++) {
				values[i][j] = (int)(Math.random() * 16);
			}
		}
		updateListeners();
	}
	
	public void shift(int direction)
	{
		// change status and update listeners
		switch(direction) {
			case LEFT:
				status = "Shifted Tiles Left";
				break;
			case UP:
				status = "Shifted Tiles Up";
				break;
			case RIGHT:
				status = "Shifted Tiles Right";
				break;
			case DOWN:
				status = "Shifted Tiles Down";
				break;
		}
		
		updateListeners();
	}
	
	public int getValue(int r, int c)
	{
		// return the appropriate value
		return values[r][c];
	}
	
	private void updateListeners()
	{
		// for each item in the listeners list calls its redraw method
		for(int i = 0; i < listeners.size(); i ++) {
			listeners.get(i).redraw();
		}
	}
}