package ea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EA0819_최적경로 {
	
	static int getDist(int x1, int y1, int x2, int y2) {
		return Math.abs(x1-x2)+Math.abs(y1-y2);
	}
	
	static void perm(int cx, int cy, int n,int time) {
		if(n==N) {
			answer=Math.min(answer, time+getDist(cx,cy,ex,ey));
			return;
		}
		for(int i=0; i<N; i++) {
			if(visited[i]) continue;
			visited[i]=true;
			int nx=xys[i][0];
			int ny=xys[i][1];
			int time2 = time+getDist(cx,cy,nx,ny);
			if (time2>=answer) {
				visited[i]=false;
				continue;
			}
			perm(nx,ny,n+1, time2);
			visited[i]=false;
		}
	}

	static int N;
	static int[][] xys;
	static int sx,sy,ex,ey,answer;
	static boolean[]visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn;
		StringBuffer sb = new StringBuffer();
		int T=Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			N=Integer.parseInt(br.readLine());
			stn=new StringTokenizer(br.readLine());
			sx=Integer.parseInt(stn.nextToken());
			sy=Integer.parseInt(stn.nextToken());
			ex=Integer.parseInt(stn.nextToken());
			ey=Integer.parseInt(stn.nextToken());
			xys=new int[N][2];
			answer=Integer.MAX_VALUE;
			visited=new boolean[N];
			for(int i=0; i<N; i++) {
				xys[i][0]=Integer.parseInt(stn.nextToken());
				xys[i][1]=Integer.parseInt(stn.nextToken());
			}
			perm(sx,sy,0,0);
			sb.append("#"+tc).append(" "+answer+"\n");
		}
		System.out.println(sb);
	}

}
