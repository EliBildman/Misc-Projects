package karel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * create a randomly generated world file for the super hurdles program
 */
public class MakeRectangle2
{
	static PrintStream output;

	public MakeRectangle2()
	{
		File outfile = new File("rectanglex.kwld"); // associates a filename
													// with a
		// file
		try
		{
			output = new PrintStream(outfile);
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int southStreet = (int) (Math.random() * 5 + 3); // 3 - 7
		int westAvenue = (int) (Math.random() * 5 + 4); // 4 - 8
		int height = (int) (Math.random() * 10 + 1); // 1 - 10
		int width = (int) (Math.random() * 10 + 1); // 1 - 10

		int winHeight = southStreet + height + 3;
		int winWidth = westAvenue + width + 3;

		if (winWidth > winHeight)
		{
			setSize(winWidth, winWidth);
		}
		else
		{
			setSize(winHeight, winWidth);
		}

		placeBeeper(southStreet, 1, height * 4 + width * 4 + 16);

		buildRectangle(southStreet, westAvenue, height, width);
		output.close();
	}

	private static void buildRectangle(int southStreet, int westAvenue, int height, int width)
	{
		output.println("northsouthwalls " + westAvenue + " " + (southStreet + 1) + " " + (southStreet + height));
		output.println(
				"northsouthwalls " + (westAvenue + width) + " " + (southStreet + 1) + " " + (southStreet + height));
		output.println("eastwestwalls " + southStreet + " " + (westAvenue + 1) + " " + (westAvenue + width));
		output.println("eastwestwalls " + (southStreet + height) + " " + (westAvenue + 1) + " " + (westAvenue + width));
	}

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