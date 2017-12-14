/**********************************************************
 * Assignment: Lowest terms calculator
 *
 * Author: Eli Bildman
 *
 * Description: runs the game rock paper scissors, then reports win losses ties and win percentage		
 *
 * Academic Integrity: I pledge that this program represents my own work. I
 * received help from no one in designing and debugging
 * my program.
 **********************************************************/

package APCS;
import java.util.*;

public class RPS
{

	public static void main(String[] args) {
		String userChoice = "";
		int won = 0;
		int lost = 0;
		int ties = 0;
		
		while (true) {
			userChoice = getUserChoice();
			if (userChoice.equals("quit")) {
				break;
			}
			System.out.println("You chose " +  userChoice);
			String compChoice = getCompChoice();
	
			System.out.println("The computer chose " + compChoice);
			String result = compare(compChoice, userChoice);
			if (result.equals("You won!")) {
				won ++;
			} else if (result.equals("The computer won!")) {
				lost ++;
			} else {
				ties ++;
			}
			System.out.println(result);
			System.out.println();
		}
		
		System.out.println("Games Won: " + won);
		System.out.println("Games Lost: " + lost);
		System.out.println("Games Tied: " + ties);
		System.out.println("Win Percent " + ( (int) (100 * won / ((double) won + lost + ties) + 0.5)) + "%");
		
		
	}
	
	public static String getUserChoice(){
		Scanner console = new Scanner(System.in);

		String userChoice = "meme";
		while (!(userChoice.equals("rock")) && !(userChoice.equals("paper")) && !(userChoice.equals("scissors")) && !(userChoice.equals("quit"))) {
			System.out.print("Choose rock, paper, or scissors: ");
			userChoice = console.next();
			//System.out.println(userChoice);
		}

		return userChoice;

	}
	
	public static String getCompChoice() {
		String compChoice;
		double rng = (int) (Math.random() * 3);
		
		if (rng == 0) {
			compChoice = "rock";
		} else if (rng == 1) {
			compChoice = "paper";
		} else {
			compChoice = "scissors";
		}
		
		return compChoice;
	}
	
	public static String compare(String comp, String user) {
		if (user.equals("rock")) {
			if (comp.equals("scissors")) {
				return "You won!";
			} else if (comp.equals("rock")) {
				return "It was a tie!";
			} else {
				return "The computer won!";
			}
		} else if (user.equals("scissors")) {
			if (comp.equals("paper")) {
				return "You won!";
			} else if (comp.equals("scissors")) {
				return "It was a tie!";
			} else {
				return "The computer won!";
			}	
		} else {
			if (comp.equals("rock")) {
				return "You won!";
			} else if (comp.equals("paper")) {
				return "It was a tie!";
			} else {
				return "The computer won!";
			}
		}
	}
	
}
