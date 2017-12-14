// Eli Bildman, Livia Severino

package APCS;
import java.util.*;

// a program that asks the user to think of a number, then tries
// to guess what it was.
public class GuessYourNumber {

    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        int[] numbersToGuess = initializeNumbers(10);
        
        System.out.println("Think of a number between 1 and 10 and I'll try to guess it.");
        
        // choose a number to guess, then ask the user if it was the right one. The
        // key thing here is that we're randomly choosing the INDEX of the number to 
        // guess, not directly choosing a number
        int indexOfGuess = (int) (Math.random() * numbersToGuess.length);
        System.out.print("Was it " + numbersToGuess[indexOfGuess] + "? ");
        /* missing code */
        String userInput = input.nextLine();
        // until the user1 says 'yes', keep guessing
        while (!userInput.equals("yes"))
        {
            // remove the number we just guessed from the list of numbers, so
            // we don't guess it again. If we run out of numbers, the user is
            // cheating!
            numbersToGuess = removeNumberFromList(numbersToGuess, indexOfGuess);
            if (numbersToGuess.length == 0)
            {
                System.out.println("What?!? That was all the numbers!");
                return;
            }
            
            // pick another number to guess, and ask the user if it is correct.
            indexOfGuess = (int) (Math.random() * numbersToGuess.length);
            System.out.print("Okay, then was it " + numbersToGuess[indexOfGuess] + "? ");
            userInput = input.nextLine();
        }
        
        // the user said we got it.
        System.out.println("Woohoo!");
        input.close();
        input.close();
    }
    
    // set up an array with 'howMany' numbers in it
    public static int[] initializeNumbers(int howMany)
    {
        int[] numbers = new int[howMany];
        for (int i = 0; i < howMany; i++)
        {
            numbers[i] = i + 1;
        }
        
        return numbers;
    }
    
    // remove the number at 'index' from the list 'list' by constructing a new list
    // that doesn't include the number we want to skip and returning that.
    public static int[] removeNumberFromList(int[] list, int index)
    {
        // make a new array that is one element smaller than the old one
        int[] newList = new int[list.length - 1];
        
        // copy all the values up to but not including the one we want to
        // leave out
        for (int i = 0; i < index; i++)
        {
            newList[i] = list[i];
        }
        
        // copy all the values *after* the one we want to leave out
        for (int j = index; j < newList.length; j++)
        {
            newList[j] = list[j + 1];
        }
        
        return newList;
    }
}
