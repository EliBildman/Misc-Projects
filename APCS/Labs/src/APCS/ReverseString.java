package APCS;
public class ReverseString
{
    public static void main(String[] args)
    {
        String s = "Opportunity Diversity Respect";

        System.out.println(s);

        s = reverse(s);
        
        System.out.println(s);
    }
    
    
    public static String reverse(String s) {
    	if (s.length() == 1) {
    		return s;
    	} else {
    		return s.charAt(s.length() - 1) + reverse(s.substring(0, s.length() - 1));
    	}
    }
}