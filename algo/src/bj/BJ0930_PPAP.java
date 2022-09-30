package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BJ0930_PPAP {
	
	static String rec(String st) {
		int ai=st.indexOf('A');
		if(ai<=1 || ai+1>=st.length()) return st;
		if(st.charAt(ai-1)=='P') {
			if(st.charAt(ai-2)=='P' && st.charAt(ai+1)=='P') {
				//System.out.println(st.substring(0, ai-1)+st.substring(ai+2));
				return rec(st.substring(0, ai-1)+st.substring(ai+2));
			}
		}else {
			return st;
		}
		return st;
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String ppap=br.readLine();
		if(ppap.length()<3 || (ppap.length()==4 && !ppap.equals("PPAP"))) {
			System.out.println("NP");
		}else {
			String answer=rec(ppap);
			if(answer.equals("P")) {
				System.out.println("PPAP");
			}else {
				System.out.println("NP");
			}
		}
		
	}
}
