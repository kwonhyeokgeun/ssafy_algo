package basic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Hashmap {

	public static void main(String[] args) {
		Map<Character, int[]> dic= new HashMap<>();
		dic.put('U', new int[]{0,-1});
		dic.put('D', new int[]{0, 1});
		dic.put('L', new int[]{-1, 0});
		dic.put('R', new int[]{1, 0});
		System.out.println(Arrays.toString(dic.get('R')));
			
	}

}
