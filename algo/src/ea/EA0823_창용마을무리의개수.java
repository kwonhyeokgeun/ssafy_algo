package ea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class EA0823_창용마을무리의개수 {

	static void go(int idx) {
		Deque<Integer> que=new ArrayDeque<>();
		que.add(idx);
		while(!que.isEmpty()) {
			int cn=que.pollFirst();
			for(int nn: graph[cn]) {
				if(visited[nn]) continue;
				visited[nn]=true;
				que.add(nn);
			}
		}
	}
	
	static int N,M;
	static long answer;
	static boolean[] visited;
	static List<Integer>[] graph;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn;
		StringBuffer sb=new StringBuffer();
		int T=Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			stn=new StringTokenizer(br.readLine());
			N=Integer.parseInt(stn.nextToken());
			M=Integer.parseInt(stn.nextToken());
			
			graph=new ArrayList[N+1];
			for(int i=1; i<=N; i++) {
				graph[i]=new ArrayList<Integer>();
			}
			
			for(int i=0; i<M; i++) {
				stn=new StringTokenizer(br.readLine());
				int n1=Integer.parseInt(stn.nextToken());
				int n2=Integer.parseInt(stn.nextToken());
				graph[n1].add(n2);
				graph[n2].add(n1);
				
			}
			visited=new boolean[N+1];
			answer=0;
			for(int i=1; i<=N; i++) {
				if(visited[i])continue;
				answer++;
				visited[i]=true;
				go(i);
			}
			sb.append("#"+tc+" ").append(answer+"\n");
		}
		System.out.println(sb);

	}
	


}
