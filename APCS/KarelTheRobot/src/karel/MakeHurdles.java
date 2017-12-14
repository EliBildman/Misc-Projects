package karel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * create a randomly generated world file for the super hurdles program
 */
public class MakeHurdles
{
	static PrintStream output;

	public MakeHurdles()
	{
		File outfile = new File("hurdlesx.kwld"); // associates a filename with a
												// file
		try {
			output = new PrintStream(outfile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		setSize(18, 25);

		int finalAve = (int) (Math.random() * 13 + 12); // 12 - 24
		placeBeeper(1, finalAve, 1);

		int currentAve = 1;
		while (currentAve < finalAve)
		{
			if (Math.random() < 0.4) // probability of making a hurdle
												// 40%
			{
				// build a hurdle
				// choose height
				int height = (int) (Math.random() * 15 + 1); // height varies
																// from 1 to 15

				// choose width (don't go beyond limit)
				int toFinal = finalAve - currentAve;
				int maxWidth = (toFinal < 7) ? toFinal : 7;
				int width = (int) (Math.random() * maxWidth);
				currentAve = buildHurdle(currentAve, width, height);
				
				// if within 3 of the end only continue to build hurdles half the time
				if (finalAve - currentAve <= 3 && Math.random() < 0.5)
					currentAve = finalAve;
			}
			else // don't make a hurdle
			{
				currentAve++;
			}
		}
		// System.out.println("Done.");
		output.close();
	}

	// ex northsouthwalls 2 1 5 draws vert wall between ave 2 and 3 crossing st 1 - 5
	private static int buildHurdle(int currentAve, int width, int height)
	{
		output.println("northsouthwalls " + currentAve + " " + 1 + " " + height);
		if (width > 0)
		{
			output.println("northsouthwalls " + (currentAve + width) + " " + 1 + " " + height);
			output.println("eastwestwalls " + height + " " + (currentAve + 1) + " " + (currentAve + width));
		}

		return currentAve + width + 1;
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