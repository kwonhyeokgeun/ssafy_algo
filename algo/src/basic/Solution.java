package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static void init() {
		for(int n=0; n<h*w; n++) {
			if(n%w==0) {
				for(int dr=0; dr<4; dr++) {
					int nn=n+dirs[dr];
					if(nn>=h*w || nn<0) continue;
					cells[n].link[dr]=nn;
				}
			}else if(n%w==w-1) {
				for(int dr=0; dr<6; dr++) {
					if(dr==1|| dr==2) continue;
					int nn=n+dirs[dr];
					if(nn>=h*w || nn<0) continue;
					cells[n].link[dr]=nn;
				}
			}else {
				for(int dr=0; dr<6; dr++) {
					int nn=n+dirs[dr];
					if(nn>=h*w || nn<0) continue;
					cells[n].link[dr]=nn;
				}
			}
		}
	}
	
	static void find() {
		for(int n=0; n<h*w; n++) {
			
		}
	}

	static long answer;
	static int h,w;
	static Cell[] cells;
	static StringBuffer sb = new StringBuffer();
	static int[] dirs;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn;
		int T=Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			stn=new StringTokenizer(br.readLine());
			w=Integer.parseInt(stn.nextToken());
			h=Integer.parseInt(stn.nextToken());
			for(int y=0; y<h; y++) {
				stn=new StringTokenizer(br.readLine());
				for(int x=0; x<w; x++) {
					int n=y*w+x;
					cells[n]=new Cell(n,Integer.parseInt(stn.nextToken()));
				}
			}
			
			dirs=new int[] {-w, +1, w+1, w, w-1, -1};
			
			
		}
	}
	
	
	static class Cell{
		int num, user;
		public int[] link=new int[] {-1,-1,-1,-1,-1,-1};
		
		public Cell(int num,int user) {
			this.num=num;
			this.user=user;
		}
		void set(int i, int n) {
			link[i]=n;
		}
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

//https://cert.ssafy.com/exam/contest/management/problem?contestId=AYLZNBvEBqABAAXj&problemId=AVXsCsQ2K0uH3Xf2&problemNo=1