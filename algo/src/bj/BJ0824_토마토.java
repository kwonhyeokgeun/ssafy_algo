package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class BJ0824_토마토 {
	
	static List<Item> go() {
		cnt=0;
		List<Item> ret = new ArrayList<>(); //새로운 1의 xy좌표들
		for(Item ci:lst) { //방금 익은 토마토 주면 익히기
			int x=ci.x;
			int y=ci.y;
			for(int dr=0; dr<4; dr++) {
				int nx=x+dirs[dr][0];
				int ny=y+dirs[dr][1];
				if(nx<0 || ny<0 || nx>=w || ny>=h || mat[ny][nx]!=0) {
					continue;
				}
				mat[ny][nx]=1;
				cnt++; //익은 토마토 수 증가
				cnt0--;  //안익은 토마토수 감소
				ret.add(new Item(nx,ny));
			}
		}
		return ret;
		
	}
	
	
	static int w,h;
	static int[][]mat;
	static int answer, cnt, cnt0;
	static int[][]dirs= {{1,0},{0,1},{-1,0},{0,-1}};
	static List<Item> lst;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn = new StringTokenizer(br.readLine());
		w=Integer.parseInt(stn.nextToken());
		h=Integer.parseInt(stn.nextToken());
		mat=new int[h][w];
		lst=new ArrayList<>();
		for(int y=0; y<h; y++) {
			stn = new StringTokenizer(br.readLine());
			for(int x=0; x<w; x++) {
				mat[y][x]=Integer.parseInt(stn.nextToken());
				if(mat[y][x]==0) cnt0++;
				else if(mat[y][x]==1) lst.add(new Item(x,y));  //1의 위치
			}
		}
		
		
		answer=0;
		if(cnt0!=0) {
			while(true) {
				answer++;
				lst=go();
				if(cnt0==0) { //안익은 토마토 없음
					break;
				}
				if(cnt==0) {  //익힐 수 있는 토마토 없음
					answer=-1;
					break;
				}
			}
		}
		System.out.println(answer);
	}
	
	static class Item{
		int x,y;
		Item(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
}
