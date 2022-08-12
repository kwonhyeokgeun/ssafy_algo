package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
public class BJ0812_캐슬디펜스 {

	static void getDist(int x) {
		
	}
	
	static int h,w,N;
	static int[][] mat;
	static int enemy, itr;
	static List<Integer[]> xys;
	static int dists[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn;
		stn = new StringTokenizer(br.readLine());
		h=Integer.parseInt(stn.nextToken());
		w=Integer.parseInt(stn.nextToken());
		N=Integer.parseInt(stn.nextToken());
		mat=new int[h][w];
		int maxy=16;
		enemy=0;
		xys = new ArrayList<>();
		for(int y=0;y<h;y++) {
			stn=new StringTokenizer(br.readLine());
			for(int x=0; x<w; x++) {
				mat[y][x]=Integer.parseInt(stn.nextToken());
				maxy=Math.max(maxy, y);
				xys.add(new Integer[] {x,y});
				enemy++;
			}
		}
		itr=h-maxy;
		dists=new int[w][enemy];
		
		
	}
	
	public static class Item implements Comparable<Item>{
		public int d, x, idx;
		public Item(int d, int x, int idx) {
			this.d=d;
			this.x=x;
			this.idx=idx;
		}
		@Override
		public int compareTo(Item o) {
			return this.d==o.d? (this.x==o.x? this.idx-o.idx:this.x-o.x) :this.d-o.d;
		}
	}

}
