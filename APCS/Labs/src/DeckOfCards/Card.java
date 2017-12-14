package DeckOfCards;

public class Card
{
	int value;
	String suit;
	int suitValue;

	public Card(int v, String s)
	{
		value = v;
		suit = s;
		switch (s) {
			case "Clubs": suitValue = 0; break;
			case "Diamonds": suitValue = 1; break;
			case "Hearts": suitValue = 2; break;
			case "Spades": suitValue = 3; break;
				
		}
	}

	public String toString()
	{
		if (value <= 10 && value > 1) {
			return value + " of " + suit;
		} else {
			String face = "";
			switch (value) {
				case 1: face = "Ace"; break;
				case 11: face = "Jack"; break;
				case 12: face = "Queen"; break;
				case 13: face = "King"; break;
			}
			return face + " of " + suit;
		}
	}
	
	public int compareTo(Card other) {
		return value - other.value;
	}

	// for testing purposes
	public static void main(String[] args)
	{
		for (int i = 0; i < 10; i++)
		{
			Card c = new Card((int) (Math.random() * 13 + 1), "Clubs");
			System.out.println(c);
		}
	}

}