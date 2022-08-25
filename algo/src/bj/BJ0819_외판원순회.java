package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2098
public class BJ0819_외판원순회 {
	
	static void rec(int e,int n, int mask) {
		if(n==N) {
			if(mat[e][0]!=0) {
				answer=Math.min(answer, mem[e][mask]+mat[e][0]);
			}
			return;
		}
		
		if(n==1) {
			for(int i=1; i<N; i++) {
				if(mat[0][i]==0)continue;
				int nmask=mask|(1<<i);
				mem[i][nmask]=mat[0][i];
				rec(i,2,nmask);
			}
		}
		else {
			for(int i=1; i<N; i++) {
				int bit=(1<<i);
				if( (mask&bit)!=0 || mat[e][i]==0) continue;
				int nmask = mask| bit;
				int sum=mem[e][mask]+mat[e][i];
				if(mem[i][nmask]==0 || mem[i][nmask] >sum) {
					mem[i][nmask] =sum;
					rec(i,n+1,nmask);
				}
				
			}
		}
	}

	static int N, answer;
	static int[][] mat;
	static int[][] mem;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn;
		N=Integer.parseInt(br.readLine());
		answer=Integer.MAX_VALUE;
		mem=new int[N][1<<N+1];
		mat=new int[N][N];
		for(int y=0; y<N; y++) {
			stn=new StringTokenizer(br.readLine());
			for(int x=0; x<N; x++) {
				mat[y][x]=Integer.parseInt(stn.nextToken());
			}
		}

		rec(0,1,1);
		
		
		System.out.println(answer);
	}

}
