package ea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class EA0823_최소_스패닝_트리 {
	static int find(int n) { //root찾기
		if(root[n]==n) {
			return n;
		}else {
			return root[n]=find(root[n]);
		}
	}
	
	static void union(int n1, int n2, int w) { //합치기
		int r1=find(n1);
		int r2=find(n2);
		if(r1==r2) return;
		if(r1>r2) {
			root[r1]=r2;
			//root[n1]=r2;
		}else {
			root[r2]=r1;
			//root[n2]=r1;
		}
		answer+=w;
		
	}
	
	
	static void kruskal() {
		root=new int[V+1];
		for(int i=1; i<=V;i++) {
			root[i]=i;
		}
		
		while(!hp.isEmpty()) {
			Edge ce=hp.poll();
			union(ce.n1,ce.n2,ce.w);
			
		}
	}

	static int V,E;
	static long answer;
	static int[] root;
	static PriorityQueue<Edge> hp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn;
		StringBuffer sb = new StringBuffer();
		int T=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T; tc++) {
			stn=new StringTokenizer(br.readLine());
			V=Integer.parseInt(stn.nextToken());
			E=Integer.parseInt(stn.nextToken());
			hp=new PriorityQueue<>();
			
			for(int i=0; i<E; i++) {
				stn=new StringTokenizer(br.readLine());
				int n1=Integer.parseInt(stn.nextToken());
				int n2=Integer.parseInt(stn.nextToken());
				int w=Integer.parseInt(stn.nextToken());
				hp.add(new Edge(n1,n2,w));
			}
			
			
			answer=0;
			kruskal();
			//System.out.printf("#%d %d\n",tc,answer);
			sb.append("#"+tc+" ").append(answer+"\n");
		}
		System.out.println(sb);
	}
	
	static class Edge implements Comparable<Edge>{
		int n1,n2,w;
		public Edge(int n1, int n2, int w) {
			this.n1=n1;
			this.n2=n2;
			this.w=w;
		}
		@Override
		public int compareTo(Edge o) {
			return this.w-o.w;
		}
		@Override
		public String toString() {
			return "[n1=" + n1 + ", n2=" + n2 + ", w=" + w + "]";
		}
		
	}

}
