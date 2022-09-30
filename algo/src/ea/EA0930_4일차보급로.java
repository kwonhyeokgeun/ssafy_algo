package ea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


public class EA0930_4일차보급로 {

	
	static void sol() {
		PriorityQueue<Point> hp = new PriorityQueue<>( (o1,o2) ->o1.cnt-o2.cnt);
		hp.add(new Point(0,0,0));

		while(!hp.isEmpty()) {
			Point cur=hp.poll();
			int cx=cur.x, cy=cur.y, cnt=cur.cnt;
			for(int dr=0; dr<4; dr++) {
				int nx=cx+dirs[dr][0];
				int ny=cy+dirs[dr][1];
				if(nx<0 || ny<0 || nx>=N || ny>=N)
					continue;
				if(mem[ny][nx]<=cnt+mat[ny][nx]) //더빠르게 방문한기록있으면
					continue;
				mem[ny][nx]=cnt+mat[ny][nx];
				if(nx==N-1 && ny==N-1) {
					answer=mem[ny][nx];
					return;
				}
				hp.add(new Point(nx,ny,cnt+mat[ny][nx]));
				
			}			
		}
	}
	
	static int[][] dirs= {{1,0},{0,1},{-1,0},{0,-1}};
	static int N;
	static int[][] mat;
	static int[][] mem;
	static int answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int  tc=1; tc<=T; tc++) {
			N=Integer.parseInt(br.readLine());
			mat=new int[N][N];
			mem=new int[N][N];
			for(int y=0; y<N; y++) {
				String row=br.readLine();
				for(int x=0; x<N; x++) {
					mat[y][x]=row.charAt(x)-'0';
					mem[y][x]=100000;
				}
			}

			sol();
			answer=mem[N-1][N-1];
			System.out.printf("#%d %d\n",tc,answer);
			
		}
		

	}
	static class Point{
		int x,y,cnt;
		Point(int x, int y, int cnt){
			this.x=x;
			this.y=y;
			this.cnt=cnt;
		}
	}
}
