package karel;

import kareltherobot.*;

public class Hurdles extends Robot
{
    public Hurdles(int street, int avenue, Direction dir, int beeps)
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
    
    public void moveOne() {
    	//pre - facing direction of last move
    	turnRight();
    	if (!frontIsClear()) {
    		turnLeft();
    		if (!frontIsClear()) {
    			turnLeft();
    			if(!frontIsClear()) {
    				turnLeft();
    			}
    		}
    	}
    	move();
    	//post one unit farther towards the end
    }
    
    
    
    public static void main(String [] args) {
    	MakeHurdles temp = new MakeHurdles();
    	World.readWorld("hurdlesx.kwld");
        World.setVisible(true);

        Hurdles Betty = new Hurdles(1, 1, East, 0);
        World.setDelay(1);
        
        while(!Betty.nextToABeeper()) {
        	Betty.moveOne();
        }
        Betty.pickBeeper();
        Betty.turnOff();

    }

}