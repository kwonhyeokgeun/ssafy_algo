package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


//https://www.acmicpc.net/problem/11659
public class BJ0803_구간합구하기4 {
	
	static public int N,M;
	static public int sums[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer stn = new StringTokenizer(br.readLine());
		N=Integer.parseInt(stn.nextToken());
		M=Integer.parseInt(stn.nextToken());
		
		sums = new int[N+1];
		stn = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			sums[i]=sums[i-1]+Integer.parseInt(stn.nextToken());
		}
		
		//System.out.println(Arrays.toString(sums));
		int s,e;
		for(int __ =0; __<M; __++) {
			stn = new StringTokenizer(br.readLine());
			s=Integer.parseInt(stn.nextToken());
			e=Integer.parseInt(stn.nextToken());
			sb.append(sums[e]-sums[s-1]).append("\n");
			
		}
		System.out.println(sb);
	}
}
