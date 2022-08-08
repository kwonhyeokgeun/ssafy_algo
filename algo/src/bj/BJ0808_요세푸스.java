package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ0808_요세푸스 {

	
	public static int N,K;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> arr = new ArrayList<>();
		StringTokenizer stn = new StringTokenizer(br.readLine());
		N=Integer.parseInt(stn.nextToken());
		K=Integer.parseInt(stn.nextToken());
		for(int i=1; i<=N; i++) {
			arr.add(i);
		}
		int cur=0;
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		for(int __=0; __<N; __++) {
			cur=(cur+K-1)%arr.size();
			sb.append(arr.get(cur));
			if(__ !=N-1) sb.append(", ");
			arr.remove(cur);
			
		}
		sb.append(">");
		
		System.out.println(sb);
	}

}
