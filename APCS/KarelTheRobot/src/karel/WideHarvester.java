package karel;

import kareltherobot.*;

public class WideHarvester extends UrRobot
{
	public WideHarvester(int street, int avenue, Direction dir, int beeps)
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
		move();
		pickBeeper();
		move();
		pickBeeper();
		move();
		pickBeeper();
		move();
		pickBeeper();
		move();
		pickBeeper();
		move();
		pickBeeper();
		move();
		pickBeeper();
	}

	public void transRight() {
		move();
		turnLeft();
		move();
		turnLeft();
	}

	public void transLeft() {
		move();
		turnRight();
		move();
		turnRight();
	}


	public static void main(String [] args) {
		World.readWorld("WorldFiles/fig3-3a.kwld");
		World.setVisible(true);

		WideHarvester Betty = new WideHarvester(2, 2, East, 0);
		World.setDelay(2);

		Betty.collectRow();
		Betty.transRight();
		Betty.collectRow();
		Betty.transLeft();
		Betty.collectRow();
		Betty.transRight();
		Betty.collectRow();
		Betty.transLeft();
		Betty.collectRow();
		Betty.transRight();
		Betty.collectRow();
		Betty.move();

		//
		// Add calls to methods that represent your plan for solving the problem
		//

		Betty.turnOff();
	}

}