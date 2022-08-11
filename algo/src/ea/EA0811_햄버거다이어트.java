package ea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EA0811_햄버거다이어트 {
	
	static void comb(int idx, int ts, int tc) { //인덱스, 총점, 총칼로리
		if (idx==N) { //모두 추가됨
			answer=Math.max(answer, ts);
			return;
		}
		for(int i=idx; i<N; i++) {
			if(tc+lst[i][1]>limit) { //칼로리 초과시
				answer=Math.max(answer, ts);
				continue;
			}
			
			comb(i+1,ts+lst[i][0],tc+lst[i][1]);
			
		}
		
	}

	static int N,limit;
	static int answer;
	static int[][] lst;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader( System.in));
		StringTokenizer stn;
		int T=Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			stn=new StringTokenizer(br.readLine());
			N=Integer.parseInt(stn.nextToken());
			limit=Integer.parseInt(stn.nextToken());
			answer=0;
			lst= new int[N][2];
			
			for(int ji=0; ji<N; ji++) {
				stn=new StringTokenizer(br.readLine());
				lst[ji][0]=Integer.parseInt(stn.nextToken());//점수
				lst[ji][1]=Integer.parseInt(stn.nextToken());//칼로리
			}
			
			comb(0,0,0);
			System.out.printf("#%d %d\n",tc,answer);
		}
	}

}
