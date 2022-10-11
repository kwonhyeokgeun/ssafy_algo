package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BJ1004_소도쿠2239 {
	
	static void rec(int idx) {
		if(end) return;
		if(idx==81 && !end) {
			for(int y=0; y<9;y++) {
				for(int x=0; x<9; x++) {
					sb.append(mat[y][x]);
				}sb.append("\n");
			}
			end=true;
			return;
		}
		
		
		int x=idx%9;
		int y=idx/9;
		if(mat[y][x]!=0) {
			rec(idx+1);
			return;
		}
		
		Set<Integer> set = new HashSet<>();
		for(int i=0; i<9; i++) {
			set.add(mat[y][i]);
			set.add(mat[i][x]);
		}
		int x3=x-x%3;
		int y3=y-y%3;
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				set.add(mat[y3+i][x3+j]);
			}
		}
		
		for(int i=1; i<=9; i++) {
			if(!set.contains(i)) {
				mat[y][x]=i;
				rec(idx+1);
				mat[y][x]=0;
			}
		}
		
	}

	static int[][] mat;
	static boolean end;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb= new StringBuilder();
		mat= new int[9][9];
		for(int y=0; y<9; y++) {
			String row=br.readLine();
			for(int x=0; x<9; x++) {
				mat[y][x]=row.charAt(x)-'0';
			}
		}
		end=false;
		rec(0);
		System.out.println(sb);
		
	}

}
