package bj;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1007_다리만들기2 {
	
	static void init() { //구역 나누고 번호 부여하기
		boolean[][] visited = new boolean[H][W];
		s=0;
		for(int y=0; y<H; y++) {
			for(int x=0; x<W; x++) {
				if(mat[y][x]==0  || visited[y][x]) continue;
				visited[y][x]=true;
				Deque<Point> que = new ArrayDeque<>();
				s++;
				que.add(new Point(x,y));
				while(!que.isEmpty()) {
					Point cur=que.pollFirst();
					int cx=cur.x, cy=cur.y;
					mat[cy][cx]=s;
					for(int dr=0; dr<4; dr++) {
						int nx=cx+dirs[dr][0];
						int ny=cy+dirs[dr][1];
						if(nx<0 ||ny<0 || nx>=W || ny>=H || mat[ny][nx]==0 || visited[ny][nx]) continue;
						visited[ny][nx]=true;
						que.add(new Point(nx,ny));
					}
				}
			}
		}
		/*for(int i =0; i<H;i++) {
			System.out.println(Arrays.toString(mat[i]));
		}System.out.println();*/
	}
	
	static void makeBridge() {  //구역별로 다리 만들어서 graph에 넣기
		for(int y=0; y<H; y++) {
			for(int x=0; x<W; x++) {
				if(mat[y][x]!=0) {
					int s1=mat[y][x];
					for(int dr=0; dr<2; dr++) {
						int nx=x+dirs[dr][0];
						int ny=y+dirs[dr][1];
						if(nx<0 || ny<0 || nx>=W || ny>=H || mat[ny][nx]!=0) continue;
						while(true) {
							nx=nx+dirs[dr][0];
							ny=ny+dirs[dr][1];
							if(nx<0 || ny<0 || nx>=W || ny>=H || mat[ny][nx]==s1) break;
							if(mat[ny][nx]!=0) {
								int l =Math.abs(x-nx)+Math.abs(y-ny)-1;
								if(l<2) break;
								int s2=mat[ny][nx];
								if(graph[s1][s2]==0) {
									graph[s1][s2]=l;
									graph[s2][s1]=l;
								}else {
									graph[s1][s2]=Math.min(graph[s1][s2], l);
									graph[s2][s1]=Math.min(graph[s2][s1], l);
								}
								
								break;
							}
							
						}
					}
				}
			}
		}
		
		/*for(int i =1; i<=s;i++) {
			System.out.println(Arrays.toString(graph[i]));
		}System.out.println();*/
	}
	
	static int find(int n) {
		if(n==root[n]) return n;
		return root[n]=find(root[n]);
		
		
	}
	
	static void union(int n1, int n2) {
		int r1=find(n1);
		int r2=find(n2);
		if(r1<r2) {
			root[r2]=find(r1);
		}else {
			root[r1]=find(r2);
		}
	}
	
	static void MST() { //최소 스패닝트리 구하기
		root=new int[s+1];
		for(int i=0; i<=s; i++) {
			root[i]=i;
		}
		
		PriorityQueue<Edge> hp = new PriorityQueue<>( (o1,o2)->o1.w-o2.w);
		for(int n1=1; n1<s; n1++) {
			for(int n2=n1+1; n2<=s;n2++) {
				if(graph[n1][n2]!=0)
					hp.add(new Edge(graph[n1][n2],n1,n2));
			}
		}
		
		answer=0;
		while(!hp.isEmpty()) {
			Edge cur=hp.poll();
			int n1=cur.n1, n2=cur.n2;
			if(find(n1)==find(n2)) continue;
			union(n1,n2);
			answer+=cur.w;
			
		}
		
		
	}
	
	static int H,W,s,answer;
	static int[][] mat;
	static int[][] dirs= {{1,0},{0,1},{-1,0},{0,-1}};
	static int[][] graph;
	static int[] root;
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
		
		init();
		graph=new int[s+1][s+1];
		makeBridge();
		MST();
		
		for(int i=1; i<=s; i++) {
			if(find(i)!=find(1)) {
				answer=-1;
				break;
			}
		}
		System.out.println(answer);
		
	}
	static class Edge{
		int w,n1,n2;
		Edge(int w, int n1, int n2){
			this.w=w;
			this.n1=n1;
			this.n2=n2;
		}
	}

}
