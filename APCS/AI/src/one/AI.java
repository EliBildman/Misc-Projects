package one;

import java.util.Random;

public class AI
{
	String code;
	int size;
	
	public AI(String code) {
		this.code = code;
		size = code.length();
	}
	
	public String runTheNumbers() {
		int co = 0;
		Random r = new Random();
		String guess = "";
		String lastGuess;
		for(int i = 0; i < code.length(); i++) guess += "x";
		while(getScore(guess) != 1.0) {
			co++;
			System.out.println(guess + " " + co);
			int ind = r.nextInt(size);
			char c = (char) (r.nextInt(128));
			lastGuess = guess;
			guess = replace(guess, ind, c);
			if(getScore(guess) < getScore(lastGuess)) {
				guess = lastGuess;
			}
		}
		return guess;
	}
	
	private static String replace(String input, int index, char c) {
		return input.substring(0, index) + c + input.substring(index + 1);
	}
	
	public double getScore(String input) {
		int counter = 0;
		for(int i = 0; i < size; i++) {
			if(code.charAt(i) == input.charAt(i)) counter ++;
		}
		return (double) counter / size;
	}
	
	public static void main(String[] args) {
		AI net = new AI("My name is tyler marcus and I'm here to help! I am clean at animation and i cannot seem to keep my dick in my pants!");
		System.out.println(net.runTheNumbers());
	}
}
