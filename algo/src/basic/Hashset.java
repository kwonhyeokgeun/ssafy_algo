package basic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Hashset {

	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>();
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(1);
		set.remove(2);
		System.out.println(set); //[1, 3]
		Integer[] lst= {1,2,3,4};
		set.addAll(Arrays.asList(lst));
		System.out.println(set);  //[1, 2, 3, 4]
		
		HashSet<String> set2 = new HashSet<String>();
		set2.add("a");
		set2.add("b");
		set2.add("c");
		set2.add("a");
		System.out.println(set2); //[a, b, c]
		

		
	}

}
