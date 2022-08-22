package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BJ0818_쿼드트리 {
	
	static int isSame(int n2,int sx, int sy,int i, int j) { //사각형에 같은 숫자만 있는지
		int tp=mat[sy+i*n2][sx+j*n2];
		for(int y=i*n2; y<(i+1)*n2; y++) {
			for(int x=j*n2; x<(j+1)*n2;x++) {
				if(mat[sy+y][sx+x]!=tp) {
					return -1;
				}
			}
		}
		return tp;
	}

	static void rec(int n, int sx, int sy) { //한변 길이, 윈쪽위 좌표
		int n2=n/2;
		//System.out.printf("n:%d sx:%d sy:%d\n",n,sx,sy);
		answer.append("(");
		for(int i=0; i<2; i++) {
			for(int j=0;j<2;j++) {
				int type=isSame(n2,sx,sy,i,j);
				if(type!=-1) { //모두 같은 값
					answer.append(type);
				}else {  //다른 값이 있으면 재귀
					rec(n/2,sx+j*n2,sy+i*n2);
				}
			}
		}answer.append(")");
	}
	
	static int N;
	static int[][] mat;
	static StringBuilder answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		mat=new int[N][N];
		for(int y=0; y<N; y++) {
			String row=br.readLine();
			for(int x=0; x<N; x++) {
				mat[y][x]=row.charAt(x)-'0';
			}
		}
		
		int tp=mat[0][0];
		boolean is_answer=true;
		for(int y=0; y<N; y++) { //모두가 같은지 체크
			for(int x=0; x<N; x++) {
				if(mat[y][x]!=tp) is_answer=false;
			}
		}
		
		if(is_answer) { //모두 같음
			System.out.println(tp);
		}
		else { //모두 같지 않다면 4개로 나눠서 체크해 나감
			answer =new StringBuilder();
			rec(N,0,0);
			System.out.println(answer);
		}
	}

}

