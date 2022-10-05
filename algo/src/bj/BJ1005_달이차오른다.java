package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class BJ1005_달이차오른다 {
	
	
	static int go(int sx, int sy) {

		Deque<Node> que = new ArrayDeque<>();
		que.add(new Node(sx,sy,0,0));
		while (!que.isEmpty()) {
			Node cur=que.pollFirst();
			int cx=cur.x;
			int cy=cur.y;
			//System.out.printf("(%d, %d) %s \n",cx,cy,cur.keys);
			for(int dr=0; dr<4; dr++) {
				int nx=cx+dirs[dr][0];
				int ny=cy+dirs[dr][1];
				if(nx<0 || ny<0 || nx>=W || ny>=H || mat[ny][nx]=='#')continue;
				if(mat[ny][nx]=='1') return cur.num+1; 
				else if(mat[ny][nx]>='A' && mat[ny][nx]<='F') {
					int keys=cur.keys;
					if(visited[keys][ny][nx]) continue;
					visited[keys][ny][nx]=true;
					if((keys & 1<<(mat[ny][nx]-'A'))!=0) {//해당 키 있음
						que.add(new Node(nx,ny,cur.num+1,keys));
					}
					
				}
				else if(mat[ny][nx]>='a' && mat[ny][nx]<='f') { //키찾음
					int nkeys = cur.keys | 1<<(mat[ny][nx]-'a');
					if(visited[nkeys][ny][nx]) continue;
					visited[nkeys][ny][nx]=true;
					que.add(new Node(nx,ny,cur.num+1,nkeys));
					
				}else { //점
					int keys=cur.keys;
					if(visited[keys][ny][nx]) continue;
					visited[keys][ny][nx]=true;
					que.add(new Node(nx,ny,cur.num+1,keys));
				}
			}
		}
		
		
		return -1;
	}
	
	static boolean[][][] visited;
	static int H,W;
	static char[][] mat;
	static int[][] dirs= {{1,0},{0,1},{-1,0},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn = new StringTokenizer(br.readLine());
		H=Integer.parseInt(stn.nextToken());
		W=Integer.parseInt(stn.nextToken());
		mat=new char[H][W];
		int sx=0,sy=0;
		for(int y=0; y<H; y++) {
			String row=br.readLine();
			for(int x=0; x<W; x++) {
				char c= row.charAt(x);
				if(c=='0') {
					sx=x; sy=y;
					mat[y][x]='.';
				}
				else {
					mat[y][x]=c;
				}
			}
		}
		
		visited=new boolean[64][H][W];
		visited[0][sy][sx]=true;
		int answer=go(sx,sy);
		System.out.println(answer);
		
	}
	
	static class Node{
		int x,y, num,keys;
		Node(int x, int y, int num, int keys){
			this.x=x;
			this.y=y;
			this.num=num;
			this.keys=keys;
		}
	}

}
