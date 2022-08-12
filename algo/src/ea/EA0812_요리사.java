package ea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class EA0812_요리사 {
	
	static void cal() {
		List<Integer> lst=new ArrayList<>();
		List<Integer> lst2=new ArrayList<>();
		for(int i=0; i<N; i++) {
			if(selected[i]) {
				lst.add(i);
			}else {
				lst2.add(i);
			}
		}

		int sum1=0;
		for(int i=0; i<N2; i++) {
			for(int j=0; j<N2; j++) {
				sum1+=mat[lst.get(i)][lst.get(j)];
			}
		}
		int sum2=0;
		for(int i=0; i<N2; i++) {
			for(int j=0; j<N2; j++) {
				sum2+=mat[lst2.get(i)][lst2.get(j)];
			}
		}
		answer=Math.min(answer, Math.abs(sum1-sum2));
		
	}
	
	static void comb(int idx, int n) {
		if(n==0) {
			cal();
			return;
		}
		for(int i=idx; i<N-n+1; i++) {
			selected[i]=true;
			comb(i+1,n-1);
			selected[i]=false;
		}
	}

	static int N, N2;
	static int[][]mat;
	static boolean[] selected;
	static int answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn;
		int T=Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=T; tc++) {
			N=Integer.parseInt(br.readLine());
			N2=N/2;
			selected=new boolean[N];
			mat=new int[N][N];
			
			for(int y=0;y<N;y++) {
				answer=Integer.MAX_VALUE;
				stn=new StringTokenizer(br.readLine());
				for(int x=0; x<N; x++) {
					mat[y][x]=Integer.parseInt(stn.nextToken());
				}
			}
			
			comb(0,N2);
			sb.append("#"+tc+" ").append(answer).append("\n");
			
		}System.out.println(sb);

	}

}
