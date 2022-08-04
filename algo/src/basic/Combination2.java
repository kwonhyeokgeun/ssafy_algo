package basic;

import java.util.Arrays;

public class Combination2 {

	static int[] src = {1,2,3,4,5};
	static int[] tgt = new int [3];
	public static void main(String[] args) {
		comb(0,0);
		

	}
	
	static void comb(int srcIdx, int tgtIdx) {
		if(tgtIdx == tgt.length) {
			System.out.println(Arrays.toString(tgt));
			return;
		}
		if(srcIdx ==src.length) return;
		
		tgt[tgtIdx]=src[srcIdx];
		comb(srcIdx+1, tgtIdx + 1);
		comb(srcIdx+1, tgtIdx);
		
	}

}
