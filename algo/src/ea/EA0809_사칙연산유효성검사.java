package ea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;



public class EA0809_사칙연산유효성검사 {

	public static int check() {
		//if(N%2==1) return 0;
		int mi;
		que.add(1);
		while(!que.isEmpty()) {
			mi=que.pollFirst();
			if(mi*2>N) {  //리프노드이면
				if(tree[mi]==-1) { //op라면
					return 0;
				}
			}else {
				if(tree[mi]!=-1) { //숫자라면
					return 0;
				}
				else {
					que.add(mi*2);
					que.add(mi*2+1);
				}
			}
		}
		return 1;
	}
	
	public static int N;
	public static int[] tree;
	public static Deque<Integer> que;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn;
		int T=10;
		for(int tc=1;tc<=T;tc++) {
			N=Integer.parseInt(br.readLine());
			
			tree=new int[N+1];
			que=new ArrayDeque<>();
			for(int i=1; i<=N; i++) {
				stn= new StringTokenizer(br.readLine());
				stn.nextToken();
				String op=stn.nextToken();
				
				int op2 =op.charAt(0)-'0';
				if(op2 >=0 && op2<=9) {
					tree[i]=op2;  //숫자
				}else {
					tree[i]=-1;   //op
				}
			}
			
			
			int answer=check();
			System.out.printf("#%d %d\n",tc,answer);
			
		}
		
	}

}
