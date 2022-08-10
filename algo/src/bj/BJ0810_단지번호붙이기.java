package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class BJ0810_단지번호붙이기 {
	
	static void go(int x, int y) {
		int cnt=1;
		visited[y][x]=true;
		Deque<int[]> que = new ArrayDeque<>();
		que.add(new int[]{x,y});
		int cx,cy,nx,ny;
		while(!que.isEmpty()) {
			int []xy=que.pollLast();
			cx=xy[0]; cy=xy[1];
			for(int dr =0; dr<4; dr++) {
				nx=cx+dirs[dr][0];
				ny=cy+dirs[dr][1];
				if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
				if (visited[ny][nx] || mat[ny][nx]==0) continue;
				visited[ny][nx]=true;
				cnt++;
				que.add(new int[] {nx,ny});
			}
		}
		
		answerlst.add(cnt);
		
	}

	static int N;
	static int[][] mat;
	static int[][] dirs= {{1,0},{0,1},{-1,0},{0,-1}};
	static boolean[][] visited;
	static List<Integer> answerlst=new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		mat=new int[N][N];
		visited = new boolean[N][N];
		for(int y=0; y<N; y++) {
			String row=br.readLine();
			for(int x=0; x<N; x++) {
				mat[y][x]=row.charAt(x)-'0';
			}
		}
		int answer=0;
		for(int y=0; y<N; y++) {	
			for(int x=0; x<N; x++) {
				if(mat[y][x]==0||visited[y][x]) continue;
				answer++;
				go(x,y);
			}
		}
		Collections.sort(answerlst);
		System.out.println(answer);
		for(int ans : answerlst) {
			System.out.println(ans);
		}

	}

}
