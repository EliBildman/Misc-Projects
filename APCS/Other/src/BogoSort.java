import java.util.Arrays;

public class BogoSort
{
	public static void bogo(int[] in) {
		int one;
		int two;
		int holder;
		int count = 0;
		while (!check(in)) {
			one =  (int) (Math.random() * in.length);
			two =  (int) (Math.random() * in.length);
			holder = in[one];
			in[one] = in[two];
			in[two] = holder;
			count ++;
			System.out.println(count + " " + Arrays.toString(in));
		}
	}
	
	public static boolean check(int[] in){
		for(int i = 0; i < in.length - 1; i ++) {
			if (in[i] > in[i + 1]) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		int[] memeo = {3, 7, 1, 2, 9, 0, 2, 3, 7};
		bogo(memeo);

	}
}
