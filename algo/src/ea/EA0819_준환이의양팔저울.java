package ea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EA0819_준환이의양팔저울 {
	
	
	static void rec(int idx, int gap, boolean[] visited, int[] lst,int N, int[]answer) {
		if(idx==N) {
			answer[0]++;
			return;
		}
		for(int i=0;i<N; i++) {
			if(visited[i]) continue;
			visited[i]=true;
			if(gap-lst[i]>=0) {
				rec(idx+1, gap-lst[i],visited,lst,N,answer);	
			}
			rec(idx+1, gap+lst[i],visited,lst,N,answer);
			visited[i]=false;
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn;
		StringBuffer sb= new StringBuffer();
		int T=Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T;tc++) {
			int [] lst;
			boolean[] visited;
			int N=Integer.parseInt(br.readLine());
			stn=new StringTokenizer(br.readLine());
			visited=new boolean[N];
			lst=new int[N];
			int[] answer=new int[] {0};
			for(int i=0; i<N; i++) {
				lst[i]=Integer.parseInt(stn.nextToken());
			}
			rec(0,0,visited,lst,N,answer);
			sb.append("#"+tc+" ").append(answer[0]+"\n");
			
		}
		System.out.println(sb);
	}

}
