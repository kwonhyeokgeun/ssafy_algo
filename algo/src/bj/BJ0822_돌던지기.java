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
			if(mat[cy+1][cx]=='X') { //아래가 막혓으면 
				mat[cy][cx]='O';
				return;
			}
			else if(mat[cy+1][cx]=='.') { //아래가 뚫렸으면
				cy++;
			}
			else { //아래가 화산탄이면
				if(cx!=0 && mat[cy][cx-1]=='.' && mat[cy+1][cx-1]=='.') { //왼쪽으로 갈 수 있음.
					cx--;
					cy++;
				}else if(cx!=w-1 && mat[cy][cx+1]=='.' && mat[cy+1][cx+1]=='.') { //오른쪽 갈 수 있음
					cx++;
					cy++;
				}else { //왼쪽 오른쪽 다막힘
					mat[cy][cx]='O';
					return;
				}
			}
		}
		
		mat[cy][cx]='O';
	}
	
	static int h,w,N;
	static char mat[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn = new StringTokenizer(br.readLine());
		StringBuffer sb= new StringBuffer();
		h=Integer.parseInt(stn.nextToken()); //y높이
		w=Integer.parseInt(stn.nextToken()); //x넓이
		mat=new char[h][w];
		for(int y=0; y<h; y++) {
			String row=br.readLine();
			mat[y]=row.toCharArray();
		}
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
				sb.append(mat[y][x]);
			}sb.append("\n");
		}
		
		System.out.println(sb);
		
	}
}

