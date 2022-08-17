package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BJ0817_쿼드트리 {
	
	static int isSame(int n2,int i, int j) {
		int tp=mat[j*n2][i*n2];
		System.out.printf("%d : %d %d %d %d\n",n2,i*n2, j*n2,(i+1)*n2,(j+1)*n2);
		for(int y=i*n2; y<(i+1)*n2; i++) {
			for(int x=j*n2; x<(j+1)*n2;j++) {
				if(mat[y][x]!=tp) {
					return -1;
					
				}
			}
		}
		
		return tp;
	}

	static void rec(int n, int sx, int sy) {
		if(n==2) {
			answer.append("(")
			.append(mat[sy][sx])
			.append(mat[sy][sx+1])
			.append(mat[sy+1][sx])
			.append(mat[sy+1][sx+1])
			.append(")");
			return;
		}
		
		int n2=n/2;
		for(int i=0; i<2; i++) {
			for(int j=0;j<2;j++) {
				answer.append("(");
				int type=isSame(n2,i,j);
				if(type!=-1) {
					answer.append(type+")");
				}else {
					rec(n/2,sx,sy);
					answer.append(")");
					rec(n/2,sx+n2,sy);
					answer.append(")");
					rec(n/2,sx,sy+n2);
					answer.append(")");
					rec(n/2,sx+n2,sy+n2);
					answer.append(")");
				}
			}
		}
	}
	
	static int N;
	static int[][] mat;
	static StringBuilder answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		mat=new int[N][N];
		for(int y=0; y<N; y++) {
			String row=br.readLine();
			for(int x=0; x<N; x++) {
				mat[y][x]=row.charAt(x);
			}
		}
		answer =new StringBuilder();
		rec(N,0,0);
		System.out.println(answer);
		
	

	}

}
