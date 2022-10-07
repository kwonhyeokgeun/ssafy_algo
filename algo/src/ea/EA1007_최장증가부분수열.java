package ea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class EA1007_최장증가부분수열 {

	
	static int T,N,len;
	static int[] input;
	static int[] memoi;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T= Integer.parseInt(br.readLine());
		StringTokenizer stn;
		for(int tc=1; tc<=T; tc++) {
			N= Integer.parseInt(br.readLine());
			input = new int[N];
			memoi = new int[N];
			stn = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				input[i] = Integer.parseInt(stn.nextToken());
			}
			
			len=0;
			for(int i=0; i<N; i++) {
				int pos = Arrays.binarySearch(memoi, 0, len, input[i]);
				pos = Math.abs(pos)-1;
				memoi[pos]=input[i];
				if(len==pos) len++;
			}
			
			System.out.println("#"+tc+" "+len);
					
		}
	}

}
