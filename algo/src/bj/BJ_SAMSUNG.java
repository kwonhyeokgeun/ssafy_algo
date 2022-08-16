package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_SAMSUNG {
	
	static void work() {
		cnt=0;
		
		int cx=sx, cy=sy,nx,ny,ndr;
		while(trash!=cnt) {
			if(mat[cy][cx]==0) { //1번과정
				mat[cy][cx]=3;
				cnt++;
			}
			/*System.out.println(cx+" "+cy+" "+dr+" "+cnt);
			for(int yy=0;yy<h;yy++) {
				System.out.println(Arrays.toString(mat[yy]));
			}System.out.println();*/
			boolean can_clear=false;
			for(int i=0; i<4; i++) { //4방향체크
				dr=Math.floorMod(dr-1, 4);
				nx=cx+dirs[dr][0];
				ny=cy+dirs[dr][1];
				if(nx<0 ||ny<0 ||nx>=w || ny>=h) continue;
				if(mat[ny][nx]==1) continue;
				if(mat[ny][nx]==0) {
					cx=nx; cy=ny;
					can_clear=true;
					break;
				}
			}
			if(can_clear==false) { //후진하기
				ndr=(dr+2)%4;
				nx=cx+dirs[ndr][0];
				ny=cy+dirs[ndr][1];
				if(nx<0 ||ny<0 ||nx>=w || ny>=h) return;
				if(mat[ny][nx]==1) return;
				cx=nx;cy=ny;
			}
			
		}
	}
	
	static int h,w,sx,sy, dr;
	static int [][]mat;
	static int trash,cnt;
	static int [][]dirs= {{0,-1},{1,0},{0,1},{-1,0}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn;
		stn=new StringTokenizer(br.readLine());
		h=Integer.parseInt(stn.nextToken());
		w=Integer.parseInt(stn.nextToken());
		stn=new StringTokenizer(br.readLine());
		sy=Integer.parseInt(stn.nextToken());
		sx=Integer.parseInt(stn.nextToken());
		dr=Integer.parseInt(stn.nextToken());
		mat=new int[h][w];
		for(int y=0; y<h; y++) {
			stn=new StringTokenizer(br.readLine());
			for(int x=0; x<w;x++) {
				mat[y][x]=Integer.parseInt(stn.nextToken());
				if(mat[y][x]==0) trash++;
			}
		}
		
		
		work();
		System.out.println(cnt);
	
		 
		 
		 
		 
		 
				
	}
	
}
