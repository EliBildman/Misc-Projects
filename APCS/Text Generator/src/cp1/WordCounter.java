package cp1;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class WordCounter implements TextAnalyzer
{
	HashMap<String, Integer> words = new HashMap<String, Integer>();

	
	public WordCounter(String name) throws FileNotFoundException {
		FileReader file = new FileReader(name);
		Scanner fileScanner = new Scanner(file);
		while(fileScanner.hasNext()) {
			String token = fileScanner.next();
			if(words.containsKey(token)) {
				int num = words.get(token) + 1;
				words.remove(token);
				words.put(token, num);
			} else {
				words.put(token, 1);
			}	
		}
		fileScanner.close();
	}
	
	@Override
	public int getWordCounts(String word)
	{
		return words.get(word);
	}

	@Override
	public boolean startsWithCapitalLetter(String word)
	{
		return Character.isUpperCase(word.charAt(0));
	}

	@Override
	public boolean isSentenceEndingPunctuation(String word)
	{
		// TODO Auto-generated method stub
		return word.equals(".") || word.equals("!") || word.equals("?");
	}

	@Override
	public ArrayList<String> getWordsThatCouldComeNext(String prevWord)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> getAllWordsThatStartWithACapitalLetter()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int numberOfSentences()
	{
		// TODO Auto-generated method stub
		return 0;
	}
}
