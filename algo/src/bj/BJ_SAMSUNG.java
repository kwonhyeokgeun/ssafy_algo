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

public class BJ_SAMSUNG {
	static void go(boolean[][] mat) {
		Deque<Item> que =new ArrayDeque<>();
		int mark=mat2mark(mat);
		mem.put(mark, 0);
		que.add(new Item(mark,0));
		int nx,ny;
		while(!que.isEmpty()) {
			//System.out.println(que);
			Item ci=que.pollFirst();
			boolean[][] cmat=mark2mat(ci.mark); //mark로 mat복원
			for(int y=0;y<5; y++) {
				for(int x=0; x<5; x++) {
					if(cmat[y][x]) { //*인 부분
						for(int dr=0; dr<4; dr++) { //옮겨보기
							nx=x+dirs[dr][0];
							ny=y+dirs[dr][1];
							if(nx<0|| ny<0|| nx>=5 || ny>=5) continue;
							if(cmat[ny][nx]) continue;
							cmat[y][x]=false; cmat[ny][nx]=true;
							int nmark=mat2mark(cmat);
							if(mem.containsKey(nmark)) { //이미 옮겨본 위치
								cmat[y][x]=true; cmat[ny][nx]=false;
								continue;
							}
							if(check(cmat,nx,ny)) {//붙어있는지 체크
								answer=ci.num+1;
								return;
							}
							mem.put(nmark, ci.num+1);
							cmat[y][x]=true; cmat[ny][nx]=false;
							que.add(new Item(nmark,ci.num+1));
							
						}
					}
				}
			}
		}
	}
	
	static boolean check(boolean[][] mat, int x,int y) { //다붙어 있는지
		boolean [][]visited= new boolean [5][5];
		Deque<Item> que =new ArrayDeque<>();
		int count=1;
		visited[y][x]=true;
		que.add(new Item(x,y));
		int cx,cy,nx,ny;
		while(!que.isEmpty()) {
			Item ci=que.pollFirst();
			cx=ci.mark; cy=ci.num;
			for(int dr=0; dr<4; dr++) {
				nx=cx+dirs[dr][0];
				ny=cy+dirs[dr][1];
				if(nx<0|| ny<0|| nx>=5 || ny>=5) continue;
				if(visited[ny][nx] || !mat[ny][nx]) continue;
				count++;
				if (stars==count) {
					return true;
				}
				visited[ny][nx]=true;
				que.add(new Item(nx,ny));
			}
		}
		return false;
	}
	static boolean check0(boolean[][] mat) { //0번째에도 붙어있는지
		boolean [][]visited= new boolean [5][5];
		for(int y=0; y<5; y++) {
			for(int x=0; x<5;x++) {
				if(mat[y][x]==true) {
					Deque<Item> que =new ArrayDeque<>();
					int count=1;
					visited[y][x]=true;
					que.add(new Item(x,y));
					int cx,cy,nx,ny;
					while(!que.isEmpty()) {
						Item ci=que.pollFirst();
						cx=ci.mark; cy=ci.num;
						for(int dr=0; dr<4; dr++) {
							nx=cx+dirs[dr][0];
							ny=cy+dirs[dr][1];
							if(nx<0|| ny<0|| nx>=5 || ny>=5) continue;
							if(visited[ny][nx] || !mat[ny][nx]) continue;
							count++;
							if (stars==count) {
								return true;
							}
							visited[ny][nx]=true;
							que.add(new Item(nx,ny));
						}
					}
					
					return false;
				}
			}
		}
		
		return false;
	}
	
	
	static int mat2mark(boolean[][] mat) {  
		int mark=0;
		for(int y=0; y<5; y++) {
			for(int x=0; x<5; x++) {
				if(mat[y][x]) mark|=1;
				mark<<=1;
			}
		}
		return mark;
	}
	static boolean[][] mark2mat(int mark) {
		boolean[][] mat=new boolean[5][5];
		for(int y=4; y>=0; y--) {
			for(int x=4; x>=0; x--) {
				mark>>=1;
				if((mark&1)==1) {
					mat[y][x]=true;
				}
			}
		}
		return mat;
		
	}
	
	
	static int [][]dirs= {{0,-1},{1,0},{0,1},{-1,0}};
	static Map<Integer,Integer> mem;
	static int stars,answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		mem=new HashMap<>();
		stars=0;
		boolean[][] mat=new boolean[5][5];
		for(int y=0; y<5; y++) {
			String row=br.readLine();
			for(int x=0; x<5; x++) {
				if(row.charAt(x)=='*') {
					mat[y][x]=true;
					stars++;
				}
			}
		}
		if(check0(mat)) { //0번째도 다 붙어있다면
			System.out.println(answer);
			return;
		}
		go(mat);
		System.out.println(answer);
		 
		 
		 
		 
		 
				
	}
	static class Item {
		int mark, num;
		public Item(int mark, int num) {
			this.mark=mark;
			this.num=num;
		}
		@Override
		public String toString() {
			return "[mark=" + mark + ", num=" + num + "]";
		}
		
	}
	
}
