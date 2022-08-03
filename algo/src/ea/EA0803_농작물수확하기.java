package ea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EA0803_농작물수확하기 {
	static public int dist(int x, int y, int s) {
		return Math.abs(x-s)+Math.abs(y-s);
	}
	
	static public int cal() {
		int s=N/2;
		int answer=0;
		for(int y=0; y<N; y++) {
			for(int x=0; x<N; x++) {
				if(dist(x,y,s)<=s) {
					answer+=mat[y][x];
				}
			}
		}
		return answer;
	}
	
	
	static int N;
	static int[][] mat;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader( System.in));
		int T= Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			N= Integer.parseInt(br.readLine());
			mat=new int[N][N];
			
			for(int y=0; y<N; y++) {
				String row=br.readLine();
				//System.out.println(row);
				for(int x=0; x<N; x++) {
					mat[y][x]= row.charAt(x)-'0';
				}
			}
			
			int answer=cal();
			System.out.printf("#%d %d\n",tc, answer);
		}

	}

}
