package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class BJ1007_게리맨더링 {
	
	static void check() {
		boolean[] visited = new boolean[N+1];
		int t=-1, f=-1;
		for(int i=1; i<=N; i++) {
			if((selected[i] && t==-1) || (!selected[i] && f==-1) ) {
				if(selected[i]) t=i;
				else f=i;
				visited[i]=true;
				Deque<Integer> que = new ArrayDeque<>();
				que.add(i);
				while(!que.isEmpty()) {
					int cn=que.pollFirst();
					for(int nn : graph[cn]) {
						if(visited[nn] || selected[nn]!=selected[cn]) continue;
						visited[nn]=true;
						que.add(nn);
					}
				}
			}
		}
		int sum=0;
		if(t==-1 ||f==-1) 
			return ;
		for(int i=1; i<=N; i++) {
			if(visited[i]==false) return ;
			if(selected[i]) sum+=popul[i];
		}
		answer=Math.min(answer, Math.abs(popSum-sum-sum));
		//System.out.println(Arrays.toString(selected) +" "+ (popSum-sum) +" "+sum);

	}
	
	static void rec(int idx) {
		
		for(int i=idx; i<=N; i++) {
			selected[i]=true;
			check();
			rec(i+1);
			selected[i]=false;
		}
	}

	static int N, answer,popSum;
	static int[] popul;
	static int[][] graph;
	static boolean[] selected;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		popul=new int[N+1];
		StringTokenizer stn = new StringTokenizer(br.readLine());
		popSum=0;
		for (int x=1; x<=N; x++) {
			popul[x]=Integer.parseInt(stn.nextToken());
			popSum+=popul[x];
		}
		
		graph=new int[N+1][];

		selected=new boolean[N+1];
		for(int n=1; n<=N; n++) {
			stn = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(stn.nextToken());
			graph[n]=new int[l];
			for(int i=0; i<l; i++) {
				graph[n][i]=Integer.parseInt(stn.nextToken());
			}
		}
		
		answer=Integer.MAX_VALUE;
		rec(1);
		if(answer==Integer.MAX_VALUE)
			answer=-1;
		System.out.println(answer);
		
	}

}
