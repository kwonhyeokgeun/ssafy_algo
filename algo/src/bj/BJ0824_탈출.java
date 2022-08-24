package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class BJ0824_탈출 {
	
	static void moveWater() { //물 한칸씩 이동
		List<Item> nlst=new ArrayList<>();
		for(Item cur:lst) {
			for(int dr=0; dr<4; dr++) {
				int nx=cur.x+dirs[dr][0];
				int ny=cur.y+dirs[dr][1];
				if(nx<0 || ny<0 || nx>=w || ny>=h || mat[ny][nx]=='*')continue;
				if(mat[ny][nx]!='.') continue;
				nlst.add(new Item(nx,ny));
				mat[ny][nx]='*';
			}
		}
		lst=nlst;
	}
	
	static void run() {
		Deque<Gos> que = new ArrayDeque<>();
		que.add(new Gos(sx,sy,0));
		visited[sy][sx]=true;
		int cx,cy,n;
		int pn=0;
		while(!que.isEmpty()) {
			Gos cur=que.pollFirst();
			if(pn!=cur.n) { //시간 지나면 물이동
				moveWater();
				pn=cur.n;
				/*for(int y=0; y<h; y++) {
					System.out.println(Arrays.toString(mat[y]));
				}System.out.println();*/
			}
			cx=cur.x; cy=cur.y;
			if(mat[cy][cx]=='*') continue;
			for(int dr=0; dr<4; dr++) {
				int nx=cx+dirs[dr][0];
				int ny=cy+dirs[dr][1];
				if(nx<0 || ny<0 || nx>=w || ny>=h || visited[ny][nx]) continue;
				if(mat[ny][nx]=='*' || mat[ny][nx]=='X') continue;
				if(mat[ny][nx]=='D') { //두더지 집이면
					answer=cur.n+1;
					return;
				}
				visited[ny][nx]=true;
				que.add(new Gos(nx,ny,cur.n+1));
			}
		}
	}
	
	static int w,h,sx,sy;
	static char[][]mat;
	static boolean[][] visited;
	static int answer;
	static List<Item> lst;
	static int[][]dirs= {{1,0},{0,1},{-1,0},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn = new StringTokenizer(br.readLine());
		h=Integer.parseInt(stn.nextToken());
		w=Integer.parseInt(stn.nextToken());
		mat=new char[h][w];
		lst=new ArrayList<>();
		for(int y=0; y<h; y++) {
			String row=br.readLine();
			for(int x=0; x<w; x++) {
				if(row.charAt(x)=='S') {
					sx=x; sy=y;
					mat[y][x]='.';
					continue;
				}else if(row.charAt(x)=='*') {
					lst.add(new Item(x,y));
				}
				mat[y][x]=row.charAt(x);
			}
		}
		
		visited= new boolean[h][w];
		answer=0;
		
		run();
		if(answer==0)
			System.out.println("KAKTUS");
		else
			System.out.println(answer);
	}
	
	static class Item{ //물의 정보
		int x,y;
		Item(int x, int y){
			this.x=x;
			this.y=y;
		}
		@Override
		public String toString() {
			return "[x=" + x + ", y=" + y + "]";
		}
	}
	static class Gos{ //고슴도치 정보
		int x,y,n;
		Gos(int x, int y,int n){
			this.x=x;
			this.y=y;
			this.n=n;
		}
		
	}
}
