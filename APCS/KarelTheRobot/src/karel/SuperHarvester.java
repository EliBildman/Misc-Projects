package karel;

import kareltherobot.*;

public class SuperHarvester extends Robot
{
	public SuperHarvester(int street, int avenue, Direction dir, int beeps)
	{
		super(street, avenue, dir, beeps);
	}

	//
	// Add methods here to support the plan in your main method to solve the problem
	//

	public void pickStack() {
		//pre - next to a beeper
		while(nextToABeeper()) {
			pickBeeper();
		}
		//post - not next to a beeper
	}
	public void turnRight() {
		turnLeft();
		turnLeft();
		turnLeft();
	}

	public void collectRow() {
		//pre - on an end of a row facing towards the row
		while(nextToABeeper()) {
			pickStack();
			move();
		}
		//pre - on oposite side of row, fully cleared facing away from row
	}

	public void transRight() {
		turnLeft();
		move();
		turnLeft();
		move();
	}

	public void transLeft() {
		turnRight();
		move();
		turnRight();
		move();
	}
	public void returnToOrigin() {
		while(!facingWest()) {
			turnLeft();
		}
		while(frontIsClear()) {
			move();
		}
		turnLeft();
		while(frontIsClear()) {
			move();
		}
		turnLeft();
		turnLeft();
	}


	public static void main(String [] args) {
		MakeSuperField temp = new MakeSuperField();
		World.readWorld("superx.kwld");
		World.setVisible(true);

		SuperHarvester Betty = new SuperHarvester(2, 2, East, 0);
		World.setDelay(0);

		Betty.move();
		while(Betty.nextToABeeper()) {
			Betty.collectRow();
			Betty.transRight();
			Betty.collectRow();
			Betty.transLeft();
		}
		Betty.returnToOrigin();
		//
		// Add calls to methods that represent your plan for solving the problem
		//

		Betty.turnOff();
	}

}