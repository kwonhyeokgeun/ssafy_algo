package ea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EA0823_서로소_집합 {
	
	static int find(int n) { //root찾기
		if(root[n]==n) {
			return n;
		}else {
			return root[n]=find(root[n]);
		}
	}
	
	static void union(int n1, int n2) { //합치기
		int r1=find(n1);
		int r2=find(n2);
		if(r1==r2) return;
		if(r1>r2) {
			root[r1]=r2;
			root[n1]=r2;
		}else {
			root[r2]=r1;
			root[n2]=r1;
		}
		
	}
	static int check(int n1, int n2) { //root가 같은지 확인
		int r1=find(n1);
		int r2=find(n2);
		if(r1==r2) return 1;
		return 0;
	}

	static int N,M;
	static int[] root;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn;
		StringBuffer sb = new StringBuffer();
		int T=Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			stn=new StringTokenizer(br.readLine());
			N=Integer.parseInt(stn.nextToken());
			M=Integer.parseInt(stn.nextToken());
			root=new int[N+1];
			for(int i=1; i<=N;i++) {
				root[i]=i;
			}
			sb.append("#"+tc+" ");
			
			for(int __=0; __<M; __++) {
				stn=new StringTokenizer(br.readLine());
				int tp=Integer.parseInt(stn.nextToken());
				int n1=Integer.parseInt(stn.nextToken());
				int n2=Integer.parseInt(stn.nextToken());
				if(tp==0) { //합치기
					union(n1,n2);
				}else { //확인
					sb.append(check(n1,n2));
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

}
