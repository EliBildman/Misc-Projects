package Activity2;

import java.util.*;

public class Deck
{

	
		/**
		 * Creates a new Deck instance.
	
		 * It pairs each element of ranks with each element of suits,
		 * and produces one of the corresponding card.
		 * @param ranks is an array containing all of the card ranks.
		 * @param suits is an array containing all of the card suits.
		 * @param values is an array containing all of the card point values.
		 */
		private int dealt;
		ArrayList<Card> cards = new ArrayList<Card>();
		public Deck(String[] ranks, String[] suits, int[] values) 
		{
			/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
			for (String suit: suits) {
				for (int j = 0; j < ranks.length; j++) {
					cards.add(new Card(ranks[j], suit, values[j]));
				}
			}
			
		}
	
	
		/**
		 * Determines if this deck is empty (no undealt cards).
		 * @return true if this deck is empty, false otherwise.
		 */
		public boolean isEmpty() 
		{
			/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
			return getCardsLeft() == 0;
		}
	
		/**
		 * Accesses the number of undealt cards in this deck.
		 * @return the number of undealt cards in this deck.
		 */
		public int getCardsLeft() 
		{
			/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
			return cards.size() - dealt;
		}
	
		
		/**
		 * Randomly permute the given collection of cards
		 * and reset the size to represent the entire deck.
		 */
		public void shuffle() 
		{
			int index;
			for(int i = 0; i < 100; i++) {
				index = (int) (Math.random() * cards.size());
				cards.add(cards.remove(index));
			}
		}
	
		/**
		 * Deals a card from this deck.
		 * @return the card just dealt, or null if all the cards have been
		 *         previously dealt.
		 */
		public Card deal() {
			if (getCardsLeft() == 0) {
				return null;
			} else {
				dealt ++;
				return cards.get(dealt - 1);
			}
		}
		
		public static void main(String[] gunno) {
			String[] ranks = {"One", "Two", "Three"};
			String[] suits = {"Hearts", "Spades", "Clubs"};
			int[] values = {1, 2, 3};
			Deck test = new Deck(ranks, suits, values);
			for (int i = 0; i < test.cards.size(); i ++) {
				test.deal();
			}
		}
	
}

