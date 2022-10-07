package ea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class EA1007_키순서 {
	
	static void go(int sn) {
		boolean[] visited=new boolean[N+1];
		Deque<Integer> que = new ArrayDeque<>();
		que.add(new Integer(sn));
		visited[sn]=true;
		while(!que.isEmpty()) {
			int cn=que.pollFirst();
			for(int nn=1; nn<=N; nn++) {
				if(visited[nn]||graph[cn][nn]==0)continue;
				visited[nn]=true;
				big[sn]++;
				small[nn]++;
				que.add(new Integer(nn));
			}
		}
	}

	static int N,M;
	static int[][] graph;
	static int[] big, small;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T= Integer.parseInt(br.readLine());
		StringTokenizer stn;
		for(int tc=1; tc<=T; tc++) {
			N=Integer.parseInt(br.readLine());
			M=Integer.parseInt(br.readLine());
			graph=new int [N+1][N+1];
			for(int __=0; __<M; __++) {
				stn=new StringTokenizer(br.readLine());
				int a=Integer.parseInt(stn.nextToken());
				int b=Integer.parseInt(stn.nextToken());
				graph[a][b]=1;
			}
			
			big=new int[N+1]; //나보다 큰사람수
			small=new int[N+1]; //나보다 작은사람수
			for(int n=1; n<=N; n++) {
				go(n);
			}
			int answer=0;
			//System.out.println(Arrays.toString(big));
			//System.out.println(Arrays.toString(small));
			for(int n=1; n<=N; n++ ) {
				if(big[n]+small[n]==N-1) {
					answer++;
				}
			}
			System.out.printf("#%d %d\n",tc,answer);
		}
	}

}
