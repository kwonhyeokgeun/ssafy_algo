package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ0811_다리놓기 {
	
	static int rec(int src, int tgt) {
		if(dp[src][tgt]!=0) return dp[src][tgt];
		
		if(src==tgt || tgt==0) {
			dp[src][tgt]=1;
			return 1;
		}
		
		dp[src][tgt]= rec(src-1, tgt-1)+rec(src-1,tgt);
		return dp[src][tgt];
	}

	public static int N,M;
	public static int[][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader( System.in));
		StringTokenizer stn;
		
		int T= Integer.parseInt(br.readLine());
		int answer;
		for(int tc=1; tc<=T; tc++) {
			stn = new StringTokenizer(br.readLine());
			N=Integer.parseInt(stn.nextToken());
			M=Integer.parseInt(stn.nextToken());
			dp=new int[M+1][N+1];
			answer=rec(M,N);
			System.out.println(answer);
			
		}

	}

}
