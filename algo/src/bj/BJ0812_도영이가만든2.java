package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class BJ0812_도영이가만든2 {
	
	static void comb(int idx,int ct0, int ct1) { //인덱스, 신맛, 쓴맛
		if(idx==N) {
			return;
			
		}
		int nt0, nt1;
		for(int i=idx; i<N; i++) {
			nt0=ct0*lst[i][0];
			nt1=ct1+lst[i][1];
			answer=Math.min(answer, Math.abs(nt0-nt1));
			comb(i+1, nt0, nt1);
		}
	}
	
	static int N;
	static int lst[][];
	static int answer=Integer.MAX_VALUE;
	static int mask;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn;
		N=Integer.parseInt(br.readLine());
		lst=new int[N][2];
		
		for(int i=0;i<N; i++) {
			stn=new StringTokenizer(br.readLine());
			lst[i][0] = Integer.parseInt(stn.nextToken());
			lst[i][1] = Integer.parseInt(stn.nextToken());
		}
		comb(0,1,0);
		System.out.println(answer);
	}
}
