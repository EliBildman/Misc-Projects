package karel;

import kareltherobot.*;

public class DiamondHarvester extends UrRobot
{
	public DiamondHarvester(int street, int avenue, Direction dir, int beeps)
	{
		super(street, avenue, dir, beeps);
	}

	//
	// Add methods here to support the plan in your main method to solve the problem
	//
	public void turnRight() {
		turnLeft();
		turnLeft();
		turnLeft();
	}

	public void collectRow() {
		pickBeeper();
		move();
		turnLeft();
		move();
		turnRight();
		pickBeeper();
		move();
		turnLeft();
		move();
		turnRight();
		pickBeeper();
		move();
		turnLeft();
		move();
		turnRight();
		pickBeeper();
	}

	public void transRight() {
		turnLeft();
		move();
		turnLeft();
		move();
	}

	public void transLeft() {
		move();
		turnRight();
		move();
		turnRight();
	}


	public static void main(String [] args) {
		World.readWorld("WorldFiles/fig3-5.kwld");
		World.setVisible(true);

		DiamondHarvester Betty = new DiamondHarvester(2, 2, East, 0);
		World.setDelay(2);

		Betty.move();
		Betty.move();
		Betty.move();
		Betty.move();
		Betty.turnLeft();
		Betty.collectRow();
		Betty.transLeft();
		Betty.collectRow();
		Betty.transRight();
		Betty.collectRow();
		Betty.transLeft();
		Betty.collectRow();

		//
		// Add calls to methods that represent your plan for solving the problem
		//

		Betty.turnOff();
	}

}