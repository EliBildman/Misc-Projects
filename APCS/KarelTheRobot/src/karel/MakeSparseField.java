package karel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * Create a randomly generated world file for the SparseHarvester program
 * This complies with the conventions of world files
 * from the KarelTheRobot package
 */
public class MakeSparseField
{
	static PrintStream output;

	public MakeSparseField()
	{
		File outfile = new File("sparsex.kwld"); // associates a filename with a
												// file
		try {
			output = new PrintStream(outfile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		setSize(10, 10);
		for (int street = 2; street <= 7; street++)
		{
			for (int ave = 3; ave <= 7; ave++)
			{
				int randNumber = (int) (Math.random() * 10); // pick rand # 0 - 9
				if (randNumber < 7) // probability of planting a beeper = 70%
				{
					placeBeeper(street, ave, 1);
				}
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