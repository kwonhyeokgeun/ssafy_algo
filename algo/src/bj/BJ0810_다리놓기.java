package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ0810_다리놓기 {
	
	public static void cal(int n1, int n2) {
		n1=Math.min(n1, n2-n1);
		
	}
	
	public static int answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer stn;
		int n1,n2;
		for(int tc=1; tc<=T; tc++) {
			stn = new StringTokenizer(br.readLine());
			answer=0;
			n1=Integer.parseInt(stn.nextToken());
			n2=Integer.parseInt(stn.nextToken());
			
			
		}
	}

}
