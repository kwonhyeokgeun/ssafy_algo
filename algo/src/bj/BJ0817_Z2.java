package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ0817_Z2 {
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

	static int N,r,c,answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn=new StringTokenizer(br.readLine());
		N=Integer.parseInt(stn.nextToken());
		r=Integer.parseInt(stn.nextToken());
		c=Integer.parseInt(stn.nextToken());
		//rec(sx,sy,N,0);
		N=(int)Math.pow(2, N);
		int y=0, x=0;
		while(N>1) {
			N/=2;
			if(r < y + N && c < x + N) {
				;
				x+=N;
			}else if(r < y + N && c >= x + N) {
				answer+=N*N;
				x+=N;
			}else if(r >= y + N && c < x + N) {
				answer+=N*N*2;
				y+=N;
			}else {
				answer+=N*N*3;
				y+=N;
				x+=N;
			}
		}
		
		System.out.println(answer);
	}

}
