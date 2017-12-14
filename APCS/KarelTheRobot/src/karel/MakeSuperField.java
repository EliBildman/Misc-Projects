package karel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * Create a randomly generated world file for the SparseHarvester program
 * This complies with the conventions of world files
 * from the KarelTheRobot package
 */
public class MakeSuperField
{
	static PrintStream output;
	
	static final int MAX_BEEPERS = 8;
	static final int MAX_FIELD_WIDTH = 12;
	static final int MAX_FIELD_HEIGHT = 8;

	public MakeSuperField()
	{
		File outfile = new File("superx.kwld"); // associates a filename with a file
		try {
			output = new PrintStream(outfile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		int maxAve = (int) (Math.random() * MAX_FIELD_WIDTH + 3);
		int maxStreet = (int) (Math.random() * MAX_FIELD_HEIGHT + 2);
		
		// this if works around some weird behavior in how wide worlds open
		if (maxAve > maxStreet)
		{
			setSize(maxAve + 2, maxAve + 2);
		}
		else
		{
			setSize(maxStreet + 2, maxAve + 2);
		}
		
		// put between 1 and some arbitrary number of beepers on each corner
		// put the first beepers on street 2 avenue 3
		for (int street = 2; street <= maxStreet; street++)
		{
			for (int ave = 3; ave <= maxAve; ave++)
			{
				int randNumber = (int) (Math.random() * MAX_BEEPERS + 1); // pick rand # 1 - 8
				placeBeeper(street, ave, randNumber);
			}
		}

		output.close();
	}

	private static void placeBeeper(int street, int avenue, int howMany)
	{
		output.println("beepers " + street + " " + avenue + " " + howMany);
	}

	private static void setSize(int streets, int avenues)
	{
		output.println("KarelWorld");
		output.println("streets " + streets);
		output.println("avenues " + avenues);
	}

}