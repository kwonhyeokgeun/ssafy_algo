package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ0817_감시 {
	
	static int getNum(int[][] mat) {
		int num=0;
		for(int y=0;y<h;y++) {
			for(int x=0; x<w; x++) {
				if (mat[y][x]==0) 
					num++;
			}
		}
		return num;
	}
	static int[][] copy(int[][] mat){
		int[][] nmat=new int[h][w];
		for(int y=0; y<h;y++) {
			for(int x=0; x<w; x++) {
				nmat[y][x]=mat[y][x];
			}
		}
		return nmat;
	}
	static void check(int ind, int [][]mat) {
		if(ind==cctvn) {
			answer=Math.min(answer, getNum(mat));
		}
		if(cctvs.get(ind).tp==1 || cctvs.get(ind).tp==3 || cctvs.get(ind).tp==4) {
			for(int dr=0; dr<4; dr++) {
				int[][] nmat=copy(mat);
				
			}
			
			
		}else if(cctvs.get(ind).tp==2) {
			
		}else{
			
		}
		
	}

	static int h,w, answer;
	static int[][] mat;
	static List<CCTV> cctvs;
	static int cctvn;
	static int[][] dirs= {{1,0},{0,1},{-1,0},{0,-1}};
	static int [][]drs= {{},{0},{0,2},{0,1},{0,1,2},{0,1,2,3}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn= new StringTokenizer(br.readLine());
		h=Integer.parseInt(stn.nextToken());
		w=Integer.parseInt(stn.nextToken());
		mat=new int[h][w];
		cctvs=new ArrayList<>();
		for(int y=0;y<h;y++) {
			stn=new StringTokenizer(br.readLine());
			for(int x=0; x<w; x++) {
				mat[y][x]=Integer.parseInt(stn.nextToken());
				if(mat[y][x]>0 || mat[y][x]>6) {
					cctvs.add(new CCTV(mat[y][x],x,y)); 
					
				}
			}
		}
		cctvn=cctvs.size();
		answer=h*w;
	}
	
	public static class CCTV{
		int tp, x, y;
		public CCTV(int tp, int x, int y) {
			this.tp=tp;
			this.x=x;
			this.y=y;
		}
	}

}
