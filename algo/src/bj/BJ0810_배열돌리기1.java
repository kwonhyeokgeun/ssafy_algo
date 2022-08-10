package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BJ0810_배열돌리기1 {
	
	static void change(int cycle) {
		Deque<int[]> que = new ArrayDeque<>();
		int lim=(H-cycle*2)*(W-cycle*2)-(H-(cycle+1)*2)*(W-(cycle+1)*2);
		que.add(new int[] {cycle,cycle,1});
		int dr=0;
		int cx,cy,nx,ny,n;
		Deque<Integer> put= new ArrayDeque<>();
		boolean[][] visited2=new boolean[H][W];
		for(int y=0; y<H; y++) { //탐색용 visited2
			for(int x=0; x<W; x++) {
				visited2[y][x]=visited[y][x];
			}
		}
		
		
		visited2[cycle][cycle]=true;
		while(!que.isEmpty()) {  //탐색해서 put에 넣기
			int []xy=que.pollLast();
			cx=xy[0];
			cy=xy[1];
			n=xy[2];
			put.add(mat[cy][cx]);
			if (n==lim) {
				break;
			}
			for(int __=0; __<4; __++) {
				nx=cx+dirs[dr][0];
				ny=cy+dirs[dr][1];
				if(nx<0 || ny<0 || nx>=W || ny>=H) {
					dr=(dr+1)%4;
					continue;
				}
				if(visited2[ny][nx]) {
					dr=(dr+1)%4;
					continue;
				}
				visited2[ny][nx]=true;
				que.add(new int[] {nx,ny,n+1});
				break;
			}
		}
		
		
		
		for(int __=0; __<N%lim; __++) { //put cycle돌리기
			int a=put.pollFirst();
			put.add(a);	
		}
		
		que.clear();
		dr=0;
		que.add(new int[] {cycle,cycle,0});
		visited[cycle][cycle]=true;
		while(!que.isEmpty()) {  //다시 탐색하며 put값 넣기
			int []xy=que.pollLast();
			cx=xy[0];
			cy=xy[1];
			n=xy[2];
			//System.out.println(cx+" "+cy);
			mat[cy][cx]=put.pollFirst();
			if (n==lim-1) {
				break;
			}
			for(int __=0; __<4; __++) {
				nx=cx+dirs[dr][0];
				ny=cy+dirs[dr][1];
				if(nx<0 || ny<0 || nx>=W || ny>=H) {
					dr=(dr+1)%4;
					continue;
				}
				if(visited[ny][nx]) {
					dr=(dr+1)%4;
					continue;
				}
				visited[ny][nx]=true;
				que.add(new int[] {nx,ny,n+1});
				break;
			}
		}
	}
	
	

	static int W,H,N;
	static int[][]mat;
	static boolean[][] visited;
	static int[][] dirs= {{1,0},{0,1},{-1,0},{0,-1}};
	static int[][] dirs2= {{0,-1},{-1,0},{0,1},{1,0}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn=new StringTokenizer(br.readLine());
		H=Integer.parseInt(stn.nextToken());
		W=Integer.parseInt(stn.nextToken());
		N=Integer.parseInt(stn.nextToken());
		
		mat=new int[H][W];
		visited=new boolean[H][W];
		for(int y=0; y<H;y++) {
			stn=new StringTokenizer(br.readLine());
			for(int x=0; x<W; x++) {
				mat[y][x]=Integer.parseInt(stn.nextToken());
			}
		}
		for(int i=0; i<Math.min(H,W)/2;i++) {
			change(i);
		}
		
		for(int y=0; y<H;y++) {
			for(int x=0; x<W; x++) {
				System.out.print(mat[y][x]+" ");
			}System.out.println();
		}
	}

}
