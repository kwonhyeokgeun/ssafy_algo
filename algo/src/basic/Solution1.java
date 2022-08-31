package basic;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution1 {

	
	static StringBuffer sb = new StringBuffer();
	static int N, answer;
	static Set<Integer>[][] dists;
	static House[] houses;
	static int [][]dirs= {{1,0},{0,1},{-1,0},{0,-1}};
	static boolean [][]mat;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn;
		int T=Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			stn=new StringTokenizer(br.readLine());
			N=Integer.parseInt(stn.nextToken());
			
			mat=new boolean[31][31];
			houses=new House[N+1];
			
			for(int i=1; i<=N; i++) {
				stn=new StringTokenizer(br.readLine());
				int x=Integer.parseInt(stn.nextToken())+15;
				int y=Integer.parseInt(stn.nextToken())+15;
				int d=Integer.parseInt(stn.nextToken());
				houses[i]=new House(x,y,d);
				mat[y][x]=true;
				/*for(int yy=0; yy<31;yy++ ) {
					System.out.println(Arrays.toString(houses[i].dists[yy]));
				}System.out.println();*/
					
				
			}
			
			answer=Integer.MAX_VALUE;
			for(int y=0; y<31; y++) {
				for(int x=0; x<31; x++) {
					if(mat[y][x]) continue;
					int sum=0;
					boolean cango=true;
					for(int i=1; i<=N; i++) {
						int d=houses[i].cango(x,y);
						if(d==0) {
							cango=false;
							break;
						}
						sum+=d;
					}
					if(cango) {
						answer=Math.min(answer, sum);
					}
				}
			}
			
			if(answer==Integer.MAX_VALUE) {
				for(int i1=0; i1<31*31-1; i1++) {
					int x1=i1%31;
					int y1=i1/31;
					if(mat[y1][x1])continue;
					for(int i2=i1+1; i2<31*31; i2++ ) {
						int x2=i2%31;
						int y2=i2/31;
						if(mat[y2][x2])continue;
						boolean cango=true;
						int sum=0;
						for(int i=1; i<=N; i++) {
							int d1=houses[i].cango(x1, y1);
							int d2=houses[i].cango(x2, y2);
							
							if(d1==0 && d2==0) {
								cango=false;
								break;
							}
							if(d1==0) {
								sum+=d2;
							}else if(d2==0) {
								sum+=d1;
							}else {
								sum+=Math.min(d1, d2);
							}
							
						}
						if(cango) {
							answer=Math.min(answer, sum);
						}
						
					}
					
				}
			}
			if(answer==Integer.MAX_VALUE) {
				answer=-1;
			}
			sb.append("#"+tc+" ").append(answer+"\n");
			
		}
		System.out.println(sb);
	}
	
	static class XY{
		int x,y,d;
		XY(int x, int y, int d){
			this.x=x;
			this.y=y;
			this.d=d;
		}
	}
	
	static class House{
		int x,y,d;
		int[][] dists=new int[31][31];
		House(int x, int y, int d) {
			this.x=x;
			this.y=y;
			this.d=d;
			
			boolean[][] visited=new boolean[31][31];
			visited[y][x]=true;
			Deque<XY> que = new ArrayDeque<>();
			que.add(new XY(x,y,0));
			while(!que.isEmpty()) {
				XY cur=que.pollFirst();
				if(cur.d>=d) break;
				for(int dr=0; dr<4; dr++) {
					int nx=cur.x+dirs[dr][0];
					int ny=cur.y+dirs[dr][1];
					if(nx<0 || ny<0 || nx>=31 || ny>=31 || visited[ny][nx]) continue;
					dists[ny][nx]=cur.d+1;
					visited[ny][nx]=true;
					que.add(new XY(nx,ny,cur.d+1));
				}
			}
			
		}
		
		int cango(int x, int y) {
			
			return dists[y][x];
		}
		
	}

}
