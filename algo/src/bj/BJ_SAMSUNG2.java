package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ_SAMSUNG2 {
	
	static void search(int f, int e, int r) {//첫자리 수, 자릿수, 나머지
		if(e>9) { //자릿수 10 넘음
			F=-1;
			answer=-1;
			return;
		}
		
		if(f<e) {  //100같이 진행 할게 없는 경우
			int nf=f+1;
			if(nf==10) {
				search(1,e+1,r);
			}else {
				search(nf,e,r);
			}
		}
		else {
			int num=1;
			for(int i=0; i<e; i++) {
				num*=(f-i);
			}
			num/=e;
			if(r-num<0) { //끝
				F=f; E=e; R=r;
				return;
			}else {
				int nf=f+1;
				if(nf==10) {
					search(1,e+1,r-num);
				}else {
					search(nf,e,r-num);
				}
			}
		}
	}

	static void cal() {
		if(F==-1) {
			return;
		}
		
		answer=F*(int)(Math.pow(10, E));
		int[] lst=new int[F];
		for(int i=0; i<F; i++) {
			lst[i]=i;
		}
		int [] idxs=new int[E];
		for(int i=0; i<E;i++) {
			idxs[i]=i;
		}
		for(int i=0; i<R;i++) {
			up(idxs);
		}
		for(int i=0; i<E;i++) {
			answer+=idxs[i]*Math.pow(10, i);
		}
	}
	static void up(int[] idxs) {
		int ui=E-1;
		for(int i=0; i<E-1;i++) {
			if(idxs[i]!=idxs[i+1]-1) { 
				ui=i;
				break;
			}
		}
		
		idxs[ui]+=1;
		for(int i=0; i<ui; i++) {
			idxs[i]=i;
		}
	}
	
	static int N, answer;
	static int F, E, R; //첫자리 수, 자릿수, 나머지
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		if(N<=9) {
			System.out.println(N);
		}else {
			search(1,1,N-10); //10부터 시작
			System.out.println(F+" " +E+" "+R);
			cal();
			System.out.println(answer);
		}
			
	}

	
}
