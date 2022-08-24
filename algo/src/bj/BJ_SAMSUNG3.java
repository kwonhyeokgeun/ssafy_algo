package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/15684   사다리조작
public class BJ_SAMSUNG3 {
	
	static boolean check(int sx) {
		Deque<Integer> stack = new ArrayDeque<>();
		for(int y=0; y<h; y++) {
			for(int x=sx; x<=sx+1; x++) {
				if(mat[y][x]!=0) {
					if(stack.peekLast()==x) {
						stack.pollLast();
					}else {
						stack.add(x);
					}
				}
			}
		}
		return stack.isEmpty();
		
	}
	
	static void rec(int sx, int sy, int cnt) {
		if(answer==-1) return;
		if(sy==0) {
			if(check(sx)) { //이번 x에서는 추가 안해도되면 패스
				rec(sx+1,sy,cnt);
				return;
			}
		}
		for(int y=sy; y<)
	}
	
	static int h,w,N,answer;
	static int mat[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn = new StringTokenizer(br.readLine());
		w=Integer.parseInt(stn.nextToken());
		N=Integer.parseInt(stn.nextToken());
		h=Integer.parseInt(stn.nextToken())-1;
		
		mat=new int[h][w+2];
		for(int i=0; i<N; i++) {
			stn = new StringTokenizer(br.readLine());
			int y=Integer.parseInt(stn.nextToken())-1;
			int x=Integer.parseInt(stn.nextToken());
			mat[y][x]=1;
		}
		for(int y=0; y<h; y++) {
			System.out.println(Arrays.toString(mat[y]));
		}
		answer=0;
	}
	
	static class XY{
		int x,y;
		XY(int x, int y){
			this.x=x;
			this.y=y;
		}
		boolean isSame(XY o) {
			if(o.x==this.x)return true;
			return false;
		}
	}
}
