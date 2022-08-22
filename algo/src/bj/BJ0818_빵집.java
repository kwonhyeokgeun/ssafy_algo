package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ0818_빵집 {

	static void count(int x, List<Integer> ys) {
		if(x==w-1) {
			answer=ys.size();
			return;
		}
		if(ys.size()==0) return;
		int nx,ny;
		List<Integer> nys= new ArrayList<>();
		for(int y:ys) { //파이프 y위치
			nx=x+1;
			for(int dr=0; dr<3; dr++) {  //위에서 부터 방향순대로 채워나감
				ny=y+dirs[dr];
				if(ny<0 || ny>= h) continue; 
				if( mat[ny][nx]) continue;//벽이거나 이미 파이프있음
				mat[ny][nx]=true;
				nys.add(ny);
				break; //한 파이프당 최대 하나만
			}
		}
		count(x+1,nys);
	}
	
	static int h,w,answer;
	static int[] dirs= {-1,0,1};
	static boolean[][] mat;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn = new StringTokenizer(br.readLine());
		h=Integer.parseInt(stn.nextToken());
		w=Integer.parseInt(stn.nextToken());
		mat=new boolean[h][w];
		answer=0;

		for(int y=0; y<h; y++) {
			String row=br.readLine();
			for(int x=0; x<w; x++) {
				if (row.charAt(x)=='x') {
					mat[y][x]=true;
				}
			}
		}
		List<Integer> ys= new ArrayList<>();  //생존한 파이프들의 y위치
		for(int y=0; y<h; y++) {
			if(!mat[y][0])
				ys.add(y);
		}
		count(0,ys);
		System.out.println(answer);
	}
	
}
