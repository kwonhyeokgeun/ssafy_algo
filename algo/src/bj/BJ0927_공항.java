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
			for(int j=pm; j<101; j++) {
				airports1000[j]++;
				if((j+1)*1000<=airports1000[j]) {
					System.out.println("a : "+i + " "+(j+1)*1000+" " + airports1000[j]);
					return i;
					//asdf
				}
			}
			for(int j=0; j<=pr; j++) {
				airports[pm][j]++;
				if(pm>0) {
					if (airports1000[pm-1]+airports[pm][j] > p) {
						System.out.println("b : "+i + " " + airports1000[pm-1]+airports[pm][j] + " "+p);
						return i;
					}
				}else {
					if (airports[pm][j] > p) {
						System.out.println("c : "+i + " " + airports[pm][j] + " "+p);
						return i;
					}
				}
			}
			
		}
		
		return ans;
	}
	
	static int G,P;
	static int[] plains;
	static int[][] airports;
	static int[] airports1000;
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
