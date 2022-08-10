package basic;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Deque;

public class DFS_BFS {
	
	
	static void bfs(int x, int y) {
		visited=new boolean[7][7];
		count=0;
		
		Queue<Node> que = new ArrayDeque<>();
		que.add(new Node(x,y));
		visited[y][x]=true;
		count++;
		
		int cx,cy,nx,ny;
		while(!que.isEmpty()) {
			Node cn = que.poll();
			System.out.println(cn);
			cx=cn.x; cy=cn.y;
			for(int dr=0; dr<4; dr++) {
				nx=cx+dirs[dr][0];
				ny=cy+dirs[dr][1];
				if(nx<0 || ny<0 || nx>=7 || ny>=7) continue;
				if(visited[ny][nx] || mat[ny][nx]==0) continue; //0은 안가게
				visited[ny][nx]=true;
				count++;
				que.add(new Node(nx,ny));
			}
		}
		System.out.println(count);
	}
	
	
	static void dfs(int x, int y) {
		visited=new boolean[7][7];
		count=0;
		
		Deque<Node> que = new ArrayDeque<>();
		que.add(new Node(x,y));
		visited[y][x]=true;
		count++;
		
		int cx,cy,nx,ny;
		while(!que.isEmpty()) {
			Node cn = que.pollLast();
			System.out.println(cn);
			cx=cn.x; cy=cn.y;
			for(int dr=0; dr<4; dr++) {
				nx=cx+dirs[dr][0];
				ny=cy+dirs[dr][1];
				if(nx<0 || ny<0 || nx>=7 || ny>=7) continue;
				if(visited[ny][nx] || mat[ny][nx]==0) continue; //0은 안가게
				visited[ny][nx]=true;
				count++;
				que.add(new Node(nx,ny));
			}
		}
		System.out.println(count);
		
	}
	

	public static int[][] mat={
	  	{0,  0,  0,  0,  0,  0,  0},
        {0, 11, 12, 13, 14, 15, 16},
        {0, 21, 22, 23, 24, 25, 26},
        {0, 31, 32, 33, 34, 35, 36},
        {0, 41, 42, 43, 44, 45, 46},
        {0, 51, 52, 53, 54, 55, 56},
        {0, 61, 62, 63, 64, 65, 66},
	};
	
	static int[][] dirs= {{1,0},{0,1},{-1,0},{0,-1}};
	static boolean [][] visited;
	static int count;
	
	public static void main(String[] args) {
		//bfs(1,1);
		dfs(1,1);
		
	}
	
	static class Node{
		int x,y;
		public Node(int x, int y) {
			this.x=x;
			this.y=y;
		}
		@Override
		public String toString() {
			return "[x=" + x + ", y=" + y + "]";
		}
		
	}

}
