package ea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://swexpertacademy.com/main/code/problem/problemDetail.do

public class EA0802_ladder1 {
	
	public static int find() {
		visited[cx][cy]=1;
		while(true) {
			//System.out.println(cx+" , "+cy);
			if(cx>0 && visited[cy][cx-1]==0) {  //좌
				nx=cx-1;
				ny=cy;
				if(mat[ny][nx]==1) {
					cx=nx;
					visited[ny][nx]=1;
					continue;
				}

			}
			if(cx<99 && visited[cy][cx+1]==0) {  //우
				nx=cx+1;
				ny=cy;
				if(mat[ny][nx]==1) {
					cx=nx;
					visited[ny][nx]=1;
					continue;
				}
				
			}
			if(mat[cy-1][cx]==1) { //상
				if(cy-1==0) return cx;
				visited[cy-1][cx]=1;
				cy--;
			}
		}
	}

	static public int[][] mat;
	static public int[][] visited;
	public static int cx,cy,nx,ny;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int TC=0; TC<10; TC++) {
			int tc=Integer.parseInt(br.readLine());
			mat=new int[100][100];
			visited=new int[100][100];
			StringTokenizer tk;
			for(int y=0; y<100; y++) {
				tk = new StringTokenizer(br.readLine());
				for(int x=0; x<100; x++) {
					mat[y][x]=Integer.parseInt(tk.nextToken());
				}
			}
			for(int x=0; x<100; x++) {
				if(mat[99][x]==2) {
					cx=x;
					cy=99;
					break;
				}
			}
			int answer=find();
			System.out.printf("#%d %d\n",tc,answer);
			
		}
		
	}

}
