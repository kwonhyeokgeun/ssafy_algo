package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BJ0927_공항 {


	public static int sol() {
		int ans=P;
		for(int i=0; i<P; i++) {
			int p = plains[i];
			int pm=p/1000;
			int pr=p%1000;
			for(int j=pm+1; j<101; j++) {
				airports1000[j]++;  //1000단위 업데이트
				if((j+1)*1000<=airports1000[j]) {
					return i;
				}
			}
			for(int j=pr; j<1000; j++) {
				airports[pm][j]++;  //일단위 업데이트
				if(pm>0) {
					if (airports1000[pm-1]+airports[pm][j] > pm*1000+j) { //현재 일단위 + 바로 앞 1000단위 누적
						return i;
					}
				}else {
					if (airports[pm][j] > j) {
						return i;
					}
				}
			}
			
		}
		
		return ans;
	}
	
	static int G,P;
	static int[] plains;
	static int[][] airports; //100 * 1000, 1단위 가짐
	static int[] airports1000;  //1000단위씩 가짐
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		G=Integer.parseInt(br.readLine());
		P=Integer.parseInt(br.readLine());
		
		plains = new int[P];
		for(int i=0; i<P; i++) {
			plains[i]=Integer.parseInt(br.readLine());
		}
		
		airports=new int[101][1000];
		airports1000=new int[101];
		
		int answer=sol();
		System.out.println(answer);
		
	}
}
