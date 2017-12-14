package karel;

import kareltherobot.*;

public class Harvester extends UrRobot
{
    public Harvester(int street, int avenue, Direction dir, int beeps)
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
        World.readWorld("WorldFiles/fig3-2.kwld");
        World.setVisible(true);

        Harvester Betty = new Harvester(2, 2, East, 0);
        World.setDelay(1);
        
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