package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ0816_설탕배달 {
	
	static void cal() {
		answer=-1;
		int n5=N/5;
		for(int i=n5; i>=0; i--) {
			int l=N-5*i;
			if(l%3==0) {
				answer=i+l/3;
				return;
			}
		}
	}
	static int N,answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		cal();
		System.out.println(answer);
	}
}
