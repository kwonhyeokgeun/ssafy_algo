package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1006_맥주마시면서걸어가기 {
	
	static boolean go() {
		PriorityQueue<Node> hp=new PriorityQueue<>( (o1,o2) -> o1.sum-o2.sum);
		hp.add(new Node(0,0));
		int[] visited=new int[N+2];
		for(int i=1; i<N+2; i++) {
			visited[i]=99999999;
		}
		while(!hp.isEmpty()) {
			Node cur=hp.poll();
			int cn=cur.cn;
			int sum=cur.sum;
			for(int nn=0; nn<N+2; nn++) {
				if(nn==cn || mat[cn][nn]>1000 ) continue;
				if(nn==N+1) return true;
				int sum2=sum+mat[cn][nn];
				if(visited[nn]<=sum2)continue;
				visited[nn]=sum2;
				hp.add(new Node(nn,sum2));
				
				
			}
		}
		return false;
	}
	
	static int N;
	static int[][]mat;
	static int[][]xys;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn;
		int T=Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			N=Integer.parseInt(br.readLine());
			xys=new int[N+2][2];
			mat=new int[N+2][N+2];
			for(int i=0; i<N+2; i++) {
				stn= new StringTokenizer(br.readLine());
				int x=Integer.parseInt(stn.nextToken());
				int y=Integer.parseInt(stn.nextToken());
				xys[i][0]=x; xys[i][1]=y;
			}
			
			for(int n1=0; n1<N+1; n1++) {
				for(int n2=n1+1; n2<N+2; n2++) {
					int dist=Math.abs(xys[n1][0]-xys[n2][0]) + Math.abs(xys[n1][1]-xys[n2][1]);
					mat[n1][n2]=dist;
					mat[n2][n1]=dist;
				}
			}
			
			if(go()) {
				System.out.println("happy");
			}else {
				System.out.println("sad");
			}
			
		}
		
		
	}
	
	static class Node{
		int cn, sum;
		Node(int cn, int sum){
			this.cn = cn;
			this.sum=sum;
		}
	}
}
