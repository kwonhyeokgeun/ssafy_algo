package ea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class EA0817_무선충전 {
	
	static void cal() {
		int ax=xys[0][0], ay=xys[0][1];
		int bx=xys[1][0], by=xys[1][1];
		if (mat[ay][ax].size()==0 && mat[by][bx].size()==0) 
			return;
		if(mat[ay][ax].size()==0) { //a가 받을 수 있는 발전소 없음
			int max=0;
			for(int i=0;i<mat[by][bx].size();i++) {
				max=Math.max(max, infos[mat[by][bx].get(i)][3]);
			}
			answer+=max;
			return;
		}
		if(mat[by][bx].size()==0) { //b가 받을 수 있는 발전소 없음
			int max=0;
			for(int i=0;i<mat[ay][ax].size();i++) {
				max=Math.max(max, infos[mat[ay][ax].get(i)][3]);
			}
			answer+=max;
			return;
			
		}
		int ai,bi;
		int max=0;
		for(int i=0; i<mat[ay][ax].size(); i++) {  //둘다 받는 경우 조합
			for(int j=0; j<mat[by][bx].size(); j++) {
				ai=mat[ay][ax].get(i);
				bi=mat[by][bx].get(j);
				if(ai==bi) {
					max=Math.max(max, infos[ai][3]);
				}else {
					max=Math.max(max, infos[ai][3]+infos[bi][3]);
				}
			}
		}
		answer+=max;
		
	}
	
	static int[][] lst; //이동경로
	static int M, N; //이동시간, BC 수
	static int[][] infos; //발전소 정보
	static List<Integer>[][] mat; //메트릭스에 발전소 범위표시
	static int[][] dirs= {{0,0},{0,-1},{1,0},{0,1},{-1,0}};
	static int[][] xys; //a와 b의 좌표 정보
	static int answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn;
		int T=Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			stn=new StringTokenizer(br.readLine());
			M=Integer.parseInt(stn.nextToken());
			N=Integer.parseInt(stn.nextToken());
			lst=new int[2][M];
			stn=new StringTokenizer(br.readLine());
			for(int i=0; i<M;i++) {
				lst[0][i]=Integer.parseInt(stn.nextToken());
			}
			stn=new StringTokenizer(br.readLine());
			for(int i=0; i<M;i++) {
				lst[1][i]=Integer.parseInt(stn.nextToken());
			}
			infos=new int[N][4];
			mat=new ArrayList[10][10];
			for(int y=0; y<10;y++) {
				for(int x=0;x<10; x++) {
					mat[y][x]=new ArrayList<>();
				}
			}
			for(int i=0; i<N; i++) {
				stn=new StringTokenizer(br.readLine());
				int cx=Integer.parseInt(stn.nextToken())-1;
				int cy=Integer.parseInt(stn.nextToken())-1;
				int c=Integer.parseInt(stn.nextToken());
				int p=Integer.parseInt(stn.nextToken());
				infos[i]=new int[] {cx,cy,c,p};
				for(int y=0; y<10;y++) {
					for(int x=0;x<10; x++) {
						if(Math.abs(cx-x)+Math.abs(cy-y)<=c) {
							mat[y][x].add(i);
						}
					}
				}
			}
			
			/*for(int y=0;y<10;y++) {
				for(int x=0;x<10;x++) {
					System.out.print(mat[y][x]);
				}System.out.println();
			}*/
			
			xys=new int[][] {{0,0},{9,9}};
			int cx,cy, nx,ny,dr;
			answer=0;
			
			for(int i=0;i<M; i++) {
				//System.out.println(xys[0][0]+" "+xys[0][1]+" "+xys[1][0]+" "+xys[1][1]);
				cal();
				//System.out.println(i+" "+answer);
				for(int j=0;j<2;j++) {
					dr=lst[j][i];
					if (dr==0) continue;
					cx=xys[j][0];
					cy=xys[j][1];
					nx=cx+dirs[dr][0]; //전진
					ny=cy+dirs[dr][1];
					xys[j][0]=nx; xys[j][1]=ny;
				}
			}
			cal();
			System.out.printf("#%d %d\n",tc,answer);
			
			
		}

	}

}
