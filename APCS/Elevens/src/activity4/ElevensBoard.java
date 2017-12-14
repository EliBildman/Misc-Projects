package activity4;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ElevensBoard implements IBoard {

	Deck cards;
    Card[] onBoard = new Card[9];
    public ElevensBoard()
    {
        String[] suits = {"Diamonds", "Hearts", "Spades", "Clubs"};
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        cards = new Deck(ranks, suits, values);
        newGame();
    }
    public ElevensBoard(Deck d)
    {
        cards = d;
        newGame();
    }
	
	@Override
	public void newGame()
	{
		cards.shuffle();
		for (int i = 0; i < onBoard.length; i ++) {
			onBoard[i] = cards.deal();
		}
	}

	@Override
	public int getBoardSize()
	{
		return onBoard.length;
	}

	@Override
	public boolean isEmpty()
	{
		for (int i = 0; i < onBoard.length; i ++) {
			if (onBoard[i] != null) {
				return false;
			}
		}
		return true;
	}

	@Override
	public void deal(int k)
	{
		onBoard[k] = cards.deal();
	}

	@Override
	public int getCardsLeftInDeck()
	{
		return cards.getCardsLeft();
	}

	@Override
	public Card getCard(int k)
	{
		return onBoard[k];
	}

	@Override
	public void replaceSelectedCards(List<Integer> selectedCards)
	{
		for (int index: selectedCards) {
			onBoard[index] = cards.deal();
		}	
	}

	@Override
	public List<Integer> getCardIndices()
	{
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		for (int i = 0; i < onBoard.length; i ++) {
			if (onBoard[i] != null) {
				indexes.add(i);
			}
		}
		return indexes;
	}

	@Override
	public boolean gameIsWon()
	{
		return isEmpty() && cards.isEmpty();
	}

	@Override
	public boolean isLegal(List<Integer> selectedCards)
	{
		ArrayList<Integer> selected = new ArrayList<Integer>();
		for (int i = 0; i < selectedCards.size(); i ++) selected.add(onBoard[selectedCards.get(i)].getValue());
		return ((selected.size() == 2 && selected.get(0) + selected.get(1) == 11) || (selected.size() == 3 && selected.contains(11) && selected.contains(12) && selected.contains(13)));
	}

	@Override
	public boolean anotherPlayIsPossible() {
		ArrayList<Integer> selected = new ArrayList<Integer>();
		for (int i = 0; i < 2; i ++) selected.add(0);
		for (int i = 0; i < onBoard.length; i ++) {
			for (int j = i + 1; j < onBoard.length; j ++) {
				selected.set(0, i);
				selected.set(1, j);
				if (onBoard[i] != null && onBoard[j] != null && isLegal(selected)) return true;
				for (int k = j + 1; k < onBoard.length; k ++) {
					selected.add(2, k);
					if (onBoard[i] != null && onBoard[j] != null && onBoard[k] != null && isLegal(selected)) return true;
					selected.remove(2);
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		String[] empty = {};
        int[] iempty = {};
        Deck thing = new Deck(empty, empty, iempty);
        ElevensBoard test = new ElevensBoard(thing);
	}


}
