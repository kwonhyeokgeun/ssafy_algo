package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ0930_파이프옮기기1 {

	static void rec(int cx,int cy, int cdr) {
		if(cx==N-1 && cy==N-1) {
			answer++;
			return;
		}
		if(cdr==0) {
			if(check0(cx,cy)) {
				rec(cx+1,cy,0);
			}
			if(check1(cx,cy)) {
				rec(cx+1,cy+1,1);
			}
		}else if(cdr==1) {
			if(check0(cx,cy)) {
				rec(cx+1,cy,0);
			}
			if(check1(cx,cy)) {
				rec(cx+1,cy+1,1);
			}
			if(check2(cx,cy)) {
				rec(cx,cy+1,2);
			}
		}else {
			if(check1(cx,cy)) {
				rec(cx+1,cy+1,1);
			}
			if(check2(cx,cy)) {
				rec(cx,cy+1,2);
			}
		}
	}
	static boolean check0(int cx, int cy) {
		int nx=cx+1;
		if(nx>=N  || mat[cy][nx]==1) return false;
		return true;
	}
	static boolean check1(int cx, int cy) {
		int nx=cx+1;
		int ny=cy+1;
		if(nx>=N || ny>=N || mat[ny][nx]==1 || mat[ny][cx]==1 || mat[cy][nx]==1) return false;
		return true;
	}
	static boolean check2(int cx, int cy) {
		int ny=cy+1;
		if(ny>=N || mat[ny][cx]==1) return false;
		return true;
	}
	static int N;
	static int[][]mat;
	static int[][]dirs= {{1,0},{1,1},{0,1}};
	static int answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		mat=new int[N][N];
		StringTokenizer stn;
		for(int y=0; y<N; y++) {
			stn=new StringTokenizer(br.readLine());
			for(int x=0; x<N; x++) {
				mat[y][x]=Integer.parseInt(stn.nextToken());
			}
		}
		answer=0;
		rec(1, 0, 0);
		System.out.println(answer); 
		
	}

}
