package ea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class EA0823_최소_스패닝_트리2 {

	static void prim() {
		visited[1]=true; //여기선 시작정점은 1로 함
		hp.addAll(graph.get(1)); //1의 모든 엣지 넣어줌
		
		while(!hp.isEmpty()) {
			Edge ce=hp.poll();
			if(visited[ce.n]) continue;
			visited[ce.n]=true;
			answer+=ce.w;
			hp.addAll(graph.get(ce.n));
		}
	}

	static int V,E;
	static long answer;
	static int[] root;
	static PriorityQueue<Edge> hp;
	static ArrayList<List<Edge>> graph;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn;
		StringBuffer sb = new StringBuffer();
		int T=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T; tc++) {
			stn=new StringTokenizer(br.readLine());
			V=Integer.parseInt(stn.nextToken());
			E=Integer.parseInt(stn.nextToken());
			
			graph=new ArrayList<List<Edge>>();
			for(int i=0; i<=V; i++) {
				graph.add(new ArrayList<Edge>());
			}
			
			hp=new PriorityQueue<>();
			
			for(int i=0; i<E; i++) {
				stn=new StringTokenizer(br.readLine());
				int n1=Integer.parseInt(stn.nextToken());
				int n2=Integer.parseInt(stn.nextToken());
				int w=Integer.parseInt(stn.nextToken());
				
				graph.get(n1).add(new Edge(n2,w));
				graph.get(n2).add(new Edge(n1,w));
				
			}
			
			visited=new boolean[V+1];
			answer=0;
			prim();
			sb.append("#"+tc+" ").append(answer+"\n");
		}
		System.out.println(sb);
	}
	
	static class Edge implements Comparable<Edge>{
		int n,w;
		public Edge(int n, int w) {
			this.n=n;
			this.w=w;
		}
		@Override
		public int compareTo(Edge o) {
			return this.w-o.w;
		}
		
		
	}

}
