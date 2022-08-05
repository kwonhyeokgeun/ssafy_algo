package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ0805_회전초밥 {
	
	static public int check() {
		if(set.contains(C)) return set.size();
		else return set.size()+1;
	}
	
	
	static int N,D,K,C; //접시수, 초밥수, 연속 먹기, 쿠폰번호
	static int[] lst;
	static Set<Integer> set=new HashSet<>();
	static int[] nums;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn = new StringTokenizer(br.readLine());
		N=Integer.parseInt(stn.nextToken());
		D=Integer.parseInt(stn.nextToken());
		K=Integer.parseInt(stn.nextToken());
		C=Integer.parseInt(stn.nextToken());
		lst=new int[N];
		nums=new int[D+1];
		for(int i=0;i<N;i++) {
			lst[i]=Integer.parseInt(br.readLine());
		}
		int num,answer=0;
		for(int i=0; i<K;i++) {
			num=lst[i];
			set.add(num);
			nums[num]++;
		}
		answer=Math.max(answer, check());
		for(int i=1; i<N; i++) {
			int j=(i+K-1)%N;
			int minus=lst[i-1];
			if(nums[minus]==1) {
				nums[minus]=0;
				set.remove(minus);
			}
			else 
				nums[minus]--;
			
			int plus=lst[j];
			nums[plus]++;
			set.add(plus);
			
			answer=Math.max(answer, check());
		}
		System.out.println(answer);
		

	}

}
