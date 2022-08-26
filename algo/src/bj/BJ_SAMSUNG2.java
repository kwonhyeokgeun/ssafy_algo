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
//감소하는 수
public class BJ_SAMSUNG2 {
	
	static void search(int f, int e, int r) {//첫자리 수, 자릿수, 나머지
		if(e>10) { //자릿수 10 넘음
			System.out.printf("f:%d, e:%d, r:%d\n",f,e,r);
			F=-1;
			answer=-1;
			return;
		}
		
		if(f<e) {  //100같이 진행 할게 없는 경우
			System.out.printf("f:%d, e:%d, r:%d\n",f,e,r);
			if(f==9) { //첫째수가 9
				search(1,e+1,r); //자릿수 증가
			}else {
				System.out.println("!!");
				search(f+1,e,r); //첫째수 증가
			}
		}
		else {
			int num=C(f,e); //f와 e일때 가능한 경우의 수
			System.out.printf("f:%d, e:%d, r:%d, num:%d\n",f,e,r,num);
			if(r-num<0) { //끝
				F=f; E=e; R=r;
				System.out.println("끝");
				return;
			}else {
				if(f==9) {
					search(1,e+1,r-num);
				}else {
					System.out.println("!!!");
					search(f+1,e,r-num);
				}
			}
		}
	}

	static int C(int f, int e) {
		int ret=1;
		e=Math.min(e, f-e);
		for(int i=0; i<e; i++) {
			ret*=(f-i);
		}
		for(int i=2; i<=e;i++) {
			ret/=i;
		}
		return ret;
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
	
	static int N;
	static long answer;
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
