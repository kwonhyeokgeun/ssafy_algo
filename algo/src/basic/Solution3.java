package basic;

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

public class Solution3 {
	
	static void init(int x, int y) {
		Deque<Point> que= new ArrayDeque<>();
		que.add(new Point(x,y));
		
		connected[mat[y][x]]=true;
		while(!que.isEmpty()) {
			Point cur=que.pollFirst();
			connectNum++;
			for(int dr=0; dr<4; dr++) {
				int nx=cur.x+dirs[dr][0];
				int ny=cur.y+dirs[dr][1];
				if(ny<0 || nx<0 || ny>=N || nx>=N) continue;
				int n=mat[ny][nx];
				if(n==0 || connected[n])continue;
				connected[n]=true;
				que.add(new Point(nx,ny));
			}
		}
	}

	
	static void rec(int[][] mat, int connectNum, int lineSum) {
		
		boolean canCon=false;
		for(int i=1; i<coreNum; i++) {
			if(connected[i]) continue;
			int[][] nmat=new int[N][];
			for(int y=0; y<N; y++) {
				nmat[y]=mat[y].clone();
			}
			int cx=coreXY.get(i).x,cy=coreXY.get(i).y;
			while(true) {
				
			}
		}
	}
	
	static int N, answer, coreNum, connectNum;
	static int[][] mat;
	static int[][] dirs= {{1,0},{0,1},{-1,0},{0,-1}};
	static List<Point> coreXY;
	static boolean[] connected;
	static StringBuffer sb = new StringBuffer();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn;
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=1;tc++) {
			N=Integer.parseInt(br.readLine());
			mat=new int[N][N];
			coreNum=0;
			coreXY=new ArrayList<>();
			coreXY.add(new Point(-1,-1));
			for(int y=0; y<N; y++) {
				stn=new StringTokenizer(br.readLine());
				for(int x=0; x<N; x++) {
					int n=Integer.parseInt(stn.nextToken());
					if(n==1) {
						coreNum++;
						mat[y][x]=coreNum;
						coreXY.add(new Point(x,y));
					}
				}
			}
			connectNum=0;
			connected=new boolean[coreNum+1];
			for(int x=0; x<N; x++) {
				if(mat[0][x]!=0) {
					if(connected[mat[0][x]]) continue;
					init(x,0);
				}
				if(mat[N-1][x]!=0) {
					if(connected[mat[N-1][x]]) continue;
					init(x,N-1);
				}
			}
			
			for(int y=1; y<N-1; y++) {
				if(mat[y][0]!=0) {
					if(connected[mat[y][0]]) continue;
					init(0,y);
				}
				if(mat[y][N-1]!=0) {
					if(connected[mat[y][N-1]]) continue;
					init(N-1,y);
				}
			}
			
			
		}
		System.out.println(sb);
	}
	
	
	
	
	
	
}

