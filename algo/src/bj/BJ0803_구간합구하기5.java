package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ0803_구간합구하기5 {
	
	public static void cal() {
		int sum=0;
		for(int y=sy; y<=ey;y++) {
			sum+=(sums[y][ex]-sums[y][sx-1]);
		}
		sb.append(sum).append("\n");
	}

	public static int N,M;

	public static int[][] sums;
	public static int sx,sy,ex,ey;
	public static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer stn = new StringTokenizer(br.readLine());
		N=Integer.parseInt(stn.nextToken());
		M=Integer.parseInt(stn.nextToken());
		sums=new int[N+1][N+1];
		for(int y=1; y<=N; y++) {
			stn= new StringTokenizer(br.readLine());
			for(int x=1; x<=N; x++) {
				sums[y][x]=sums[y][x-1]+Integer.parseInt(stn.nextToken());
			}
		}
		
		
		for(int __=0; __<M; __++) {
			stn = new StringTokenizer(br.readLine());
			sy=Integer.parseInt(stn.nextToken());
			sx=Integer.parseInt(stn.nextToken());
			ey=Integer.parseInt(stn.nextToken());
			ex=Integer.parseInt(stn.nextToken());
			cal();
		}
		System.out.println(sb);
	}

}
