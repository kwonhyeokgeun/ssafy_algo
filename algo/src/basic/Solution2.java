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

public class Solution2 {

	
	static void rec(boolean[][] lines, int connectNum, int lineSum, int idx) {
		//if(connectNum<=maxConnectNum && lineSum>=answer) return;
		
		boolean canCon=false;
		for(int i=1; i<=coreNum; i++) {
			if(connected[i]) continue;
			
			for(int dr=0; dr<4; dr++) {
				boolean[][] nlines=new boolean[N][];
				for(int y=0; y<N; y++) {
					nlines[y]=lines[y].clone();
				}
				int nlineSum=lineSum;
				int cx=coreXY.get(i).x,cy=coreXY.get(i).y;
				boolean cango=true;
				while(true) {
					int nx=cx+dirs[dr][0];
					int ny=cy+dirs[dr][1];
					if(nx<0 || ny<0 || nx>=N|| ny>=N) break;
					if(nlines[ny][nx]) {
						cango=false;
						break;
					}
					
					if(mat[ny][nx]>0) {
						cango=false;
						break;
					}
					
					nlines[ny][nx]=true;
					nlineSum++;
					cx=nx; cy=ny;
					
				}
				
				if(cango) {
					if(connectNum+1==coreNum) {
						//System.out.println(nlineSum);
						if(maxConnectNum<connectNum+1) {
							maxConnectNum=connectNum+1;
							answer=nlineSum;
						}else if(maxConnectNum==connectNum+1) {
							answer=Math.min(answer, nlineSum);
						}
						return;
					}
					else {
						if(maxConnectNum<connectNum+1) {
							maxConnectNum=connectNum+1;
							answer=nlineSum;
						}else if(maxConnectNum==connectNum+1) {
							answer=Math.min(answer, nlineSum);
						}
							
						connected[i]=true;
						rec(nlines,connectNum+1,nlineSum,i+1);
						connected[i]=false;
					}
				}
			}
		}
		
	}
	
	static int N, answer, coreNum, connectNum, maxConnectNum;
	static int[][] mat;
	static int[][] dirs= {{1,0},{0,1},{-1,0},{0,-1}};
	static List<Point> coreXY;
	static boolean[] connected;
	static StringBuffer sb = new StringBuffer();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn;
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T;tc++) {
			stn=new StringTokenizer(br.readLine());
			N=Integer.parseInt(stn.nextToken());
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
					connectNum++;
					connected[mat[0][x]]=true;
				}
				if(mat[N-1][x]!=0) {
					connectNum++;
					connected[mat[N-1][x]]=true;
				}
			}
			
			for(int y=1; y<N-1; y++) {
				if(mat[y][0]!=0) {
					connectNum++;
					connected[mat[y][0]]=true;
				}
				if(mat[y][N-1]!=0) {
					connectNum++;
					connected[mat[y][N-1]]=true;
				}
			}
			
			if(connectNum==coreNum) {
				sb.append("#"+tc+" ").append(0);
				continue;
			}
			answer=Integer.MAX_VALUE;
			maxConnectNum=connectNum;
			boolean[][] lines=new boolean[N][N];
			int idx=0;
			for(int i=1; i<=N;i++) {
				if(!connected[i]) idx=i;
			}
			rec(lines,connectNum, 0,idx);
			sb.append("#"+tc+" ").append(answer);
			System.out.println(tc);
			
		}
		System.out.println(sb);
	}
	
	
	
	
	
	
}

