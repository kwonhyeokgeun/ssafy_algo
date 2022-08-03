package ea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EA0803_상호의배틀필드 {
	
	public static void print() {
		for(int y=0; y<h;y++) {
			for(int x=0;x<w;x++) {
				System.out.print(mat[y][x]+" ");
			}System.out.println();
		}
		System.out.println(cx +" "+cy+" "+dr);
		System.out.println("=================");
	}
	public static void move(char order) {
		if(order=='U') {
			dr=3;
			if(cy>0) {
				if(mat[cy-1][cx]=='.') 
					cy--;
			}
		}else if(order=='D') {
			dr=1;
			if(cy<h-1) {
				if(mat[cy+1][cx]=='.')
					cy++;
			}
		}else if(order=='L') {
			dr=2;
			if(cx>0) {
				if(mat[cy][cx-1]=='.') 
					cx--;
			}
		}else if(order=='R') {
			dr=0;
			if(cx<w-1) {
				if(mat[cy][cx+1]=='.') 
					cx++;
			}
		}else if(order=='S') {
			int px=cx,py=cy;
			while(true) {
				px+=dirs[dr][0];
				py+=dirs[dr][1];
				if(px<0 || py<0 || px>=w || py>=h) break;
				if(mat[py][px]=='#') break;
				else if(mat[py][px]=='*') {
					mat[py][px]='.';
					break;
				}
			}
		}
		
	}
	
	static public int h,w,cx,cy,dr;
	static public int [][]dirs= {{1,0},{0,1},{-1,0},{0,-1}};
	static public char[][] mat;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T= Integer.parseInt(br.readLine());
		StringTokenizer tk;
		for(int tc=1; tc<=T; tc++) {
			tk= new StringTokenizer(br.readLine());
			h=Integer.parseInt(tk.nextToken());
			w=Integer.parseInt(tk.nextToken());
			//System.out.println(h+" "+w);
			mat = new char[h][w];
			
			for(int y=0; y<h; y++) {
				String row=br.readLine();
				for(int x=0; x<w; x++) {
					char elm=row.charAt(x);
					if(elm=='^') {
						cx=x;
						cy=y;
						dr=3;
						mat[y][x]='.';
					}
					else if(elm=='v'){
						cx=x;
						cy=y;
						dr=1;
						mat[y][x]='.';
					}else if(elm=='<'){
						cx=x;
						cy=y;
						dr=2;
						mat[y][x]='.';
					}
					else if(elm=='>'){
						cx=x;
						cy=y;
						dr=0;
						mat[y][x]='.';
					}
					else {
						mat[y][x]=elm;
					}
				}
			}
			//System.out.println(cx+" "+cy+" "+dr);
			int N=Integer.parseInt(br.readLine());
			String row=br.readLine();
			for(int i=0; i<N; i++) {
				char order=row.charAt(i);
				move(order);
				//System.out.println(order);
				//print();
				
			}
			if (dr==0)
				mat[cy][cx]='>';
			else if(dr==1)
				mat[cy][cx]='v';
			else if(dr==2)
				mat[cy][cx]='<';
			else
				mat[cy][cx]='^';
			System.out.printf("#%d ",tc);
			for(int y=0; y<h; y++) {
				for(int x=0; x<w; x++) {
					System.out.print(mat[y][x]);
				}
				System.out.println();
			}
		}
		
			
	}

}
