package karel;

import kareltherobot.*;

public class Traveller extends UrRobot
{
public Traveller(int street, int avenue, Direction direction, int beepers)
{
super(street, avenue, direction, beepers);
}

public void moveMile()
{
move();
move();
move();
move();
move();
move();
move();
move();
}	

public void moveBackward()
{
turnLeft();
turnLeft();
move();
turnLeft();
turnLeft();
}

public void move10Miles() {
	moveMile();
	moveMile();
	moveMile();
	moveMile();
	moveMile();
	moveMile();
	moveMile();
	moveMile();
	moveMile();
	moveMile();
}

public void move100Miles() {
	move100Miles();
	move100Miles();
	move100Miles();
	move100Miles();
	move100Miles();
	move100Miles();
	move100Miles();
	move100Miles();
	move100Miles();
	move100Miles();	
}


public void moveKiloMile()
{
	move100Miles();
	move100Miles();
	move100Miles();
	move100Miles();
	move100Miles();
	move100Miles();
	move100Miles();
	move100Miles();
	move100Miles();
	move100Miles();
// which moves Karel 1000 miles forward – use your brain, NOT brute force!
// you will probably want to include some additional methods in order to do this
}

public static void main(String[] args)
{
World.setVisible(true);
World.setDelay(0);

Traveller karel = new Traveller(2,2,East,0);
karel.moveBackward();
karel.moveMile();
karel.moveKiloMile();
karel.turnOff();
}

}