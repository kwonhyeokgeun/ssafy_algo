package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ0810_배열돌리기3 {
	static int[][] op1(){ //상하반전
		int [][] ret = new int[h][w];
		
		for(int y=0; y<h; y++) {
			for(int x=0; x<w; x++) {
				ret[y][x]=mat[h-y-1][x];
			}
		}
				
		return ret;
	}
	static int[][] op2(){ //좌우반전
		int [][] ret = new int[h][w];
		
		for(int y=0; y<h; y++) {
			for(int x=0; x<w; x++) {
				ret[y][x]=mat[y][w-x-1];
			}
		}
				
		return ret;
	}
	
	static int[][] op3(){ //90도 오른쪽
		int t=h;
		h=w;
		w=t;
		int [][] ret = new int[h][w];
		
		for(int y=0; y<h; y++) {
			for(int x=0; x<w; x++) {
				ret[y][x]=mat[w-x-1][y];
			}
		}
				
		return ret;
	}
	
	static int[][] op4(){ //90도 외쪽
		int t=h;
		h=w;
		w=t;
		int [][] ret = new int[h][w];
		
		for(int y=0; y<h; y++) {
			for(int x=0; x<w; x++) {
				ret[y][x]=mat[x][h-y-1];
			}
		}
				
		return ret;
	}
	
	static int[][] op5(){//4구역 시계방향
		int[][] xys= {{0,0},{w/2,0},{w/2,h/2},{0,h/2}};
		int[][] ret=new int[h][w];
		int sx,sy,ex,ey;
		for(int a=0; a<4; a++) {
			sx=xys[a][0];
			sy=xys[a][1];
			ex=xys[(a+1)%4][0];
			ey=xys[(a+1)%4][1];
			
			for(int y=0; y<h/2; y++) {
				for(int x=0; x<w/2;x++) {
					ret[ey+y][ex+x]=mat[sy+y][sx+x];
				}
			}
		}
		
		
		return ret;
	}
	static int[][] op6(){//4구역 반시계방향
		int[][] xys= {{0,h/2},{w/2,h/2},{w/2,0},{0,0}};
		int[][] ret=new int[h][w];
		int sx,sy,ex,ey;
		for(int a=0; a<4; a++) {
			sx=xys[a][0];
			sy=xys[a][1];
			ex=xys[(a+1)%4][0];
			ey=xys[(a+1)%4][1];
			
			for(int y=0; y<h/2; y++) {
				for(int x=0; x<w/2;x++) {
					ret[ey+y][ex+x]=mat[sy+y][sx+x];
				}
			}
		}
		
		return ret;
	}

	static int h,w,N;
	static int[][] mat;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn=new StringTokenizer(br.readLine());
		h=Integer.parseInt(stn.nextToken());
		w=Integer.parseInt(stn.nextToken());
		N=Integer.parseInt(stn.nextToken());
		mat = new int[h][w];
		visited= new boolean[h][w];
		for(int y=0; y<h; y++) {
			stn=new StringTokenizer(br.readLine());
			for(int x=0; x<w; x++) {
				mat[y][x]=Integer.parseInt(stn.nextToken());
			}
		}
		stn=new StringTokenizer(br.readLine());
		int op;
		for(int i=0; i<N; i++) {
			op=Integer.parseInt(stn.nextToken());
			switch(op) {
			case(1):mat=op1();break;
			case(2):mat=op2();break;
			case(3):mat=op3();break;
			case(4):mat=op4();break;
			case(5):mat=op5();break;
			case(6):mat=op6();break;
			}
		}
		for(int y=0; y<h; y++) {
			for(int x=0; x<w; x++) {
				System.out.print(mat[y][x]+" ");
			}System.out.println();
		}
		

	}

}
