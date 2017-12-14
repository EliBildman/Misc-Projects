package more;

import java.io.*;
import java.util.*;

public class Tokenizer
{
	
	public static void tokenizeFile(String filename) throws FileNotFoundException {
		File outfile = new File(filename.substring(0, filename.length() - 4) + "_tokenized.txt");
		PrintStream output = new PrintStream(outfile);
		FileReader file = new FileReader(filename);
		Scanner fileScanner = new Scanner(file);
		while(fileScanner.hasNext()) {
			String token = fileScanner.next();
			output.print(tokenize(token));
		}
		fileScanner.close();
		output.close();
	}
	
	private static String tokenize(String word) {
		String tokens = ",./?!\":;{}[]|\\()@#$%^&*-=_+";
		for(int i = 0; i < word.length(); i ++) {
			if(tokens.contains(word.charAt(i) + "")) {
				word = word.substring(0, i) + " " + word.charAt(i);
				i++;
			}
		}
		return word + " ";
	}
	
	public static void main(String[] arsasf) throws FileNotFoundException {
		Tokenizer.tokenizeFile("nottoken.txt");
	}
			
}
