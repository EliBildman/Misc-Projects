package Activity1;

import org.junit.Test;
import testHelp.*;

public class CardTests
{

    @Test
    public void CardConstructorShouldNotCrash()
    {
        Card test = new Card("Two", "Hearts", 2);
        verify.that(test).isOfType(Card.class);
    }
    
    @Test
    public void CardShouldReturnRank()
    {
        Card test = new Card("Two", "Hearts", 2);
        verify.that(test.getRank()).isEqualTo("Two");
    }
    
    @Test
    public void differentValueReturnsFalseForEquals()
    {
        Card a = new Card("Ace", "Spades", 1);
        Card b = new Card("Ace", "Spades", 2);
        verify.that(a.equals(b)).isFalse("because value is different");
    }
    
    @Test
    public void returnsTrue() {
    	Card a = new Card("Ace", "Spades", 1);
        Card b = new Card("Ace", "Spades", 1);
        verify.that(a.equals(b)).isTrue();
    }
    
    @Test
    public void returnFalseIfRankIsDiff() {
    	Card a = new Card("Ace", "Spades", 1);
        Card b = new Card("One", "Spades", 1);
        verify.that(a.equals(b)).isFalse();
    }
    
    @Test
    public void returnsFalseIfSuitIsDiff() {
    	Card a = new Card("One", "Hearts", 2);
        Card b = new Card("One", "Spades", 2);
        verify.that(a.equals(b)).isFalse();
    }
    
    @Test
    public void falseIfSuitAndValueAreDiff() {
    	Card a = new Card("One", "Diamonds", 1);
        Card b = new Card("One", "Spades", 2);
        verify.that(a.equals(b)).isFalse();
    }
    
    @Test
    public void falseIfSuitAndRankAreDiff() {
    	Card a = new Card("One", "Spades", 1);
        Card b = new Card("Three", "Hearts", 1);
        verify.that(a.equals(b)).isFalse();
    }
    
    @Test
    public void falseIfRankAndValueAreDiff() {
    	Card a = new Card("One", "Spades", 1);
        Card b = new Card("Two", "Spades", 2);
        verify.that(a.equals(b)).isFalse();
    }
    
    @Test
    public void falseIfAllValuesAreDiff() {
    	Card a = new Card("One", "Spades", 1);
        Card b = new Card("Two", "Diamonds", 2);
        verify.that(a.equals(b)).isFalse();
    }
    
    @Test
    public void falseIfPassedNull() {
    	Card a = new Card("One", "Spades", 1);
        Card b = null;
        verify.that(a.equals(b)).isFalse();
    }
    
    @Test
    public void falseIfPassedNoncardObject() {
    	Card a = new Card("One", "Spades", 1);
        Object b = new Object();
        verify.that(a.equals(b)).isFalse();
    }
    
    @Test
    public void trueIfComparedToSelf() {
    	Card a = new Card("One", "Spades", 1);
        verify.that(a.equals(a)).isTrue();
    }
    
    @Test
    public void toStringReturnsPropervalue() // needs fixing
    {
        Card a = new Card("Ace", "Spades", 1);
        verify.that(a.toString()).isEqualTo("Ace of Spades (point value = 1)");
    }

    
    @Test
    public void CardShouldReturnSuit() {
    	Card test = new Card("One", "Spades", 5);
    	verify.that(test.getSuit()).isEqualTo("Spades");
    }
    
    @Test
    public void CardShouldReturnValue() {
    	Card test = new Card("One", "Spades", 5);
    	verify.that(test.getValue()).isEqualTo(5);
    }
    // other unit tests would go here
}