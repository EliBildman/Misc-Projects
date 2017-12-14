package more;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

public class SentenceGenerator
{
    WordCounter counter;
    Random random;

    public SentenceGenerator(String filename) throws FileNotFoundException
    {
    	Tokenizer.tokenizeFile(filename);
        counter = new WordCounter(filename.substring(0, filename.length() - 4) + "_tokenized.txt");
        this.random = new Random();
    }

    public SentenceGenerator(String filename, Random random) throws FileNotFoundException
    {
    	Tokenizer.tokenizeFile(filename);
        counter = new WordCounter(filename.substring(0, filename.length() - 4) + "_tokenized.txt");
        this.random = random;
 
    }

    // given any word, randomly choose a word that could come next, using the
    // TextAnalyzer wordsThatCouldComeNext
    // return that sentence as a String
    public String randomlyChooseNextWord(String prevWord)
    {
        // TODO: implement this method
    	return randomlySelectWord(counter.getWordsThatCouldComeNext(prevWord));
    }

    // given a starting word, generate a random word that could come next, and a
    // random word that could come after that, etc.
    // keep going until you generate punctuation that could end a sentence, as
    // determined by TextAnalyzer isSentenceEndingPunctuation
    public String generateRandomSentence(String firstWord)
    {
        // TODO: implement this method
    	String end = firstWord;
    	String word = randomlyChooseNextWord(firstWord);
    	while (!counter.isSentenceEndingPunctuation(word)) {
    		if(word.equals(",") || word.equals(";") || word.equals(":")) end += word;
    		else end += " " + word;
    	word = randomlyChooseNextWord(word);
    	}
    	end += word;
    	return end;
    }

    // randomly choose a word that starts with a capital letter, and use that as
    // the first word of the sentence
    // then randomly generate the rest of the sentence using
    // generateRandomSentence(String firstWord)
    public String generateRandomSentence()
    {
        // TODO: implement this method
    	return generateRandomSentence(randomlySelectWord(counter.getAllWordsThatStartWithACapitalLetter()));
    }

    private String randomlySelectWord(ArrayList<String> possibleWords)
    {
        int randomIndex = random.nextInt(possibleWords.size());
        return possibleWords.get(randomIndex);
    }

    public static void main(String[] args) throws FileNotFoundException
    {
        SentenceGenerator sg = new SentenceGenerator("dream.txt");

        System.out.println(sg.counter.organizedWords());
        for(int i = 0; i < 10; i++) {
        	System.out.println(sg.generateRandomSentence());
        }
    	
    }
}