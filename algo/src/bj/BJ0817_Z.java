package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ0817_Z {
	static void rec(int cx,int cy, int n, int cnt) { 
		if(n==1) {
			cnt+=cx;
			cnt+=2*cy;
			answer=cnt;
			return;
		}
		int nn=(int)Math.pow(2,n)*(int)Math.pow(2,n); //2^n * 2^n
		int nn4=nn/4,w=(int)Math.pow(2, n-1);  //1/4크기, 변의 길이/2
		int nx,ny;
		
		if(cx>=w) cnt+=nn4;
		if(cy>=w) cnt+=2*nn4;
		nx=cx%w;
		ny=cy%w;
		rec(nx,ny,n-1,cnt);
	}

	static int N,sx,sy,answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn=new StringTokenizer(br.readLine());
		N=Integer.parseInt(stn.nextToken());
		sy=Integer.parseInt(stn.nextToken());
		sx=Integer.parseInt(stn.nextToken());
		rec(sx,sy,N,0);
		
		System.out.println(answer);
	}

}
