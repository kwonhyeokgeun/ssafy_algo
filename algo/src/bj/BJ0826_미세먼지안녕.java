package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ0826_미세먼지안녕 {
	
	static void spread() {
		int[][] temp=new int[h][w];
		for(int y=0; y<h; y++) {
			for(int x=0; x<w; x++) {
				if(mat[y][x]<=4) {
					temp[y][x]+=mat[y][x];
					continue;
				}	
				int s=mat[y][x]/5; //퍼지는 먼지
				int cnt=0;
				if(s!=0) {
					for(int dr=0; dr<4; dr++) {
						int nx=x+dirs[dr][0];
						int ny=y+dirs[dr][1];
						if(nx<0 || ny<0 || ny>=h || nx>=w) continue;
						if(nx==0 && (ny==cleaner[0][1] ||  ny==cleaner[1][1])) continue;
						temp[ny][nx]+=s;
						cnt++;
					}
					temp[y][x]+=mat[y][x]-s*cnt;
				}else {
					temp[y][x]+=mat[y][x];
				}	
			}
		}
		mat=temp;
	}
	
	static void upCycle() {
		int sx=cleaner[0][0];
		int sy=cleaner[0][1];
		
		for(int i=sy; i>0; i--) { //좌
			mat[i][0]=mat[i-1][0];
		}
		mat[sy][sx]=0;
		for(int i=0; i<w-1; i++) { //상
			mat[0][i]=mat[0][i+1];
		}
		for(int i=0; i<=sy-1; i++) { //우
			mat[i][w-1]=mat[i+1][w-1];
		}
		for(int i=w-1; i>0; i--) {//하
			mat[sy][i]=mat[sy][i-1];
		}
	}
	static void downCycle() {
		int sx=cleaner[1][0];
		int sy=cleaner[1][1];
		for(int i=sy; i<h-1; i++){//좌
			mat[i][0]=mat[i+1][0];
		}
		mat[sy][sx]=0;
		for(int i=0; i<w-1; i++) { //하
			mat[h-1][i]=mat[h-1][i+1];
		}
		for(int i=h-1; i>sy; i--) { //우
			mat[i][w-1]=mat[i-1][w-1];
		}
		for(int i=w-1; i>0; i--) { //상
			mat[sy][i]=mat[sy][i-1];
		}
	}

	static int h,w,T;
	static int[][] mat;
	static int[][] cleaner;
	static int[][] dirs= {{1,0},{0,1},{-1,0},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn;
		stn=new StringTokenizer(br.readLine());
		h=Integer.parseInt(stn.nextToken());
		w=Integer.parseInt(stn.nextToken());
		T=Integer.parseInt(stn.nextToken());
		mat=new int[h][w];
		
		cleaner=new int[][] {{-1,-1},{-1,-1}};;
		for(int y=0; y<h; y++) {
			stn=new StringTokenizer(br.readLine());
			for(int x=0; x<w; x++) {
				int n=Integer.parseInt(stn.nextToken());
				if(n==-1) {
					if(cleaner[0][0]==-1) {
						cleaner[0][0]=x; cleaner[0][1]=y;
					}else {
						cleaner[1][0]=x; cleaner[1][1]=y;
					}
				}else {
					mat[y][x]=n;
				}
			}
		}
		
		/*for(int y=0; y<h;y++) {
			System.out.println(Arrays.toString(mat[y]));
		}System.out.println();*/
		
		for(int i=0; i<T; i++) {
			spread();
			upCycle();
			downCycle();
			/*for(int y=0; y<h;y++) {
				System.out.println(Arrays.toString(mat[y]));
			}System.out.println();*/
		}
		
		
		int answer=0;
		for(int y=0; y<h; y++) {
			for(int x=0; x<w; x++) {
				answer+=mat[y][x];
			}
		}
		System.out.println(answer);
	}

}

