package bj;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class BJ1005_치즈 {
	
	static void rec(List<Point> xys, int d) {
		List<Point> nxys = new ArrayList<>();
		for(Point cur : xys) {  //이전의 구멍들 녹이기
			int cx=cur.x, cy=cur.y;
			visited[cy][cx]=false;
			mat[cy][cx]=0;
		}
		
		for(Point st:xys) {
			int sx=st.x;
			int sy=st.y;
			if(visited[sy][sx]) {
				continue;
			}
			Deque<Point> que=new ArrayDeque<>();
			que.add(new Point(sx,sy));
			visited[sy][sx]=true;
			while(!que.isEmpty()) {
				Point cur=que.pollFirst();
				int cx=cur.x,cy=cur.y;
				for(int dr=0; dr<4; dr++) {
					int nx=cx+dirs[dr][0];
					int ny=cy+dirs[dr][1];
					if(nx<0 || ny<0 || nx>=W || ny>=H || visited[ny][nx])continue;
					if(mat[ny][nx]==0) {
						visited[ny][nx]=true;
						que.add(new Point(nx,ny));
					}else {
						visited[ny][nx]=true;
						nxys.add(new Point(nx,ny));
					}
				}
			}
		}
		
		if(nxys.size()==0) { //다녹았으면
			System.out.println(d);
			System.out.println(xys.size());
			return;
		}else {  //다 안녹았으면
			rec(nxys, d+1);
		}
	}

	
	static List<Point> init() {
		List<Point> xys=new ArrayList<>();
		visited = new boolean[H][W];
		
		
		Deque<Point> que=new ArrayDeque<>();
		que.add(new Point(0,0));
		visited[0][0]=true;
		while (!que.isEmpty()) {
			Point cur=que.pollFirst();
			int cx=cur.x,cy=cur.y;
			for(int dr=0; dr<4; dr++) {
				int nx=cx+dirs[dr][0];
				int ny=cy+dirs[dr][1];
				if(nx<0 || ny<0 || nx>=W || ny>=H || visited[ny][nx])continue;
				if(mat[ny][nx]==0) {
					visited[ny][nx]=true;
					que.add(new Point(nx,ny));
				}else {
					visited[ny][nx]=true;
					xys.add(new Point(nx,ny));
				}
			}
			
		}
			
		
		return xys;
	}
	static int H,W;
	static int[][] mat;
	static int[][] dirs= {{1,0},{0,1},{-1,0},{0,-1}};
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn = new StringTokenizer(br.readLine());
		H=Integer.parseInt(stn.nextToken());
		W=Integer.parseInt(stn.nextToken());
		mat=new int[H][W];
		for(int y=0; y<H; y++) {
			stn = new StringTokenizer(br.readLine());
			for(int x=0; x<W; x++) {
				mat[y][x]=Integer.parseInt(stn.nextToken());
			}
		}
		
		List<Point> xys=init();
		if(xys.size()==0) {
			System.out.println(0);
			System.out.println(0);
		}else {
			rec(xys,1);
		}
	}

}
