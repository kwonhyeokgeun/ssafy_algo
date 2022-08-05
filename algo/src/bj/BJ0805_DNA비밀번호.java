package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ0805_DNA비밀번호 {
	
	public static int check() {
		for(int i=0;i<4;i++) {
			if (lims[i]>nums[i]) return 0;
		}
		return 1;
	}
	
	static int S,P;
	static int[] lst;
	static int[] lims = new int[] {0,0,0,0};
	static int[] nums = new int[] {0,0,0,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn = new StringTokenizer(br.readLine());
		int S=Integer.parseInt(stn.nextToken());
		int P = Integer.parseInt(stn.nextToken());
		String lst = br.readLine();
		
		stn = new StringTokenizer(br.readLine());
		for(int i=0;i<4;i++) {
			lims[i]=Integer.parseInt(stn.nextToken());
		}
		
		int answer=0;
		for(int i=0;i<P;i++) {
			switch( lst.charAt(i)) {
				case 'A':nums[0]++; break;
				case 'C':nums[1]++; break;
				case 'G':nums[2]++; break;
				case 'T':nums[3]++; break;				
			}
		}
		answer+=check();
		
		for(int i=1; i<=S-P;i++) {
			int j=i+P-1;
			switch( lst.charAt(i-1)) {
				case 'A':nums[0]--; break;
				case 'C':nums[1]--; break;
				case 'G':nums[2]--; break;
				case 'T':nums[3]--; break;
			}
			switch( lst.charAt(j)) {
				case 'A':nums[0]++; break;
				case 'C':nums[1]++; break;
				case 'G':nums[2]++; break;
				case 'T':nums[3]++; break;
			}
			answer+=check();
		}
		System.out.println(answer);

	}

}
