package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.List;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Arrays;
public class BJ0812_캐슬디펜스 {

	static int getDist(int x, int y, int x2 ) {
		return Math.abs(x-x2)+h-y;
	}
	
	static void makeHeap(int[] lst) { //거리, x축에 따른 힙 생성
		Integer[] xy;
		for(int gi=0; gi<3; gi++) {
			hps[gi]=new PriorityQueue<>();
			int gx=lst[gi]; //궁수위치
			for(int i=0; i<enemy; i++) {
				xy=xys.get(i); //적위치
				hps[gi].add(new Item(dists[gx][i],xy[0],xy[1],i));
			}
		}
	}
	
	static void terminate(int[] lst,int it) { //한턴 적 제거
		boolean[] same=new boolean[enemy];
		for(int gi=0; gi<3; gi++) { 
			while(!hps[gi].isEmpty()) { 
				Item now=hps[gi].peek();
				if(now.y+it>=h) { //적이 칸을 벗어남
					hps[gi].poll();
					visited[now.idx]=true;
					continue;
				}
				if(now.d-it>N)break; //가장 가까운 적이 N보다 멈
				
				hps[gi].poll(); //적제거
				if(same[now.idx]) break; //같은 턴에 제거된 경우
				if (visited[now.idx] ) continue;
				cnt++;
				visited[now.idx]=true;
				same[now.idx]=true;
				break;
			}
			
		}
	}
	
	static void sol() {
		int[] lst;
		for(int i=0;i<w-2;i++) {
			for(int j=i+1; j<w-1; j++) {
				for(int k=j+1; k<w; k++) {
					cnt=0; //
					hps=new PriorityQueue[3];
					visited=new boolean[enemy];
					lst=new int[] {i,j,k}; //궁수의 x축위치
					makeHeap(lst); //거리와 x축에 따라 힙 생성
					for(int it=0; it<itr; it++) { //적 제거
						if(cnt==enemy) {
							answer=cnt;
							return;
						}
						terminate(lst,it); //한턴간 적 저게
						
					}
					answer=Math.max(answer, cnt);
				}
			}
		}
	}
	
	static int h,w,N,answer,cnt;
	static int[][] mat;
	static boolean[]visited;
	static int enemy, itr;
	static List<Integer[]> xys;
	static int dists[][];
	static PriorityQueue<Item>[] hps;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn;
		stn = new StringTokenizer(br.readLine());
		h=Integer.parseInt(stn.nextToken());
		w=Integer.parseInt(stn.nextToken());
		N=Integer.parseInt(stn.nextToken());
		mat=new int[h][w];
		int miny=16;
		xys = new ArrayList<>();
		for(int y=0;y<h;y++) {
			stn=new StringTokenizer(br.readLine());
			for(int x=0; x<w; x++) {
				mat[y][x]=Integer.parseInt(stn.nextToken());
				if(mat[y][x]==1) {
					miny=Math.min(miny, y);
					xys.add(new Integer[] {x,y});
				}
			}
		}
		
		itr=h-miny;
		enemy=xys.size();
		dists=new int[w][enemy];
		for(int i=0; i<w; i++) {  //궁수와 적의 거리
			for(int j=0; j<enemy;j++) {
				Integer[] xy=xys.get(j);
				dists[i][j]=getDist(xy[0], xy[1], i);
			}
		}
		
		
		answer=0;
		
		sol();
		System.out.println(answer);
	}
	
	public static class Item implements Comparable<Item>{
		public int d, x,y, idx;//거리, x,y, 인덱스
		public Item(int d, int x, int y,int idx) {
			this.d=d;
			this.x=x;
			this.y=y;
			this.idx=idx;
		}
		@Override
		public int compareTo(Item o) {
			return this.d==o.d? (this.x==o.x? this.idx-o.idx:this.x-o.x) :this.d-o.d;
		}
	}

}
