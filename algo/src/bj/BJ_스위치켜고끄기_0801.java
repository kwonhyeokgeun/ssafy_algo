package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_스위치켜고끄기_0801 {
	static int N, count;
	static int[] switches;
	static int gender, num;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		switches = new int[N+1]; 
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<N; i++) {
			switches[i] = Integer.parseInt(st.nextToken());
		}
		
		count = Integer.parseInt(br.readLine());
		for(int i=0; i<count; i++) {
			st = new StringTokenizer(br.readLine());
			gender = Integer.parseInt(st.nextToken());
			num = Integer.parseInt(st.nextToken());
			if( gender ==1 ) {
				male();
			}
			else {
				female();
			}
		}
		
		for(int i=1; i<=N; i++) {
			System.out.print(switches[i]);
			if(i!=N) {
				if(i%20==0) {
					System.out.println();
				}else {
					System.out.print(" ");
				}
			}
		}
		
	}
	static void male() {
		for(int i = 1; i<=N; i+=num) {
			switches[i] = switches[i]==0?1:0;
		}
	}
	
	static void female() {
		switches[num] = switches[num]==0?1:0;
		
		int left=num-1;
		int right = num+1;
		while(left>=1 && right<=N) {
			if(switches[left]==switches[right]) {
				switches[left] = switches[left]==0?1:0;
				switches[right] = switches[left];
			}else {
				break;
			}
			left--;
			right++;
		}
	}

}
