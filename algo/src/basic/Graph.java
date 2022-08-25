package basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
	public static void main(String[] args) {
		int N=10;
		
		//리스트의 리스트
		ArrayList<List<Node>> graph = new ArrayList<List<Node>>();
		for (int i = 0; i <= N; i++) {
		    graph.add(new ArrayList<>());
		}
		int n1=1, n2=2, n3=3,w=10;
		graph.get(n1).add(new Node(n2,w));
		graph.get(n1).add(new Node(n3,w));
		System.out.println(graph.get(n1));
		
		
		//리스트의 배열
		List<Node>[] graph2 = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			graph2[i]=new ArrayList<>();
		}
		n1=1; n2=2; n3=3; w=10;
		graph2[n1].add(new Node(n2,w));
		graph2[n1].add(new Node(n3,w));
		System.out.println(graph2[n1]);
		
		
		//맵  노드클래스가 필요없고 직접 [n1][n2]접근해서 w를 알 수 있음
		Map<Integer,Integer>[] graph3= new HashMap[N];
		for (int i = 0; i < N; i++) {
			graph3[i]=new HashMap<>();
		}
		n1=1; n2=2; n3=3; w=10;
		graph3[n1].put(n2, w);
		graph3[n1].put(n3, w);
		System.out.println(graph3[n1].get(n2));
		System.out.println(graph3[n1].get(n3));
	}
	
	
	static class Node{
		int n,w;
		public Node(int n, int w) {
			this.n=n;
			this.w=w;
		}
		@Override
		public String toString() {
			return "[n=" + n + ", w=" + w + "]";
		}
		
	}
}
