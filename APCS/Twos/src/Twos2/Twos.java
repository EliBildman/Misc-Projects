package Twos2;
public class Twos 
{
	public static void main(String[] args)
	{
		int[][] thing = { { 0, 0, 0, 0 }, { 0, 2, 8, 0 }, { 2, 16, 4, 0 },
                { 16, 8, 2, 4 } };
		GameState grid = new GameState(thing);
		GameView game = new GameView(grid);
		
		grid.newGame();
		game.display();
	}

}