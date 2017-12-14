package APCS;

public class InsertionSort
{
	public static void InsertionShort(int[] arr) {
		int num;
		for (int i = 1; i < arr.length; i++) {
			num = arr[i];
			if (arr.length - 1 == i || num < arr[i + 1]) {
				for (int n = i - 1; n >= 0; n--) {
					arr[n + 1] = arr[n];
					if (n == 0 || arr[n - 1] < num) {
						arr[n] = num;
						break;
					}
				}
			}
		}
	}

	public static void main(String[] argz) {
		int[] arr = new int[]{101, 5, 34, 38938, 3424, 32423, 24, 43, 50, 60};
		for (int i: arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		InsertionShort(arr);
		for (int i: arr) {
			System.out.print(i + " ");
		}

	}
}
