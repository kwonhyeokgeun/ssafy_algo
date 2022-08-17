package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BJ0817_잃어버린괄호 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String row=br.readLine();
		
		int answer=0;
		int num;
		int s=0; //숫자 시작 인덱스
		boolean is_minus=true; //-가 나왔는가
		for(int i=0; i<row.length();i++) {
			char c=row.charAt(i);
			if(c=='-') { 
				num=Integer.parseInt(row.substring(s,i));
				if (is_minus) answer+=num; //true면 더하고
				else answer-=num;   //false면 뺌
				is_minus=false; //-가 나옴을 표시
				s=i+1;
			}else if(c=='+') {
				num=Integer.parseInt(row.substring(s,i));
				if (is_minus) answer+=num;
				else answer-=num;
				s=i+1;
			}
		}
		
		num=Integer.parseInt(row.substring(s, row.length()));
		if(is_minus) answer+=num;  
		else answer-=num;
		
		System.out.println(answer);
	}

}
