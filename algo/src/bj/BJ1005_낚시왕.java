package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1005_낚시왕 {
	
	static Shark[][] move(Shark[][] mat) {
		Shark[][] ret=new Shark[H][W];
		for(int y=0; y<H; y++) {
			for(int x=0; x<W; x++) {
				if(mat[y][x]!=null) { //상어가 있다면
					Shark cur=mat[y][x];
					int nx=x, ny=y;
					int s=cur.s;
					while(s!=0) { //상어 이동
						if(cur.d==0) { //우
							if(W-nx-1<=s) {
								cur.d=2;
								s-=(W-nx-1);
								nx=W-1;
							}else {
								nx+=s;
								break;
							}
						}else if(cur.d==1) { //하
							if(H-ny-1<=s) {
								cur.d=3;
								s-=(H-ny-1);
								ny=H-1;
							}else {
								ny+=s;
								break;
							}
						}else if(cur.d==2) {//좌
							if(nx<=s) {		
								cur.d=0;
								s-=nx;
								nx=0;
							}else {
								nx-=s;
								break;
							}
						}else { //상
							if(ny<=s) {
								cur.d=1;
								s-=ny;
								ny=0;
							}
							else {
								ny-=s;
								break;
							}
						}
					}
					
					if(ret[ny][nx]!=null) { //이동후 이미 상어가 있는 자리면
						if(ret[ny][nx].z<cur.z) {
							ret[ny][nx]=cur;
						}
					}else {  //빈자리면
						ret[ny][nx]=cur;
					}
					
				}
			}
		}
		
		return ret;
	}
	
	static int catching(int x) {
		for(int y=0; y<H;y++) {
			if (mat[y][x]!=null) {
				int size=mat[y][x].z;
				mat[y][x]=null;
				return size;
			}
		}
		
		return 0;
	}
	
	static void fishing() {
		for(int fi=0; fi<W; fi++) { //사람이동
			int fishSize=catching(fi); //상어 잡기
			answer+=fishSize;
			if(fi!=W-1)
				mat=move(mat); // 상어 이동
		}
	}

	static int H,W,M,answer;
	static Shark[][] mat;
	static int[][] dirs= {{1,0},{0,1},{-1,0},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn = new StringTokenizer(br.readLine());
		H=Integer.parseInt(stn.nextToken());
		W=Integer.parseInt(stn.nextToken());
		M=Integer.parseInt(stn.nextToken());
		mat=new Shark[H][W];
		
		for(int i=0; i<M; i++) {
			stn = new StringTokenizer(br.readLine());
			int y=Integer.parseInt(stn.nextToken())-1;
			int x=Integer.parseInt(stn.nextToken())-1;
			int s=Integer.parseInt(stn.nextToken());
			int d=Integer.parseInt(stn.nextToken());
			int z=Integer.parseInt(stn.nextToken());
			int dr;
			if(d==1)dr=3;
			else if(d==2)dr=1;
			else if(d==3)dr=0;
			else dr=2;
			mat[y][x]=new Shark(s,dr,z);
			
		}
		
		answer=0;
		fishing();
		System.out.println(answer);
	}
	
	static class Shark{
		int s,d,z;
		Shark(int s, int d, int z){
			this.s=s;
			this.d=d;
			this.z=z;
		}
	}

}
