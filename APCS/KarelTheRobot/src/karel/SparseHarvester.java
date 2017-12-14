package karel;

import kareltherobot.*;

public class SparseHarvester extends Robot
{
	public SparseHarvester(int street, int avenue, Direction dir, int beeps)
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

	public void smartPickBeeper() {
		if(nextToABeeper()) {
			pickBeeper();
		}
	}

	public void collectRow() {
		move();
		smartPickBeeper();
		move();
		smartPickBeeper();
		move();
		smartPickBeeper();
		move();
		smartPickBeeper();
		move();
		smartPickBeeper();
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
		MakeSparseField temp = new MakeSparseField();
		World.readWorld("sparsex.kwld");
		World.setVisible(true);

		SparseHarvester Betty = new SparseHarvester(2, 2, East, 0);
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