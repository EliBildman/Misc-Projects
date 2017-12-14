package APCS;

import java.util.ArrayList;

public class ArrayListExample
{
    public static void main(String[] args)
    {
        ArrayList<String> motto = new ArrayList<String>();
        motto.add("Diversity");
        motto.add("Opportunity");
        motto.add("Respect");
        motto.add(0, motto.remove(1));
        System.out.println(motto);
        
        // add lines of code to fix the motto without
        // changing the original add statements

    }
}