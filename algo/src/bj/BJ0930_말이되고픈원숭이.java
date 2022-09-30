package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;


public class BJ0930_말이되고픈원숭이 {
	
	static int sol() {
		Deque<Point> que = new ArrayDeque<>();
		que.add(new Point(0,0,0,0));
		while(!que.isEmpty()) {
			Point cur=que.pollFirst();
			int cx=cur.x, cy=cur.y;
			int cnt=cur.cnt;
			int k=cur.k;
			for(int dr=0;dr<4;dr++) { //원숭이점프
				int nx=cx+dirs[dr][0];
				int ny=cy+dirs[dr][1];
				if(nx<0 || ny<0 || nx>=W || ny>=H || mat[ny][nx]==1)continue;
				if(nx==W-1 && ny==H-1) return cnt+1;
				if(mem[ny][nx][k]!=0 && mem[ny][nx][k]<=cnt+1) continue;
				mem[ny][nx][k]=cnt+1;
				que.add(new Point(nx,ny,cnt+1,k));
			}
			if(k<K) {
				for(int dr=0;dr<8;dr++) { //말점프
					int nx=cx+dirs2[dr][0];
					int ny=cy+dirs2[dr][1];
					if(nx<0 || ny<0 || nx>=W || ny>=H || mat[ny][nx]==1)continue;
					if(nx==W-1 && ny==H-1) return cnt+1;
					if(mem[ny][nx][k+1]!=0 && mem[ny][nx][k+1]<=cnt+1) continue;
					mem[ny][nx][k+1]=cnt+1;
					que.add(new Point(nx,ny,cnt+1,k+1));
				}
			}
		}
		
		
		return -1;
	}
	
	static int[][] dirs= {{1,0},{0,1},{-1,0},{0,-1}};
	static int[][] dirs2= {{2,1},{1,2},{-1,2},{-2,1},{-2,-1},{-1,-2},{1,-2},{2,-1}};
	static int K;
	static int H,W;
	static int[][] mat;
	static int[][][] mem;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K=Integer.parseInt(br.readLine());
		StringTokenizer stn = new StringTokenizer(br.readLine());
		W=Integer.parseInt(stn.nextToken());
		H=Integer.parseInt(stn.nextToken());
		mat=new int[H][W];
		mem=new int[H][W][K+1];
		
		for(int y =0; y<H; y++) {
			stn=new StringTokenizer(br.readLine());
			for(int x=0; x<W; x++) {
				mat[y][x]=Integer.parseInt(stn.nextToken());
			}
		}
		
		int answer;
		if(H==1 && W==1) {
			answer=0;
		}
		else {
			answer=sol();
		}
		
		System.out.println(answer);
		
		
	}
	
	static class Point{
		int x,y,cnt,k;
		Point(int x, int y, int cnt, int k){
			this.x=x;
			this.y=y;
			this.cnt=cnt;
			this.k=k;
		}
	}
}
