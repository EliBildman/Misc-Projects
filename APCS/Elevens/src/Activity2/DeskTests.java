package Activity2;

import org.junit.Test;
import testHelp.*;
import java.util.*;

public class DeskTests {
	String[] ranks = {"One", "Two", "Three"};
	String[] suits = {"Hearts", "Spades", "Clubs"};
	int[] values = {1, 2, 3};
	@Test
    public void deckDoesNotCrashOnInitialization() {
    	Deck test = new Deck(ranks, suits, values);
    	verify.that(test).isOfType(Deck.class);
    }
	
	@Test
	public void constructorWorksForSingleCard() {
		String[] rank = {"Queen"};
		String[] suit = {"Hearts"};
		int[] value= {12};
		Deck test = new Deck(rank, suit, value);
		verify.that(test.cards.get(0)).isEqualTo(new Card("Queen", "Hearts", 12));
	}

	@Test
	public void sizeIsZeroAfterDealingCards() {
		Deck test = new Deck(ranks, suits, values);
		for (int i = 0; i < test.cards.size(); i ++) {
			test.deal();
		}
		verify.that(test.getCardsLeft() == 0).isTrue();
	}
	
	@Test
	public void createsCorrectlySizedList() {
		Deck test = new Deck(ranks, suits, values);
		verify.that(test.cards.size()).isEqualTo(9);
	}
	
	@Test
	public void createsCorrectList() {
		String[] xranks = {"One", "Two"};
		String[] xsuits = {"Hearts", "Clubs"};
		int[] xvalues = {1, 2};
		Deck test = new Deck(xranks, xsuits, xvalues);
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(new Card("One", "Hearts", 1));
		cards.add(new Card("Two", "Hearts", 2));
		cards.add(new Card("One", "Clubs", 1));
		cards.add(new Card("Two", "Clubs", 2));
		verify.that(test.cards).isEquivalentTo(cards);
	}
	
	@Test
	public void shuffleChangesOrder() {
		Deck test = new Deck(ranks, suits, values);
		Deck shuffled = new Deck(ranks, suits, values);
		shuffled.shuffle();
		verify.that(test.cards).isNotEqualTo(shuffled.cards);
	}
	
	@Test
	public void sizeCorrectAfterDealingOneCard() {
		Deck test = new Deck(ranks, suits, values);
		int initial = test.cards.size();
		test.deal();
		verify.that(test.getCardsLeft() == initial - 1).isTrue();
	}
	
	@Test
	public void dealCanReturnNull() {
		String[] emptyString = {};
		int[] emptyInt = {};
		Deck test = new Deck(emptyString, emptyString, emptyInt);
		verify.that(test.deal()).equals(null);
	}
	
	@Test
	public void dealDealsAllCards() {
		boolean isFax = true;
		Deck test = new Deck(ranks, suits, values);
		for (int i = 0; i < test.cards.size() - 1; i ++) {
			if (test.deal().getClass() != Card.class) isFax = false;
		}
		verify.that(isFax).isTrue();
	}


}
