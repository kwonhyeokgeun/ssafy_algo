package ea;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class EA0809_암호문1 {

	public static int N,M;
	public static List<String> code;
	public static String[] order;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn;
		StringTokenizer stn2;
		int T=10;
		for(int tc=1; tc<=T; tc++) {
			N=Integer.parseInt(br.readLine());
			code=new ArrayList<>();
			stn=new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				code.add(stn.nextToken());
			}
			//System.out.println(code);
			M=Integer.parseInt(br.readLine());
			stn=new StringTokenizer(br.readLine());
			int idx;
			int n;
			for(int __=0; __<M; __++) {
				stn2=new StringTokenizer(stn.nextToken("I"));
				idx=Integer.parseInt(stn2.nextToken());
				n=Integer.parseInt(stn2.nextToken());
				String st;
				for(int i=0;i<n;i++) {
					st=stn2.nextToken();
					code.add(idx++,st);
					//System.out.println(st);
				}
				//System.out.println(code);
				
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#"+tc+" ");
			for(int i=0;i<10;i++) {
				sb.append(code.get(i)).append(" ");
			}
			System.out.println(sb);
		}

	}

}
