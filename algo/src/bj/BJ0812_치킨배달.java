package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class BJ0812_치킨배달 {
	
	static void comb(int idx, int n) { //조합
		if(n==0) { ///선택완료
			int sum=0;
			//System.out.println(Arrays.toString(selected));
			for(int h=0;h<house;h++) {  //선택된 치킨집으로 거리 더해보기
				int min=Integer.MAX_VALUE;
				for(int c=0; c<chi; c++) {
					if (selected[c]==false) continue; //선택안된건 패스
					min=Math.min(min, mem[h][c]);
				}
				sum+=min;
			}
			answer=Math.min(sum, answer);
			return;
		}
		for(int i=idx; i<chi-n+1; i++) {
			selected[i]=true;
			comb(i+1,n-1);
			selected[i]=false;
		}
	}
	
	
	
	static void getDist() { //모든 치킨집과 집의 거리를 mem에 저장
		for(int i=0; i<houses.size(); i++) {
			int hx=houses.get(i)[0];
			int hy=houses.get(i)[1];
			for(int j=0;j<chis.size(); j++) {
				mem[i][j]=Math.abs(hx-chis.get(j)[0])+Math.abs(hy-chis.get(j)[1]);
			}
		}
	}

	static int N,M, chi, house, answer;
	static int[][]mat;
	static int[][] mem;
	static List<int[]> chis;
	static List<int[]> houses;
	static boolean[]selected;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn;
		stn=new StringTokenizer(br.readLine());
		N=Integer.parseInt(stn.nextToken());
		M=Integer.parseInt(stn.nextToken());
		mat=new int[N][N];
		chis=new ArrayList<>();
		houses=new ArrayList<>();
		answer=Integer.MAX_VALUE;
		for(int y=0; y<N; y++) {
			stn=new StringTokenizer(br.readLine());
			for(int x=0; x<N; x++) {
				mat[y][x]=Integer.parseInt(stn.nextToken());
				if(mat[y][x]==1) {
					house++;
					houses.add(new int[] {x,y});
				}
				else if(mat[y][x]==2) {
					chi++;
					chis.add(new int[] {x,y});
				}
			}
		}

		mem=new int[house][chi];
		selected=new boolean[chi];
		getDist(); //집과 치킨집과의 모든 거리 구하기
		
		
		comb(0,M); //모든 조합 계산해보기
		System.out.println(answer);
	}

}
