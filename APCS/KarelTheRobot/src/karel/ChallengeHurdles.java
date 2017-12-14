package karel;

import kareltherobot.*;

public class ChallengeHurdles extends Robot
{
	public ChallengeHurdles(int street, int avenue, Direction dir, int beeps)
	{
		super(street, avenue, dir, beeps);
	}

	//
	// Add methods here to support the plan in your main method to solve the
	// problem
	//

	public void turnRight()
	{
		turnLeft();
		turnLeft();
		turnLeft();
	}

	public void moveOne()
	{
		// pre - facing direction of last move
		turnRight();
		if (!frontIsClear())
		{
			turnLeft();
			if (!frontIsClear())
			{
				turnLeft();
				if (!frontIsClear())
				{
					turnLeft();
				}
			}
		}
		move();
		// post one unit farther towards the end
	}

	public void moveOneLeft()
	{
		turnLeft();
		if (!frontIsClear())
		{
			turnRight();
			if (!frontIsClear())
			{
				turnRight();
				if (!frontIsClear())
				{
					turnRight();
				}
			}
		}
		move();
	}

	public void goRightPH()
	{
		while (!nextToABeeper())
		{
			moveOne();
		}
		pickBeeper();
		if (nextToABeeper())
		{
			putBeeper();
			moveOne();
			goRightPH();
		}
		else
		{
			putBeeper();
		}
	}

	public void goLeftPH()
	{
		while (!nextToABeeper())
		{
			moveOneLeft();
		}
		pickBeeper();
		if (!nextToABeeper())
		{
			putBeeper();
			moveOneLeft();
			goLeftPH();
		}
		else
		{
			putBeeper();
		}
	}

	public boolean checkRow()
	{
		while (!facingEast())
		{
			turnLeft();
		}
		while (frontIsClear() && !nextToABeeper())
		{
			move();
		}
		if (frontIsClear())
		{
			pickBeeper();
			if (nextToABeeper())
			{
				putBeeper();
				move();
				return checkRow();
			}
			else
			{
				putBeeper();
				return true;
			}
		}
		else
		{
			while (!facingWest())
			{
				turnLeft();
			}
			while (frontIsClear())
			{
				move();
			}
			turnLeft();
			turnLeft();
			return false;
		}
	}

	public void fill()
	{
		while (nextToABeeper())
		{
			turnRight();
			while (frontIsClear())
			{
				move();
				if (!nextToABeeper())
				{
					putBeeper();
				}
			}
			while (!facingNorth())
			{
				turnLeft();
			}
			while (nextToABeeper())
			{
				move();
			}
			turnLeft();
			turnLeft();
			move();
			turnLeft();
			move();
		}
	}

	// pre - sitting on left place holder
	public void movePlaceHolders()
	{
		while (!facingNorth())
		{
			turnLeft();
		}
		pickBeeper();
		pickBeeper();
		move();
		putBeeper();
		putBeeper();
		turnLeft();
		turnLeft();
		while (frontIsClear())
		{
			move();
		}
		turnLeft();
		goRightPH();
		while (!facingNorth())
		{
			turnLeft();
		}
		while (nextToABeeper())
		{
			move();
		}
		putBeeper();
		turnLeft();
		turnLeft();
		while (frontIsClear())
		{
			move();
		}
		turnRight();
		goLeftPH();
	}

	public void findCappa()
	{
		while (!checkRow())
		{
			movePlaceHolders();
		}
		turnLeft();
		turnLeft();
		move();
		while (!nextToABeeper())
		{
			putBeeper();
			move();
		}
		turnLeft();
		turnLeft();

	}

	public static void main(String[] args)
	{
		MakeHurdles temp = new MakeHurdles();
		World.readWorld("hurdlesx.kwld");
		World.setVisible(true);

		ChallengeHurdles Betty = new ChallengeHurdles(1, 1, East, infinity);
		World.setDelay(1);
		Betty.putBeeper();
		Betty.putBeeper();
		Betty.findCappa();
		Betty.pickBeeper();
		Betty.fill();

		Betty.turnOff();

	}

}