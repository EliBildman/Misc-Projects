package APCS;
import java.util.ArrayList;
import java.util.Arrays;


public class RemoveObjectsFromAList
{
    public static void main(String[] args)
    {
        String s = "This is a sort of long and overly wordy sentence.";
        
        ArrayList<String> sentence = new ArrayList<String>(Arrays.asList(s.split(" ")));
        
        removeFromList(sentence, 3, 6);
        
        System.out.println(asString(sentence));
    }
    
    /**
     * Remove howMany objects from the ArrayList s starting at index start
     * @param s - ArrayList from which to remove items
     * @param start - index in the list to start removing objects 
     * @param howMany - the number of objects to remove from the list
     */
    private static void removeFromList(ArrayList<String> s, int start, int howMany)
    {
        // TODO: write code that will remove howMany items from the ArrayList s
        // starting at index start
    	
    	for (int i = 0; i < howMany; i++) {
    		s.remove(start);
    	}
        
    }
    
    private static String asString(ArrayList<String> s)
    {
        String str = s.toString();
        str = str.substring(1, str.length() - 1);
        str = str.replace(",","");
        return str;
    }

}