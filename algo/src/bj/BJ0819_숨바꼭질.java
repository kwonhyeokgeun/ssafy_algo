package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BJ0819_숨바꼭질 {

	static void find() {
		if(si>=ei) {
			answer=si-ei;
			return ;
		}
		Deque<Item> que= new ArrayDeque<>();
		que.add(new Item(si,0));
		while(!que.isEmpty()) {
			Item ci=que.pollFirst();
			int []nis= {ci.i-1,ci.i+1,ci.i*2};
			for(int ni :nis) {
				if(ni==ei) {
					answer=ci.n+1;
					return ;
				}
				if(ni<200003 && ni>=0 && !visited[ni]) {
					que.add(new Item(ni,ci.n+1));
					visited[ni]=true;
				}
			}
			
						
		}
	}
	
	static int si, ei, answer;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn = new StringTokenizer(br.readLine());
		si=Integer.parseInt(stn.nextToken());
		ei=Integer.parseInt(stn.nextToken());
		visited=new boolean[200003];
		answer=0;
		find();
		System.out.println(answer);
		

	}
	static class Item{
		int i,n;
		public Item(int i,int n) {
			this.i=i;
			this.n=n;
		}
		@Override
		public String toString() {
			return "[i=" + i + ", n=" + n + "]";
		}
		
	}
}
