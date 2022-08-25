package ea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class EA0825_작업순서 {
	
	static void go() {
		
		Deque<Integer>que = new ArrayDeque<>();
		for(int i=1; i<=V;i++) { //가르켜지지 않는 것들 시작에 넣기
			if(pointed[i]==0 ) {
				que.add(i);
				visited[i]=true;
			}
		}
		
		while(!que.isEmpty()) {
			int cn=que.pollFirst();
			if(cnt[cn]<pointed[cn]) { //이전거를 모두 거치지 못했으면 보류
				que.add(cn);
				continue;
			}else if(cnt[cn]==pointed[cn]) {  //이전꺼 모두 거침
				sb.append(cn+" ");
				for(int nn:graph[cn]) {
					cnt[nn]++;
					if(visited[nn]) {
						continue;
					}
					visited[nn]=true;
					que.add(nn);
				}
			}
		}
	}
	
	static int V,E;
	static List<Integer>[] graph;
	static boolean[] visited;
	static int[] pointed, cnt;
	static StringBuffer sb = new StringBuffer();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn;
		
		int T=10;
		for(int tc=1; tc<=T; tc++) {
			stn=new StringTokenizer(br.readLine());
			V=Integer.parseInt(stn.nextToken());
			E=Integer.parseInt(stn.nextToken());
			stn=new StringTokenizer(br.readLine());
			graph=new ArrayList[V+1];
			for(int i=1; i<=V; i++) {
				graph[i]=new ArrayList<>();
			}
			
			pointed=new int[V+1];  //나를 가르키는 노드 수
			for(int i=0; i<E; i++) {
				int n1=Integer.parseInt(stn.nextToken());
				int n2=Integer.parseInt(stn.nextToken());
				graph[n1].add(n2);
				pointed[n2]++;
			}
			sb.append("#"+tc+" ");
			
			visited=new boolean[V+1]; //방문했는지
			cnt=new int[V+1];  //도착한 노드 수

			go();
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
}
