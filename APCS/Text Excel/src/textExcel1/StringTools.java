/**********************************************************
 * Assignment: Lowest terms calculator
 *
 * Author: Eli Bildman
 *
 * Description: a center and repeated char method	
 *
 * Academic Integrity: I pledge that this program represents my own work. I
 * received help from no one in designing and debugging
 * my program.
 **********************************************************/


package textExcel1;
public class StringTools
{
    /**
     * This method centers a String in a field of given width
     * @param s - the String to be centered
     * @param width - the length of the returned string
     * @return the String s centered in a field of spaces width chars wide
     * If the length of s > width, then '>' is placed at the end of the
     * returned String
     */
    public String center(String s, int width)
    {
    	if (s.length() <= width) {
	    	String end = "";
	        int total = width - s.length();
	        end += repeatedChar(' ', total/2);
	        end += s;
	        end += repeatedChar(' ', total - total/2);
	        return end;
    	} else {
    		return s.substring(0, width - 1 ) + ">";
    	}
        
    }    

    /**
     * This method builds a String of repeated characters
     * @param ch - the character to be repeated
     * @param howMany - the number of times to repeat the character
     * @return the String made by repeating the character ch howMany times
     */
    public String repeatedChar(char ch, int howMany)
    {
        String end = "";
        for (int i = 0; i < howMany; i ++)
        	end += ch;
        return end;
    } 

    
    
}