package cp3;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class WordCounter implements TextAnalyzer
{
	public HashMap<String, Integer> words = new HashMap<String, Integer>();
	HashMap<String, ArrayList<String>> combos = new HashMap<String, ArrayList<String>>();
	ArrayList<String> capitalWords = new ArrayList<String>();
	
	public WordCounter(String name) throws FileNotFoundException {
		FileReader file = new FileReader(name);
		Scanner fileScanner = new Scanner(file);
		String last = "";
		while(fileScanner.hasNext()) {
			String token = fileScanner.next();
			if(startsWithCapitalLetter(token)) {
				capitalWords.add(token);
			}
			if(words.containsKey(token)) {
				int num = words.get(token) + 1;
				words.remove(token);
				words.put(token, num);
			} else {
				words.put(token, 1);
			}
			ArrayList<String> values = new ArrayList<String>();
			if(combos.containsKey(last) && last != "") {
				values = combos.remove(last);
				values.add(token);
				combos.put(last, values);
			} else if(last != "") {
				values = new ArrayList<String>();
				values.add(token);
				combos.put(last, values);
			} 

			last = token;
		}
		fileScanner.close();
	}
	
	public static void main(String[] argzz) throws FileNotFoundException {
		WordCounter counter = new WordCounter("tale_of_two_cities_tokenized.txt");
		System.out.println(counter.combos);
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
		return combos.get(prevWord);
	}

	@Override
	public ArrayList<String> getAllWordsThatStartWithACapitalLetter()
	{
		return capitalWords;
	}
	
	

	@Override
	public int numberOfSentences()
	{
		int counter = 0;
		for(String key: words.keySet()) {
			if (isSentenceEndingPunctuation(key)) {
				counter += getWordCounts(key);
			}
		}
		return counter;
	}

}
