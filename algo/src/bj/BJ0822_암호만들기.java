package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;



public class BJ0822_암호만들기 {
	
	static void comb(int idx, int aeiou, int l) {//lst의 인덱스, 모음 수, 조합 길이
		
		if(l==L) {
			if(aeiou>0 && L-aeiou>=2) { //모음1개이상, 자음 2개이상
				for(int i=0; i<L; i++) {
					sb.append(lst[visited[i]]);
				}sb.append("\n");
			}
			return;
		}
		for(int i=idx; i<=C-L+l; i++) {
			visited[l]=i;
			if(lst[i]=='a'||lst[i]=='e'||lst[i]=='i'||lst[i]=='o'||lst[i]=='u') { //모음인 경우
				comb(i+1,aeiou+1,l+1); //모음수++;
			}else {
				comb(i+1,aeiou, l+1);
			}
			
		}
	}
	
	static int L,C;
	static char[] lst;
	static StringBuffer sb;
	static int[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn = new StringTokenizer(br.readLine());
		sb= new StringBuffer();
		L=Integer.parseInt(stn.nextToken());
		C=Integer.parseInt(stn.nextToken());
		lst=new char[C];
		stn = new StringTokenizer(br.readLine());
		
		for(int i=0; i<C; i++) {
			lst[i]=stn.nextToken().charAt(0);
		}
		Arrays.sort(lst);
		//System.out.println(lst);
		
		visited=new int[L];
		comb(0,0,0);
		System.out.println(sb);
	}
}
