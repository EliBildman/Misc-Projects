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

package Twos2;
import java.util.ArrayList;

/* Represents the game state, including status, score, and the 4x4 grid 
 * of values. Knows how to shift the values around. Notifies all 
 * registered IChangeListeners if anything happens. 
 */
public class GameState 
{
	private int[][] values;
	private boolean[][]noMerge;
	private String status;
	private int score;
	boolean gameActive;
	int[] newTile = {0, 0};
	boolean moved = false;
	
	public final static int LEFT = 0;
	public final static int UP = 1;
	public final static int RIGHT = 2;
	public final static int DOWN = 3;
	
	private ArrayList<IChangeListener> listeners;
	
	public GameState()
	{
		// initialize listeners, status, and score
		score = 0;
		status = "New game started";
		listeners = new ArrayList<IChangeListener>();
		values = new int[4][4];
		noMerge = new boolean[4][4];
		gameActive = true;
		
	}
	
	public GameState(int[][] input) {
		score = 0;
		status = "New game started";
		listeners = new ArrayList<IChangeListener>();
		values = input;
		noMerge = new boolean[4][4];
		gameActive = true;
	}
	
	public String getStatus() { return status; }
	public int getScore() { return score; }
	
	public void addListener(IChangeListener listener)
	{
		// add the listener to the arrayList of listeners
		listeners.add(listener);
	}
	
	public void testNewGame() {
		gameActive = true;
		updateListeners();
	}
	
	public void newGame()
	{
		status = "New game started";
		for (int i = 0; i < 4; i ++) {
			for (int j = 0; j < 4; j ++) {
				values[i][j] = 0;
			}
		}
		for (int i = 0; i < 2; i ++) {
			spawn(i);
		}
		score = 0;
		gameActive = true;
		updateListeners();
	}
	
	public void move(int x, int y, int dir) {
		int i;
		switch (dir) {
			case UP:
				for (i = 3;  i > y; i --) {
					if (!occupied(x, i)) {
						values[x][i] = values[x][y];
						values[x][y] = 0;
						moved = true;
						break;
					}
				}
				if(i + 1 < 4 && values[x][i + 1] == values[x][i] && !(noMerge[x][i] || noMerge[x][i+1])) {
					merge(x, i, x, i + 1);
					moved = true;
				}
				break;
			case DOWN:
				for (i = 0;  i < y; i ++) {
					if (!occupied(x, i)) {
						values[x][i] = values[x][y];
						values[x][y] = 0;
						moved = true;
						break;
					}
				}
				if(i - 1 >= 0 && values[x][i - 1] == values[x][i] && !(noMerge[x][i] || noMerge[x][i-1])) {
					merge(x, i, x, i - 1);
					moved = true;
				}
				break;
			case LEFT:
				for (i = 0;  i < x; i ++) {
					if (!occupied(i, y)) {
						values[i][y] = values[x][y];
						values[x][y] = 0;
						moved = true;
						break;
					}
				}
				if(i - 1 >= 0 && values[i - 1][y] == values[i][y] && !(noMerge[i][y] || noMerge[i-1][y])) {
					merge(i, y, i - 1, y);
					moved = true;
				}
				break;
			case RIGHT:
				for (i = 3;  i > x; i --) {
					if (!occupied(i, y)) {
						values[i][y] = values[x][y];
						values[x][y] = 0;
						moved = true;
						break;
					}
				}
				if(i + 1 < 4 && values[i + 1][y] == values[i][y] && !(noMerge[i][y] || noMerge[i+1][y])) {
					merge(i, y, i + 1, y);
					moved = true;
				}
				break;
			default:
				throw new IllegalArgumentException();
		}
	}
	
	
	private boolean moveIsLegal(int x, int y, int dir) {
		switch (dir) {
			case UP:
				return y + 1 <= 4;
			case DOWN:
				return y - 1 >= 0;
			case LEFT:
				return x - 1 >= 0;
			case RIGHT:
				return x + 1 <= 4;
			default:
				throw new IllegalArgumentException();
		}
	}
	
	private boolean occupied(int x, int y) {
		return values[x][y] != 0;
	}
	
	//new value is in (x2, y2)
	public void merge(int x1, int y1, int x2, int y2) {
		score += values[x1][y1] + values[x2][y2];
		values[x2][y2] += values[x1][y1];
		values[x1][y1] = 0;
		noMerge[x2][y2] = true;
	}
	
	private void spawn(int num) {
		int n = 0;
		int x;
		int y;
		if (emptyCells() == 0) return;
		while (n < 1) {
			x = (int) (Math.random() * 4);
			y = (int) (Math.random() * 4);
			if (!occupied(x, y)) {
				values[x][y] = Math.random() < 0.95 ? 2 : 4;
				n ++;
				newTile[num] = 4 * (3 - y) + x;
			}	
		}
	}
	
	private int emptyCells() {
		int counter = 0;
		for (int[] a: values) {
			for (int value: a) {
				if (value == 0) {
					counter ++;
				}
			}
		}
		return counter;
	}
	
	public void shift(int direction)
	{
		// change status and update listeners
		if (!gameActive) return;
		switch(direction) {
			case UP:
				status = "Shifted Tiles Left";
				for (int x = 0; x < 4; x ++) {
					for (int y = 0; y < 4; y ++) {
						if(occupied(x, y) && moveIsLegal(x, y, LEFT)) {
							move(x, y, LEFT);
						}
					}
				}
				break;
			case RIGHT:
				status = "Shifted Tiles Up";
				for (int y = 3; y >= 0; y --) {
					for (int x = 0; x < 4; x ++) {
						if(occupied(x, y) && moveIsLegal(x, y, UP)) {
							move(x, y, UP);
						}
					}
				}
				break;
			case DOWN:
				status = "Shifted Tiles Right";
				for (int x = 3; x >= 0; x --) {
					for (int y = 0; y < 4; y ++) {
						if(occupied(x, y) && moveIsLegal(x, y, RIGHT)) {
							move(x, y, RIGHT);
						}
					}
				}
				break;
			case LEFT:
				status = "Shifted Tiles Down";
				for (int y = 0; y < 4; y ++) {
					for (int x = 0; x < 4; x ++) {
						if(occupied(x, y) && moveIsLegal(x, y, DOWN)) {
							move(x, y, DOWN);
						}
					}
				}
				break;
		}
		newTile[1] = 1000;
		if(moved) spawn(0);
		moved = false;
		if (!movesPossible()) {
			lose();
		}
		noMerge = new boolean[4][4];
		updateListeners();
	}
	
	private void lose() {
		status = "Game over!";
		gameActive = false;
	}
	
	private boolean movesPossible() {
		if (emptyCells() > 0) return true;
		for (int x = 0; x < 4; x ++) {
			for (int y = 0; y < 4; y ++) {
				if (x + 1 < 4 && values[x][y] == values[x + 1][y] || x - 1 >= 0 && values[x][y] == values[x - 1][y]) return true;
				if (y + 1 < 4 && values[x][y] == values[x][y + 1] || y - 1 >= 0 && values[x][y] == values[x][y - 1]) return true;
			}
		}
		return false;
	}
	
	public int getValue(int x, int y)
	{
		// return the appropriate value
		return values[x][y];
	}
	
	private void updateListeners()
	{
		// for each item in the listeners list calls its redraw method
		for(int i = 0; i < listeners.size(); i ++) {
			listeners.get(i).redraw();
		}
	}
}