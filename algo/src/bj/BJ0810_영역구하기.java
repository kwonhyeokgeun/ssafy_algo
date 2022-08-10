package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class BJ0810_영역구하기 {
	
	static void go(int x, int y) {
		visited[y][x]=true;
		Deque<int[]> que = new ArrayDeque<>();
		que.add(new int[]{x,y});
		int cx,cy,nx,ny;
		int cnt=1;
		while(!que.isEmpty()) {
			int []xy=que.pollLast();
			cx=xy[0]; cy=xy[1];
			for(int dr =0; dr<4; dr++) {
				nx=cx+dirs[dr][0];
				ny=cy+dirs[dr][1];
				if(nx<0 || ny<0 || nx>=W || ny>=H) continue;
				if (visited[ny][nx] || mat[ny][nx]==1) continue;
				visited[ny][nx]=true;
				cnt++;
				que.add(new int[] {nx,ny});
			}
		}
		answerlst.add(cnt);
		
		
	}

	public static int H,W,N;
	public static int[][]mat;
	public static boolean[][] visited;
	static List<Integer> answerlst=new ArrayList<>();
	static int[][] dirs= {{1,0},{0,1},{-1,0},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn;
		stn=new StringTokenizer(br.readLine());
		H=Integer.parseInt(stn.nextToken());
		W=Integer.parseInt(stn.nextToken());
		N=Integer.parseInt(stn.nextToken());
		mat=new int[H][W];
		int x1,y1,x2,y2;
		for(int __=0; __<N; __++) {
			stn=new StringTokenizer(br.readLine());
			x1=Integer.parseInt(stn.nextToken());
			y1=Integer.parseInt(stn.nextToken());
			x2=Integer.parseInt(stn.nextToken());
			y2=Integer.parseInt(stn.nextToken());
			
			for(int x=x1; x<x2; x++) {
				for(int y=y1; y<y2; y++) {
					mat[y][x]=1;
				}
			}
			
		}
		
		
		int answer=0;
		visited= new boolean[H][W];
		for(int y=0; y<H; y++){
			for(int x=0; x<W; x++) {
				if (mat[y][x]==1 || visited[y][x]) continue;
				go(x,y);
				answer++;
			}
		}
		Collections.sort(answerlst);
		System.out.println(answer);
		for(int ans : answerlst) {
			System.out.print(ans+" ");
		}
	}

}
