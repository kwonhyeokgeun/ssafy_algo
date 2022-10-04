package ea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class EA1004_벽돌깨기 {
	
	static void print(int[][]mat) {
		for(int y=0; y<H; y++) {
			System.out.println(Arrays.toString(mat[y]));
		}System.out.println();
	}
	
	static void rec(int[][] mat, int idx) {
		if(idx==N) {
			int cnt=0;
			for(int x=0; x<W; x++) {
				for(int y=H-1; y>=0; y--) {
					if(mat[y][x]==0) {
						break;
					}else {
						cnt++;
					}
				}
			}

			answer=Math.min(answer, cnt);
			return;
		}
		
		for(int x=0; x<W; x++) {
			int[][] nmat=bomb(mat,x);
			if(nmat==null) continue;
			//print(nmat);
			join(nmat);
			//print(nmat);
			//System.out.println("==================");
			rec(nmat,idx+1);
			
		}
	}
	
	static void join(int[][] mat){  //밑으로 내려주기
		for(int x=0; x<W; x++) {
			for(int y=H-2; y>=0; y--) {
				if(mat[y][x]!=0 && mat[y+1][x]==0) {
					int y3=y+1;
					for(int y2= y+1; y2<H; y2++) {
						if(mat[y2][x]!=0) {
							break;
						}else {
							y3=y2;
						}
					}
					mat[y3][x]=mat[y][x];
					mat[y][x]=0;
				}
			}
			
		}

	}
	
	static int[][] bomb(int[][] mat, int bx) {  //연쇄로 폭탄 터트리기
		Deque<Point> que = new ArrayDeque<>();
		for(int y=0; y<H; y++) {
			if(mat[y][bx]!=0) {
				que.add(new Point(bx,y,mat[y][bx]));
				break;
			}
		}
		if(que.isEmpty())
			return null;
		
		int[][] nmat=new int[H][];
		for(int y=0; y<H;y++) {
			nmat[y]=mat[y].clone();
		}
		
		while(!que.isEmpty()) {
			Point cur=que.pollFirst();
			int cx=cur.x, cy=cur.y, cn=cur.n;
			nmat[cy][cx]=0;
			for(int dr=0; dr<4; dr++) {
				for(int i=1; i<cn;i++) {
					int nx=cx+dirs[dr][0]*i;
					int ny=cy+dirs[dr][1]*i;
					if(nx<0 || ny<0 || nx>=W || ny>=H) break;
					if(nmat[ny][nx]==0) continue;
					que.add(new Point(nx,ny,nmat[ny][nx]));
					
				}
			}
		}
		
		
		
		
		return nmat;
		
	}
	
	static int N,W,H, answer;
	static int[][] mat;
	static int[][] dirs= {{1,0},{0,1},{-1,0},{0,-1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T= Integer.parseInt(br.readLine());
		StringTokenizer stn;
		
		for(int tc=1; tc<=T; tc++) {
			stn=new StringTokenizer(br.readLine());
			N=Integer.parseInt(stn.nextToken());
			W=Integer.parseInt(stn.nextToken());
			H=Integer.parseInt(stn.nextToken());
			mat=new int[H][W];
			for(int y=0; y<H; y++) {
				stn=new StringTokenizer(br.readLine());
				for(int x=0; x<W; x++) {
					mat[y][x]=Integer.parseInt(stn.nextToken());
				}
			}
			
			answer=999999;
			
			rec(mat,0);
			if(answer==999999)
				answer=0;
			System.out.printf("#%d %d\n", tc, answer);
		}
	}
	
	static class Point{
		int x,y,n;
		Point(int x, int y, int n){
			this.x=x;
			this.y=y;
			this.n=n;
		}
	}

}


/*
1
3 10 10
0 0 0 0 0 0 0 0 0 0
1 0 0 0 1 0 0 0 0 0
1 0 3 0 1 1 0 0 0 1
1 1 1 0 1 2 0 0 0 9
1 1 4 0 1 1 0 0 1 1
1 1 4 1 1 1 2 1 1 1
1 1 5 1 1 1 1 2 1 1
1 1 6 1 1 1 1 1 2 1
1 1 1 1 1 1 1 1 1 5
1 1 7 1 1 1 1 1 1 1
*/
