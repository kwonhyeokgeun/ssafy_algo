package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ0819_알파벳 {
	
	static void rec(int cx, int cy, int cnt) { //현재 좌표, 지나온 칸 갯수
		answer=Math.max(answer,cnt);
		for(int dr=0; dr<4; dr++) {
			int nx=cx+dirs[dr][0];
			int ny=cy+dirs[dr][1];
			if(nx<0 || ny<0 || nx>=w ||ny>=h) continue;
			if (visited[mat[ny][nx]-'A']) continue;
			visited[mat[ny][nx]-'A']=true;
			rec(nx,ny,cnt+1);
			visited[mat[ny][nx]-'A']=false;
		}
	}
	
	
	static int h,w;
	static int[][] mat;
	static int answer;
	static int [][] dirs= {{1,0},{0,1},{-1,0},{0,-1}};
	static boolean[] visited; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn=new StringTokenizer(br.readLine());
		h=Integer.parseInt(stn.nextToken());
		w=Integer.parseInt(stn.nextToken());
		mat=new int[h][w];
		answer=0;
		visited=new boolean[30]; //해당 알파벳 방문 여부
		for(int y=0; y<h; y++) {
			String row=br.readLine();
			for(int x=0; x<w; x++) {
				mat[y][x]=row.charAt(x);
			}
		}
		
		visited[mat[0][0]-'A']=true;
		rec(0,0,1);
		System.out.println(answer);
	}
	
	

}
