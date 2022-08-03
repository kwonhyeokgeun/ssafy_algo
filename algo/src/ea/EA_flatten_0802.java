package ea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//https://swexpertacademy.com/main/code/problem/problemDetail.do

public class EA_flatten_0802 {
	static public void dump() {
		int max=0,min=100;
		int maxi=0,mini=0;
		for(int i=0; i<100; i++) {
			if(lst[i]>max) {
				max=lst[i];
				maxi=i;
			}
			if(lst[i]<min) {
				min=lst[i];
				mini=i;
			}
		}
		lst[mini]++;
		lst[maxi]--;
	}
	static public int getAnswer() {
		int max=0,min=100;
		for(int v:lst) {
			if (v>max) max=v;
			if (v<min) min=v;
		}
		return max-min;
	}
	
	static int N;
	static int[] lst;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc=0; tc<10; tc++) {
			N=Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			lst=new int[100];
			for(int i=0; i<100; i++) {
				lst[i]=Integer.parseInt(st.nextToken());
			}
			for(int i=0;i<N; i++) 
				dump();
			int answer=getAnswer();
			System.out.printf("#%d %d\n",tc+1,answer);
		}
	}

}
