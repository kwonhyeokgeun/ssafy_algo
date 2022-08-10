package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ0810_배열돌리기4 {
	
	static void cycle(int x, int y, int s) { //x,y,지름
		if(s==0) { //지름 0이면 리턴
			/*
			for(int yy=0; yy<h; yy++) {
				for(int xx=0; xx<w; xx++) {
					System.out.print(mat2[yy][xx]+" ");
				}System.out.println();
			}System.out.println("==========");
			*/
			return;
		}
		int sx=x-s, sy=y-s, ex=x+s, ey=y+s;
		int temp=mat2[sy][ex];
		//회전하기
		for(int i=0; i<2*s; i++) { //상
			mat2[sy][ex-i]=mat2[sy][ex-i-1];
		}
		for(int i=0; i<2*s; i++) {  //좌
			mat2[sy+i][sx]=mat2[sy+i+1][sx];
		}
		for(int i=0; i<2*s; i++) {  //하
			mat2[ey][sx+i]=mat2[ey][sx+i+1];
		}
		for(int i=0; i<2*s; i++) {  //우
			mat2[ey-i][ex]=mat2[ey-i-1][ex];
		}
		mat2[sy+1][ex]=temp;
		
		cycle(x,y,s-1); //지름 s-1도 회전
	}
	
	static void perm(int n) {
		if(n==K) { //순열 정해짐
			mat2=new int[h][w];
			for(int y=0; y<h; y++) { //배열복사
				for(int x=0; x<w; x++) {
					mat2[y][x]=mat[y][x];
				}
			}

			for(int i=0; i<K; i++) {//순열 순서대로 회전
				int x=ops[per[i]][0];
				int y=ops[per[i]][1];
				int s=ops[per[i]][2];
				cycle(x,y,s);
			}
			score(); //순열대로 회전 후 점수 최신화
			return;
		}
		
		//순열 진행
		for(int i=0; i<K; i++) { 
			if(selected[i]) continue;
			selected[i]=true;
			per[n]=i;
			perm(n+1);
			selected[i]=false;
		}
	}
	
	static void score() { //점수 최신화
		int ret=Integer.MAX_VALUE;
		
		for(int y=0; y<h; y++) {
			int sum=0;
			for(int x=0; x<w; x++) {
				sum+=mat2[y][x];
			}
			ret=Math.min(ret, sum);
		}

		answer=Math.min(answer, ret);
		
	}
	
	static int h,w,K, answer=Integer.MAX_VALUE;
	static int[][] mat;
	static int[][] mat2;
	static int[][] ops; //회전명령 배열
	static boolean[] selected;
	static int[] per; //순열
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn=new StringTokenizer(br.readLine());
		h=Integer.parseInt(stn.nextToken());
		w=Integer.parseInt(stn.nextToken());
		K=Integer.parseInt(stn.nextToken());
		mat=new int[h][w];
		ops=new int[K][3];
		selected = new boolean[K];
		per=new int[K];
		for(int y=0; y<h; y++) {
			stn=new StringTokenizer(br.readLine());
			for(int x=0; x<w; x++) {
				mat[y][x]=Integer.parseInt(stn.nextToken());
			}
		}
		for(int i=0; i<K;i++) {
			stn=new StringTokenizer(br.readLine());
			ops[i][1]=Integer.parseInt(stn.nextToken())-1;
			ops[i][0]=Integer.parseInt(stn.nextToken())-1;
			ops[i][2]=Integer.parseInt(stn.nextToken());
		}
		

		
		perm(0);//순열 시작
		System.out.println(answer);
		
	}

}
