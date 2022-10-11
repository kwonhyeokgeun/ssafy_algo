package ea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EA1006_사람네트워크2 {
	//플로이드 워셜 알고리즘??

	
	
	static final int INF=999999;
	static int[][] mat;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T= Integer.parseInt(br.readLine());
		StringTokenizer stn;
		for(int tc=1; tc<=T; tc++) {
			stn=new StringTokenizer(br.readLine());
			N=Integer.parseInt(stn.nextToken());
			mat=new int[N][N];
			
			for(int y=0; y<N; y++) {
				for(int x=0; x<N; x++) {
					int n=Integer.parseInt(stn.nextToken());
					if(n==0 && y!=x) mat[y][x]=INF;
					else mat[y][x]=n;
					
					
				}
			}
			for(int k=0; k<N; k++) {
				for(int n1=0; n1<N; n1++) {
					for(int n2=0; n2<N; n2++) {	
						mat[n1][n2]=Math.min(mat[n1][n2], mat[n1][k]+mat[k][n2]);
					}
				}
			}
			int answer=INF;
			for(int y=0; y<N; y++) {
				int cnt=0;
				for(int x=0; x<N; x++) {
					//if(mat[y][x]!=INF)
					cnt+=mat[y][x];
				}
				if (cnt<answer) answer=cnt;
			}
			System.out.printf("#%d %d\n",tc,answer);
			
		}
		
		
	}

}
