package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ0822_돌던지기 {
	
	static void goDown(int idx) {
		int cx=idx; //화산탄 x
		int cy=0;    //화산탄 y
		while (cy<h-1) {
			if(mat[cy+1][cx]==-1) { //아래가 'X'면
				int check=mat[cy][cx];
				mat[cy][cx]=-2; //'O'
				for(int y=cy-1; y>=0; y--) { //dp 최신화
					if(mat[y][cx]==check) {
						mat[y][cx]=check-1;
					}else {
						break;
					}
				}
				return;
			}
			else if(mat[cy+1][cx]>=0) { //아래가 뚫렸으면
				cy=mat[cy][cx]-1;
			}
			else { //아래가 'O'면
				if(cx!=0 && mat[cy][cx-1]>=0 && mat[cy+1][cx-1]>=0) { //왼쪽으로 갈 수 있음.
					cx--;
					cy=mat[cy][cx]-1;
				}else if(cx!=w-1 && mat[cy][cx+1]>=0 && mat[cy+1][cx+1]>=0) { //오른쪽 갈 수 있음
					cx++;
					cy=mat[cy][cx]-1;
				}else { //왼쪽 오른쪽 다막힘
					int check=mat[cy][cx];
					mat[cy][cx]=-2; //'O'
					for(int y=cy-1; y>=0; y--) { //dp 최신화
						if(mat[y][cx]==check) {
							mat[y][cx]=check-1;
						}else {
							break;
						}
					}
					return;
				}
			}
		}
		
		//제일 밑까지 굴러 떨어진 경우
		int check=mat[cy][cx];
		mat[cy][cx]=-2; //'O'
		for(int y=cy-1; y>=0; y--) { //dp 최신화
			if(mat[y][cx]==check) {
				mat[y][cx]=check-1;
			}else {
				break;
			}
		}
		
	}
	
	static int h,w,N;
	static int mat[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn = new StringTokenizer(br.readLine());
		StringBuffer sb= new StringBuffer();
		h=Integer.parseInt(stn.nextToken()); //y높이
		w=Integer.parseInt(stn.nextToken()); //x넓이
		mat=new int[h][w];
		for(int y=0; y<h; y++) {
			String row=br.readLine();
			for(int x=0; x<w; x++) {
				if(row.charAt(x)=='X') {
					mat[y][x]=-1;
				}
			}
		}
		for(int x=0; x<w; x++) {
			int p=h;
			for(int y=h-1; y>=0; y--) {
				if(mat[y][x]==-1) {
					p=y;
				}else {
					mat[y][x]=p;
				}
			}
		}
		/*for(int y=0; y<h; y++) {
			System.out.println(Arrays.toString(mat[y]));
		}System.out.println();*/
		
		N=Integer.parseInt(br.readLine());
		for(int __=0; __<N; __++) {
			int idx=Integer.parseInt(br.readLine())-1; //화산탄 x축 좌표
			goDown(idx); //굴러떨어짐
			
			/*for(int y=0; y<h; y++) {
				System.out.println(Arrays.toString(mat[y]));
			}System.out.println();*/
		}
		
		for(int y=0; y<h; y++) {
			for(int x=0; x<w; x++) {
				if(mat[y][x]==-2)
					sb.append('O');
				else if(mat[y][x]==-1)
					sb.append('X');
				else {
					sb.append('.');
				}
			}sb.append("\n");
		}
		
		System.out.println(sb);
		
	}
}

