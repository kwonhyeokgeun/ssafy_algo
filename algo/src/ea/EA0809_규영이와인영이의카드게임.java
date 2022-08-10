package ea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class EA0809_규영이와인영이의카드게임 {
	public static void rec(int i, int score) {
		if(i==9) {
			if(score>0) {
				win++;
			}else if(score<0) {
				lose++;
			}
			return;
		}
		
		for(int j=0; j<9;j++) {
			if (visited[j]) continue;
			visited[j]=true;
			if(gue[i]>young[j]) {
				rec(i+1,score+gue[i]+young[j]);
			}else if(gue[i]<young[j]) {
				rec(i+1,score-gue[i]-young[j]);
			}else {
				rec(i+1,score);
			}
			visited[j]=false;
		}
		
	}
	
	public static int[] gue, young;
	public static int win, lose;
	public static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn;
		Set<Integer> set;
		
		int T=Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			win=0;
			lose=0;
			gue=new int[9];
			young=new int[9];
			stn=new StringTokenizer(br.readLine());
			set = new HashSet<>();
			
			for(int i=0; i<9; i++) {
				gue[i]=Integer.parseInt(stn.nextToken());
				set.add(gue[i]);
			}
			int j=0;
			for(int i=1; i<=18;i++) {
				if (!set.contains(i))
					young[j++]=i;
			}
			
			visited=new boolean[9];
			rec(0,0);
			System.out.printf("#%d %d %d\n",tc,win,lose);
		}

	}

}
