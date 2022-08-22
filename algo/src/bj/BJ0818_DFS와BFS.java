package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class BJ0818_DFS와BFS {
	
	static void bfs() {
		Deque<Integer> que = new ArrayDeque<>();
		que.add(S);
		boolean[] visited=new boolean[N+1];
		visited[S]=true;
		int cn;
		while(!que.isEmpty()) {
			cn=que.pollFirst();
			sb.append(cn+" ");
			for(int nn : graph[cn]) {
				if(visited[nn]) continue;
				visited[nn]=true;
				que.add(nn);
			}
		}
	}
	
	static void dfs() {
		Deque<Integer> que = new ArrayDeque<>();
		que.add(S);
		boolean[] visited=new boolean[N+1];
		int cn;
		while(!que.isEmpty()) {
			cn=que.pollLast();
			if(visited[cn]) continue;
			visited[cn]=true;
			sb.append(cn+" ");
			for(int i=graph[cn].size()-1; i>=0; i--) {
				int nn=graph[cn].get(i);
				que.add(nn);
			}
		}
	}

	static int N, E, S;
	static StringBuffer sb;
	static List<Integer>[] graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn = new StringTokenizer(br.readLine());
		sb= new StringBuffer();
		N=Integer.parseInt(stn.nextToken());
		E=Integer.parseInt(stn.nextToken());
		S=Integer.parseInt(stn.nextToken());
		graph= new ArrayList[N+1];
		for(int n=0; n<=N; n++) {
			graph[n]=new ArrayList<>();
		}
		int n1,n2;
		for(int i=0; i<E; i++) {
			stn = new StringTokenizer(br.readLine());
			n1=Integer.parseInt(stn.nextToken());
			n2=Integer.parseInt(stn.nextToken());
			graph[n1].add(n2);
			graph[n2].add(n1);
		}
		for(int i=0; i<=N; i++) {
			Collections.sort(graph[i]);
			//System.out.println(graph[i]);
		}
		dfs();
		sb.append("\n");
		bfs();
		System.out.println(sb);
	}

}
