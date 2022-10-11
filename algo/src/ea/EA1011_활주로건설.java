package ea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EA1011_활주로건설 {
	
	static void buildC(int x) {
		boolean[] builded=new boolean[N];
		for(int y=0; y<N-1;y++) {
			if(mat[y][x]==mat[y+1][x]-1) {
				for(int y2=y; y2>y-l; y2--) {
					if(y2<0)return;
					if(mat[y2][x]==mat[y+1][x]-1) {
						if(builded[y2])return;
						builded[y2]=true;
					}else {
						return;
					}
				}
			}else if(mat[y][x]==mat[y+1][x]+1) {
				for(int y2=y+1; y2<=y+l; y2++) {
					if(y2>=N) return;
					if(mat[y2][x]==mat[y][x]-1) {
						if(builded[y2]) return;
						builded[y2]=true;
					}else {
						return;
					}
						
				}
			}
			else if(mat[y][x]==mat[y+1][x]) {
				continue;
			}
			else
				return;
		}
		answer++;
		
	}
	
	static void buildR(int y) {
		boolean[] builded=new boolean[N];
		for(int x=0; x<N-1;x++) {
			if(mat[y][x]==mat[y][x+1]-1) {
				for(int x2=x; x2>x-l; x2--) {
					if(x2<0)return;
					if(mat[y][x2]==mat[y][x+1]-1) {
						if(builded[x2])return;
						builded[x2]=true;
					}else {
						return;
					}
				}
			}else if(mat[y][x]==mat[y][x+1]+1) {
				for(int x2=x+1; x2<=x+l; x2++) {
					if(x2>=N) return;
					if(mat[y][x2]==mat[y][x]-1) {
						if(builded[x2]) return;
						builded[x2]=true;
					}else {
						return;
					}
						
				}
			}else if(mat[y][x]==mat[y][x+1]) {
				continue;
			}
			else
				return;
		}
		answer++;
		
	}

	static int N,l,answer;
	static int[][] mat;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T= Integer.parseInt(br.readLine());
		StringTokenizer stn;
		for(int tc=1; tc<=T; tc++) {
			stn=new StringTokenizer(br.readLine());
			N=Integer.parseInt(stn.nextToken());
			l=Integer.parseInt(stn.nextToken());
			answer=0;
			mat=new int[N][N];
			for(int y=0; y<N; y++) {
				stn=new StringTokenizer(br.readLine());
				for(int x=0; x<N; x++) {
					mat[y][x]=Integer.parseInt(stn.nextToken());
				}
			}
			for(int i=0; i<N; i++) {
				buildR(i);
				buildC(i);
			}
			
			System.out.printf("#%d %d\n",tc,answer);
		}
	}

}
