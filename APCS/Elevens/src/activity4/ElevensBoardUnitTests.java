package activity4;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;

import testHelp.*;

public class ElevensBoardUnitTests 
{
    @Test
    public void BoardConstructorShouldNotThrow()
    {
        verify.that(() -> new ElevensBoard()).doesNotThrow();
    }
    
    @Test
    public void BoardShouldHoldNineCards()
    {
        IBoard board = new ElevensBoard();
        verify.that(board.getBoardSize()).isEqualTo(9);
    }

    @Test
    public void BoardShouldStartWithNineCards()
    {
        IBoard board = new ElevensBoard();
        verify.that(board.getCardIndices().size()).isEqualTo(9);
    }
    
    @Test
    public void NewGameShouldReplaceCards()
    {
        ElevensBoard one = new ElevensBoard();
        ElevensBoard two = new ElevensBoard();
        verify.that(one.onBoard).isNotEqualTo(two.onBoard);
        // Create a new ElevensBoard, use the getCards method
        // defined below to get all the cards on the board, create
        // a new game and do the same thing, then:
        // verify.that(firstGame).isNotEqualTo(secondGame);
    }
    
    @Test
    public void DealShouldReplaceCardAtFirstIndex()
    {
        ElevensBoard test = new ElevensBoard();
        Card one = test.getCard(0);
        test.deal(0);
        Card two = test.getCard(0);
        verify.that(one).isNotEqualTo(two);
        // Create a new ElevensBoard, get the card at position 0,
        // deal to position 0 on the board, verify that the new
        // card at position 0 is not equal to the original card at 0
    }
    
    @Test
    public void DealShouldReplaceCardAtLastIndex()
    {
    	ElevensBoard test = new ElevensBoard();
        Card one = test.getCard(8);
        test.deal(8);
        Card two = test.getCard(8);
        verify.that(one).isNotEqualTo(two);
        // Same as above, but for position 8
    }
    
    @Test
    public void GameIsWonIfDeckAndTableAreClear() {
        String[] empty = {};
        int[] iempty = {};
        Deck thing = new Deck(empty, empty, iempty);
        ElevensBoard test = new ElevensBoard(thing);
        verify.that(test.gameIsWon()).isTrue();
        // Create an empty deck, create an ElevensBoard with this
        // deck, and verify that the game is won (since both the deck
        // and the board are empty)
    }
    
    @Test
    public void GameIsNotOverIfDeckContainsCards()
    {
        IBoard board = new ElevensBoard();
        verify.that(board.gameIsWon()).isFalse();
    }
    
    @Test
    public void GameIsNotOverIfTableHasCards()
    {
        Deck d = new Deck(new String[] {"rank1", "rank2"}, new String[] {"suit1"}, new int[] {1, 2});
        IBoard board = new ElevensBoard(d); // will have 2 cards on table, none left in deck
        verify.that(board.gameIsWon()).isFalse();
    }
    
    @Test
    public void TableSlotsAreEmptyWhenDeckRunsOut()
    {
        Deck d = new Deck(new String[] {"rank1", "rank2"}, new String[] {"suit1"}, new int[] {1, 2});
        IBoard board = new ElevensBoard(d);
        verify.that(board.getCardsLeftInDeck()).isEqualTo(0);
        
        // there should be just two card indices, 0 and 1
        verify.that(board.getCardIndices()).isEqualTo(Arrays.asList(new Integer[] { new Integer(0), new Integer(1) }));
    }
    
    private static ArrayList<Card> getCards(IBoard board)
    {
        ArrayList<Card> cards = new ArrayList<Card>();
        for (Integer i : board.getCardIndices())
            cards.add(board.getCard(i));
        return cards;
    }
}