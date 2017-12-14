package karel;

import kareltherobot.*;

// This robot task is from page 11 in the text
public class CompleteProgram implements Directions
{

	public static void main(String[] args)
	{
		// World file (leave out the readWorld line if you just want a blank world)
		World.readWorld("WorldFiles/fig2-3.kwld");
		World.setVisible(true);
		
		UrRobot karel = new UrRobot(1,2,East, 0);
		karel.move();
		karel.move();
		karel.pickBeeper();
		karel.turnLeft();
		karel.turnLeft();
		karel.move();
		karel.move();
		karel.move();
		karel.putBeeper();
		karel.turnLeft();
		karel.turnLeft();
		karel.move();
		karel.turnLeft();
		karel.turnOff();

	}

}
