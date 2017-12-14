package APCS;

import java.util.ArrayList;
import java.util.Arrays;

public class ReverseList
{
	
	public static void reverse(ArrayList<String> list) {
		String holder;
		for(int i = 0; i < list.size() / 2; i ++) {
			holder = list.get(i);
			list.set(i, list.get(list.size() - 1 - i));
			list.set(list.size() - 1 - i, holder);
		}
	}
	
	public static ArrayList<String> reverseRecurse(ArrayList<String> list) {
		if (list.size() == 1) {
			return list;
		}
		String holder = list.get(0);
		list.remove(0);
		reverseRecurse(list);
		list.add(holder);
		return list;
	}

    public static void main(String[] args)
    {
        ArrayList<String> fred = new ArrayList<String>(Arrays.asList("reverse this we shall".split(" ")));
        System.out.println(fred.toString());
        System.out.println(reverseRecurse(fred));
    }

}