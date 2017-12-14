package textExcel5;

public class InsertionSort
{
	public static void DoubleInsertionSort(double[] arr) {
		double num;
		for (int i = 1; i < arr.length; i++) {
			num = arr[i];
			if (num < arr[i - 1]) {
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
	
	public static void CellInsertionSort(Cell[] arr) {
		Cell num;
		for (int i = 1; i < arr.length; i++) {
			num = arr[i];
			if (Double.parseDouble(num.getDisplayValue()) < Double.parseDouble(arr[i - 1].getDisplayValue())) {
				for (int n = i - 1; n >= 0; n--) {
					arr[n + 1] = arr[n];
					if (n == 0 || Double.parseDouble(arr[n - 1].getDisplayValue()) < Double.parseDouble(num.getDisplayValue())) {
						arr[n] = num;
						break;
					}
				}
			}
		}
	}
	
	public static void main(String[] why) {
		double[] arr = new double[3];
		arr[0] = 3.0;
		arr[1] = 10141.0;
		arr[2] = 2.0;
		DoubleInsertionSort(arr);
		for (double thing: arr) {
			System.out.print(thing + " ");
		}
	}

}
