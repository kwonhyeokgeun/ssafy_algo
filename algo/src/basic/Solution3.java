package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Solution3 {
	 
	static int N;
	static int[][] lst;
	static int[] answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn;
		N=Integer.parseInt(br.readLine());
		lst=new int[N+1][2];
		for(int i=1; i<=N; i++) {
			stn = new StringTokenizer(br.readLine());
			lst[i][0]=Integer.parseInt(stn.nextToken());
			lst[i][1]=Integer.parseInt(stn.nextToken());
		}
		answer=new int[N+1];
		for(int i=1; i<=N; i++) {
			int t=lst[i][0];
			int maxp=0;
			for(int j=i-1; j>=i-6; j--) {
				if(j<0)break;
				maxp=Math.max(maxp, answer[j]);
			}
			if(i+t-1<=N) {
				answer[i+t-1]=Math.max(answer[i+t-1], maxp+lst[i][1]);
			}
		}
		int ans=0;
		for(int i=1; i<=N; i++) {
			ans=Math.max(ans, answer[i]);
		}
		System.out.println(ans);
	}
	
	
}

