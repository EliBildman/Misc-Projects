/**********************************************************
 * Assignment: Lowest terms calculator
 *
 * Author: Eli Bildman
 *
 * Description: initializes a person object, sets name and age then prints and does some simple math with it	
 *
 * Academic Integrity: I pledge that this program represents my own work. I
 * received help from no one in designing and debugging
 * my program.
 **********************************************************/

package APCS;
import java.util.*;

public class PersonMain
{
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		Person man = new Person("", 0);
		System.out.print("Enter the person's name: ");
		man.setName(console.nextLine());
		System.out.print("Enter the person's age: ");
		man.setAge(console.nextInt());
		
		System.out.println(man);
		System.out.println("There are " + (65 - man.getAge()) +" years until " + man.getName() + " reaches retirement age.");
	}

}