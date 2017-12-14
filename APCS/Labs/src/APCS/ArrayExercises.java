package APCS;

import java.util.*;

public class ArrayExercises 
{
	// Start with this main() method. Do not change it!
	public static void main(String[] args) 
	{
		Scanner console = new Scanner(System.in);
		System.out.print("Enter the first number: ");
		int start = console.nextInt();
		int finish = start;
		while (finish <= start)
		{
			System.out.print("Enter the last number (must be after first number): ");
			finish = console.nextInt();
		}
		
		// initialize an array to contain the numbers 'start' through 'finish', inclusive
		int[] numbers = buildArray(start, finish);
		
		// print the message passed in, then all the numbers in the array
		printArrayContents("Initial array:", numbers);
		
		// print the sum and average of the numbers
		printSumAndAverage(numbers);
		
		// add 1 to all numbers with odd values
		addOneToOddNumbers(numbers);
		
		// print the message and the array contents again
		printArrayContents("Array without odds:", numbers);
	}
	
	public static int[] buildArray(int start, int finish) {
		int[] finalArray = new int[finish - start + 1];
		for (int i = 0; i <= finish - start; i ++) {
			finalArray[i] = start + i;
		}
		return finalArray;
	}
	
	public static void printArrayContents(String strIn, int[] arrIn) {
		System.out.print(strIn);
		System.out.println(Arrays.toString(arrIn));
	}
	
	public static void printSumAndAverage(int[] arrIn) {
		int sum = 0;
		for (int i = 0; i < arrIn.length; i ++) {
			sum += arrIn[i];
		}
		System.out.println("Sum: " + sum);
		System.out.println("Average: " + ((0.00 + sum) / arrIn.length));
	}
	
	public static void addOneToOddNumbers(int[] arrIn) {
		for (int i = 0; i < arrIn.length; i++) {
			if (arrIn[i] % 2 != 0) {
				arrIn[i] += 1;
			}
		}
	}
}