/**********************************************************
 * Assignment: Lowest terms calculator
 *
 * Author: Eli Bildman
 *
 * Description: uses the card object to create a deck of cards then shuffle and deal them
 *
 * Academic Integrity: I pledge that this program represents my own work. I
 * received help from no one in designing and debugging
 * my program.
 **********************************************************/

package DeckOfCards;

public class Deck
{
	public static final int CARDS_IN_DECK = 52;
	public static final int CARDS_IN_SUIT = 13;

	// declare deck as a private field that is an array of Cards
	private Card[] deck = new Card[CARDS_IN_DECK];
	
	// declare undealt as a private int field
	
	private int undealt;

	public Deck()
	{
		String[] suits = { "Clubs", "Diamonds", "Hearts", "Spades" };
		int c = 0;
		for (String suit : suits)
		{
			for (int value = 1; value <= CARDS_IN_SUIT; value++)
			{
				// Uncomment the line below after you have declared deck
				deck[c] = new Card(value, suit);
				c++;
			}
		}
		// uncomment the line below after you have declared undealt;
		undealt = 0; // this will be the index of the next card to deal
	}

	public void print()
	{
		for (int i = 0; i < CARDS_IN_DECK; i ++) {
			System.out.println(deck[i]);
		}
	}

	public void shuffle()
	{
		int random;
		Card holder;
		for (int i = 0; i< 200; i++) {
			random = (int) (Math.random() * CARDS_IN_DECK);
			holder =  deck[random];
			deck[random] = deck[0];
			deck[0] = holder;
		}
	}

	public Card topCard()
	{
		undealt ++;
		return deck[undealt - 1];
	}

	public void deal(int n)
	{
		for (int i = 0; i < n; i ++) {
			System.out.println(topCard());
		}
	}

	// for testing purposes
	public static void main(String[] args)
	{
		Deck myDeck = new Deck();
		myDeck.shuffle();
		Card player1 = myDeck.topCard();
		Card player2 = myDeck.topCard();
		System.out.println("Player 1: " + player1);
		System.out.println("Player 2: " + player2);
		int compare = player1.compareTo(player2);
		if (compare > 0) {
			System.out.println("Player 1 wins!");
		} else if (compare < 0) {
			System.out.println("Player 2 wins!");
		} else {
			if (player1.suitValue < player2.suitValue) {
				System.out.println("Player 1 wins!");
			} else {
				System.out.println("Player 2 wins!");
			}
		}
	}
}