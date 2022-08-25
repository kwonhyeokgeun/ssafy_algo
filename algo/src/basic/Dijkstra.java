package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1753
public class Dijkstra {
	
	static void dijkstra() {
		hp.add(new Node(S,0)); //시작 노드, 지금까지 w합
		dist[S]=0;
		
		while(!hp.isEmpty()) {
			Node cur=hp.poll();
			int cn = cur.n, cdist = cur.w;
			if(cdist > dist[cn]) continue;
			for(Node nxt : graph.get(cn)) {
				int nn = nxt.n, w = nxt.w; //다음 노드 nn, cn과 nn의 w
				int ndist = cdist+w;
				if(dist[nn] <= ndist) continue;
				dist[nn]=ndist;
				hp.add(new Node(nn,ndist));
			}
			
		}
		
	}
	
	static int V,E,S; 
	static List<List<Node>> graph;
	static PriorityQueue<Node> hp =new PriorityQueue<>((o1,o2)->o1.w-o2.w);
	static final int inf=Integer.MAX_VALUE;
	static int[] dist;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn = new StringTokenizer(br.readLine());
		V=Integer.parseInt(stn.nextToken());
		E=Integer.parseInt(stn.nextToken());
		S=Integer.parseInt(br.readLine());
		
		graph=new ArrayList<List<Node>>();
		dist=new int[V+1];
		for(int i=0; i<=V; i++) {
			graph.add(new ArrayList<>());
			dist[i]=inf;
		}
		
		for(int i=0; i<E; i++) {
			stn = new StringTokenizer(br.readLine());
			int n1=Integer.parseInt(stn.nextToken());
			int n2=Integer.parseInt(stn.nextToken());
			int w=Integer.parseInt(stn.nextToken());
			graph.get(n1).add(new Node(n2,w));
		}
		
		dijkstra();
		StringBuffer sb=new StringBuffer();
		for(int i=1; i<=V; i++) {
			if(dist[i]==inf)
				sb.append("INF ");
			else	
				sb.append(dist[i]+" ");
		}
		System.out.println(sb);
		
	}
	
	static class Node{
		int n, w;
		Node(int n, int w){
			this.n=n;
			this.w=w;
		}
	}
}
