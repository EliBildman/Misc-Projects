//Eli + Michael

package karel;

import kareltherobot.*;

public class FencePlanter2 extends Robot
{
	public FencePlanter2(int street, int avenue, Direction dir, int beeps)
	{
		super(street, avenue, dir, beeps);
	}

	public static void main(String[] args)
	{
		// these two lines are already set up for the double layer problem
		MakeRectangle2 temp = new MakeRectangle2();
		World.readWorld("rectanglex.kwld");
		World.setVisible(true);

		FencePlanter2 Betty = new FencePlanter2(1, 1, North, 0);
		World.setDelay(1);

		Betty.findThePile();
		Betty.pickUpThePile();
		Betty.findRectangle();
		for (int i = 0; i < 4; i++)
		{
			Betty.plantASide();
			Betty.plantCorner();
		}
		for(int i=0; i<4; i++) {
			Betty.plantASideOuter();
			Betty.putBeeper();
			Betty.turnRight();
			Betty.move();
			
		}
		Betty.turnLeft();
		Betty.move();
		Betty.turnLeft();
		Betty.move();
		Betty.putBeeper();

		Betty.turnOff();
	}

	// pre: Robot at empty corner facing down the next side to be planted
	// post: Robot has planted a beeper and setup to start new side (facing
	// wall)
	public void plantCorner()
	{
		putBeeper();
		move();
		turnRight();
	}

	// pre: Robot at first section of wall, facing wall
	// post Robot one past last section of wall, beepers dropped along wall
	public void plantASide()
	{
		while (!frontIsClear())
		{
			putBeeper();
			turnLeft();
			move();
			turnRight();
		}
	}
	
	public void plantASideOuter() {
		//pre - sitting on inner fence beeper,facing in
		while (nextToABeeper()) {
			turnLeft();
			turnLeft();
			move();
			turnRight();
			move();
			putBeeper();
			turnRight();
			move();
		}
		// post - one off last beeper on in row of that line
	}

	// pre: Robot holding all beepers, on street south of rectangle
	// post: Robot next to southern-most section of west side of rectangle
	public void findRectangle()
	{
		move();
		turnRight();
		goToWall();
	}

	// pre: Robot facing a wall some distance away
	// post: Robot has moved to be next to wall
	public void goToWall()
	{
		while (frontIsClear())
		{
			move();
		}
	}

	public void turnRight()
	{
		turnLeft();
		turnLeft();
		turnLeft();
	}

	// pre: Robot on pile of beepers
	// post: Robot on same corner carrying all the beepers
	public void pickUpThePile()
	{
		while (nextToABeeper())
		{
			pickBeeper();
		}
	}

	// pre: Robot facing north, a pile somewhere above
	// post: Robot on pile of beepers
	public void findThePile()
	{
		while (!nextToABeeper())
		{
			move();
		}
	}

}