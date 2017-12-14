package APCS;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * WhatIsIt is a simple class that checks to see if some user input
 * is a String, a number, or a date.
 */
public class WhatIsIt 
{
    /**
     * printWhatThisIs should examine the text from the user and determine
     * whether it is a String, a number, or a date using these rules: 
     * 
     * If the text starts with a quote and ends with a quote, it is a string
     * and this method should print "It's a string!"
     * 
     * If the text can be parsed as a Double using Double.parseDouble, it 
     * is a number and this method should print "It's a number!"
     * 
     * If the text can be parsed with a SimpleDatFormat object's parse method,
     * it is a date and this method should print "It's a date!"
     * 
     * If none of the above rules applies, the type of input is undetermined
     * and this method should print out "I don't know what that is."
     * 
     * @param text - the user input to examine
     */
    private static void printWhatThisIs(String text)
    {
        // TODO: replace 'false' on the next line with the code that will 
        // actually check to see if text is a string based on whether it
        // starts and ends with quotes.
        if (text.charAt(0) == '"' && text.charAt(text.length() - 1) == '"')
        {
            System.out.println("It's a string!");
            return;
        }
    
        // the code below correctly prints "It's a number!" if text is
        // a number. You don't need to change it.
        try
        {
            double test = Double.parseDouble(text);
            System.out.println("It's a number!");
            return;
        }
        catch (Exception ex)
        {
            // it wasn't a number
        }

        // This try/catch block should print It's a date! if the text is a date. 
        try
        {
            // This SimpleDateFormat object is already created for you.
            SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
            
            format.parse(text);
            System.out.println("It's a date!");
            return;
            
            // TODO: you'll need to add about 3 lines here, very similar to the
            // lines above that check to see if text is a Double. Use the
            // SimpleDateFormat's parse method like the code above uses 
            // Double.parseDouble.
        }
        catch (Exception ex)
        {
            // it wasn't a date
        }
        
        System.out.println("I don't know what that is.");
    }

    /**
     * This main method collects some input from the user (whatever he or she
     * wants to type), then calls a method to print out what kind of input
     * the user typed (string, number, date, or unknown).
     * 
     * @param args - ignored
     */
    public static void main(String[] args) 
    {
        Scanner console = new Scanner(System.in);
        
        System.out.print("Type something: ");
        String input = console.nextLine();
        
        printWhatThisIs(input);
    }
}