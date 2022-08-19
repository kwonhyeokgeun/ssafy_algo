package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2098
public class BJ0819_외판원순회 {
	
	static void rec(int n, int pi, int time, int cmask) {
		if(n==N-1) {
			if(mat[pi][0]!=0) {
				answer=Math.min(answer, time+mat[pi][0]);
			}
			return;
		}
		
		for(int i=1; i<N; i++) {
			if((cmask& 1<<i)!=0 || mat[pi][i]==0) {
				continue;
			}
			int time2 = time+mat[pi][i];
			if(time2>=answer) {
				continue;
			}
			int nmask=cmask|1<<i;
			if(visited[i][nmask]!=0 && visited[i][nmask] <=time2) 
				continue;
			visited[i][nmask]=time2;
			rec(n+1,i,time2, nmask);
			
		}
	}

	static int N, answer;
	static int[][] mat;
	static int[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn;
		N=Integer.parseInt(br.readLine());
		answer=Integer.MAX_VALUE;
		visited=new int[N][1<<N+1];
		mat=new int[N][N];
		for(int y=0; y<N; y++) {
			stn=new StringTokenizer(br.readLine());
			for(int x=0; x<N; x++) {
				mat[y][x]=Integer.parseInt(stn.nextToken());
			}
		}
		rec(0,0,0,1);
		System.out.println(answer);
	}

}
