package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ0818_빵집2 {
	
	static boolean dfs(int y, int x) {
		int nx=x+1;
		if(nx==w-1) return true; //성공
		for(int dr=0; dr<3; dr++) {
			int ny=y+dirs[dr];
			if(ny<0 || ny>=h || mat[ny][nx]) continue;
			
			mat[ny][nx]=true;
			if( (dfs(ny,nx)) ) return true;
				
		}
		
		return false;
	}
	
	static int h,w,answer;
	static int[] dirs= {-1,0,1};
	static boolean[][] mat;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn = new StringTokenizer(br.readLine());
		h=Integer.parseInt(stn.nextToken());
		w=Integer.parseInt(stn.nextToken());
		mat =new boolean[h][w];
		answer=0;

		for(int y=0; y<h; y++) {
			String row=br.readLine();
			for(int x=0; x<w; x++) {
				if (row.charAt(x)=='x') {
					mat[y][x]=true;
				}
			}
		}
		for(int y=0; y< h; y++) {
			if(dfs(y,0))answer++;
		}
		
		System.out.println(answer);
	}
	
}
