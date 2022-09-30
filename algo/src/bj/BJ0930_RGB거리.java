package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ0930_RGB거리 {
	
	static void rec(int ind,int sum, int pc) {
		if(ind>N) {
			answer=Math.min(answer,sum);
			return;
		}
		
		for(int cc=0; cc<3; cc++) {
			if(cc==pc)continue; //현재color과 이전color와 같으면안댐
			if((mem[ind][cc]!=0 && mem[ind][cc]>sum+price[ind][cc]) || mem[ind][cc]==0) {
				mem[ind][cc]=sum+price[ind][cc];
				rec(ind+1,sum+price[ind][cc], cc);
			}
		}
	}
	
	static int N;
	static int[][] price;
	static int answer;
	static int[][] mem; //색깔별로 최솟값 기억 

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		price=new int[N+1][3];
		for(int i=1; i<=N; i++) {
			StringTokenizer stn = new StringTokenizer(br.readLine());
			price[i][0]=Integer.parseInt(stn.nextToken());
			price[i][1]=Integer.parseInt(stn.nextToken());
			price[i][2]=Integer.parseInt(stn.nextToken());
		}
		
		answer=Integer.MAX_VALUE;
		mem=new int[N+1][3];
		for(int i=0; i<3; i++) {
			
			rec(2,price[1][i],i);
			
		}
		System.out.println(answer);
		
		
		
	}
}
