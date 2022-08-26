package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2098
public class BJ0819_외판원순회2 {
	//dp[3][1100101] => 1,3,6,7 방문 후, 남은 2,4,5 도시를 방문하는 최소비용 (이후 2,4,5를 모두 따져서 최소값 갱신)
	//  // 2번 도시를 간다고 가정 (4번도 가봐야 하고, 5번도 가봐야 한다.)
	//  2번 : dp[2][1100111]       <<  만약 4번을 먼저 간다면 dp[4][1101101], 5번을 먼저 간다면 dp[5][1110101] >>
	//  dp[3][1100101] ==> [ dp[2][1100111] + 3->2 비용 ] [ dp[4][1101101] + 3->4 비용 ] [ dp[5][1110101] + 3->5 비용 ] 중 최소 비용 선택
	
	//위 과정을 반복하게 되면 마지막 dp[5][1111111] = 5->1, dp[4][1111111] = 4->1.
	static int tsp(int x, int mask) {
		if(mask == allMask) {
			if(mat[x][0]==0) return inf;  //못가므로 큰수로
			else return mat[x][0];
		}
		
		//이미 계산된 dp가 있으면 그걸 return;
		if(dp[x][mask]!=0) return dp[x][mask];
		
		//이미 계산된 dp가 없으면 따져나감
		dp[x][mask]=inf; //큰값으로 초기화
		for(int i=0; i<N; i++) {
			//경로가 없거나 이미 방문했으면 skip
			if(mat[x][i] == 0 || (mask & (1<<i)) != 0) continue;
			int nmask = mask|(1<<i);
			dp[x][mask]=Math.min(dp[x][mask], tsp(i, nmask) + mat[x][i]);
		}
		
		return dp[x][mask];
	}

	static int N, answer;
	static int[][] mat;
	static int[][] dp;
	static int inf=987654321;
	static int allMask;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn;
		N=Integer.parseInt(br.readLine());
		allMask = (1<<N)-1;
		dp=new int[N][allMask];
		mat=new int[N][N];
		for(int y=0; y<N; y++) {
			stn=new StringTokenizer(br.readLine());
			for(int x=0; x<N; x++) {
				mat[y][x]=Integer.parseInt(stn.nextToken());
			}
		}
		
		

		answer=tsp(0,1);
		
		
		System.out.println(answer);
	}

}
