package APCS;

public class StringProgram
{
	public static void main(String[] args)
	{
		String spicy = "Eli Buildman";

		int space = spicy.indexOf(' ');

		if (space != -1)
		{
			System.out.println(spicy.substring(0, space));
			System.out.println(spicy.substring(space + 1));
		}
		else
		{
			System.out.println(spicy);
		}

		for (int i = 0; i < spicy.length(); i++)
		{
			System.out.println(spicy.charAt(i));
		}

	}
}
