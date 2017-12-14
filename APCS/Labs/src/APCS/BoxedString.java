package APCS;
import java.util.*;

public class BoxedString
{

	public static void main(String[] args)
	{
		Scanner console = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String input = console.nextLine();
		System.out.print("Enter a size: ");
		int size = console.nextInt();
		
		makeLine((input.length() * (size * 2)) + 1);
		
		for (int i = 0; i < size - 1; i ++) {
			emptyRow(size, input.length());
		}
		
		System.out.print('|');
		for (int i = 0; i < input.length(); i++) {
			for (int x = 0; x < size - 1; x ++) {
				System.out.print(' ');
			}
			System.out.print(input.charAt(i));
			
			for (int x = 0; x < size - 1; x ++) {
				System.out.print(' ');
								
			}
			System.out.print('|');
		}
		System.out.println();
		
		for (int i = 0; i < size - 1; i ++) {
			emptyRow(size, input.length());
		}
		
		makeLine((input.length() * (size * 2)) + 1);
		
		
	}
	
	public static void makeLine(int length) {
		for (int i = 0; i < length; i ++) {
			System.out.print('-');
		}
		System.out.println();
	}
	
	public static void emptyRow(int size, int length) {
		System.out.print('|');
		for (int i = 0; i < length; i ++) {
			for (int x = 0; x < (size * 2) - 1; x ++) {
				System.out.print(' ');
			}
			System.out.print('|');
		}
		System.out.println();
	}

}
