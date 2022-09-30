package bj;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BJ0930_1로만들기 {

	static int sol() {
		Deque<Point> que = new ArrayDeque<>();
		que.add(new Point(N,0));
		while(!que.isEmpty()) {
			Point cur = que.pollFirst();
			int ci=cur.x;
			int num=cur.y;
			if(ci==1) {
				return num;
			}
			if(ci%3==0) {
				int ni=ci/3;
				if(ni<1)continue;
				if(mem[ni]==0 || (mem[ni]!=0 && mem[ni]>num+1)) {
					mem[ni]=num+1;
					que.add(new Point(ni,num+1));
				}
			}if(ci%2==0) {
				int ni=ci/2;
				if(ni<1)continue;
				if(mem[ni]==0 || (mem[ni]!=0 && mem[ni]>num+1)) {
					mem[ni]=num+1;
					que.add(new Point(ni,num+1));
				}
			} 
			
			int ni=ci-1;
			if(ni<1)continue;
			if(mem[ni]==0 || (mem[ni]!=0 && mem[ni]>num+1)) {
				mem[ni]=num+1;
				que.add(new Point(ni,num+1));
			}
		}
		return-1;
	}
	
	static int N;
	static int[] mem;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		mem=new int[N+1];
		int answer=sol();
		System.out.println(answer);
		
	}
}
