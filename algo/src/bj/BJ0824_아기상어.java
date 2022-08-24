package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BJ0824_아기상어 {
	
	static boolean findFish() {
		Deque<XY> que = new ArrayDeque<>();
		boolean[][] visited=new boolean[N][N];
		que.add(new XY(sx,sy,0));
		visited[sy][sx]=true;
		int dist=50000;
		int miny=22;  //먹을 물고기 좌표
		int minx=22;
		while(!que.isEmpty()) {
			XY cur= que.pollFirst();
			if(cur.d>=dist)break;
			for(int dr=0; dr<4; dr++) {
				int nx=cur.x+dirs[dr][0];
				int ny=cur.y+dirs[dr][1];
				if(nx<0 || ny<0 || nx>=N|| ny>=N) continue;
				if(visited[ny][nx] || mat[ny][nx]>size) continue;
				if(mat[ny][nx]<size && mat[ny][nx]!=0) { //먹을 수 있는 물고기 발견
					dist=cur.d+1; //거리 저장
					if(miny>ny) {  //가장 위의 왼쪽거
						miny=ny; minx=nx;
					}else if(miny==ny) {
						minx=Math.min(minx, nx);
					}
				}
				que.add(new XY(nx,ny,cur.d+1));
				visited[ny][nx]=true;
			}
		}

		if(miny==22) { //먹을수 있는게 없음
			return false;
		}
		
		mat[miny][minx]=0;
		eat++;
		sx=minx; //상어 좌표 최신화
		sy=miny;
		if(eat==size) { //먹은 갯수가 크기와 같으면 크기+1
			eat=0;
			size++;
		}
		answer+=dist;
		
		return true;
	}

	static int N, sx,sy,size, eat, answer;
	static int mat[][];
	static int[][]dirs= {{1,0},{0,1},{-1,0},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		StringTokenizer stn;
		mat=new int[N][N];
		
		for(int y=0; y<N; y++) {
			stn = new StringTokenizer(br.readLine());
			for(int x=0;x<N; x++) {
				int f=Integer.parseInt(stn.nextToken());
				if(f==0) {
					continue;
				}
				else if(f==9) {
					sx=x; sy=y;
				}else {
					mat[y][x]=f;
				}
			}
		}
		
		size=2;
		eat=0;
		answer=0;
		while(true) {
			if(!findFish())break;  //먹을 수 있는 물고기 없으면 중지, 있으면 먹음
			
		}
		System.out.println(answer);
		
	}
	
	static class XY{
		int x,y,d;
		XY(int x, int y, int d){
			this.x=x;
			this.y=y;
			this.d=d;
		}
	}

}
