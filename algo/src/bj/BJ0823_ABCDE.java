package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class BJ0823_ABCDE {
	
	static void dfs(int cn, int d) { //재귀함수 버전 (훨씬 빠름)
		if(d>=5) {
			answer=1;
			return;
		}
		for(int nn:graph[cn]) {
			if(visited[nn])continue;
			visited[nn]=true;
			dfs(nn,d+1);
			visited[nn]=false;
		}	
	}
	
	static void dfs(int n) { //stack을 사용한 버전
		Deque<Item> que = new ArrayDeque<>();
		que.add(new Item(n,1,new ArrayList<>()));
		while (!que.isEmpty()) {
			Item it = que.pollLast();
			if(it.d>=5) {
				answer=1;
				return;
			}
			for(int nn : graph[it.n]) {
				if(it.lst.contains(nn)) continue;
				List<Integer> nlst=new ArrayList<>(it.lst);
				nlst.add(it.n);
				que.add(new Item(nn,it.d+1,nlst));
			}
		}
	}

	static int N,E, answer;
	static List<Integer>[] graph;
	static boolean []visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn = new StringTokenizer(br.readLine());
		N=Integer.parseInt(stn.nextToken());
		E=Integer.parseInt(stn.nextToken());
		graph=new ArrayList[N];
		for(int i=0; i<N; i++) {
			graph[i]=new ArrayList<>();
		}
		for(int i=0; i<E; i++) {
			stn = new StringTokenizer(br.readLine());
			int n1=Integer.parseInt(stn.nextToken());
			int n2=Integer.parseInt(stn.nextToken());
			graph[n1].add(n2);
			graph[n2].add(n1);
			
		}
		answer=0;
		for(int n=0; n<N; n++) { //재귀함수 사용
			if(answer==1) break;
			visited=new boolean[N];
			visited[n]=true;
			dfs(n,1);
			
		}
		/*for(int n=0; n<N; n++) { //스택사용
			if(answer==1) break;
			dfs(n);
			
		}*/
		
		System.out.println(answer);
	}
	static class Item{
		int n;
		int d;
		List<Integer> lst;
		public Item(int n, int d, List<Integer> lst) {
			this.n=n;
			this.d=d;
			this.lst=lst;
		}
	}

}
