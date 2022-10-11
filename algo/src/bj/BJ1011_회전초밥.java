package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1011_회전초밥 {

	static void getNum() {
		int[] counts=new int[D+1]; //해당초밥 갯수
		int count=1;
		counts[C]=1; //쿠폰초밥추가
		for(int i=0; i<K; i++) {
			int cb=lst[i];
			if(++counts[cb]==1) { //초기 세팅 초밥추가
				count++;

			}
		}
		answer=count;

		for(int mi=0; mi<N-1; mi++) {
			int pi=(mi+K)%N;
			int mcb = lst[mi];//빼질 초밥
			int pcb = lst[pi];//더해질 초밥
			
			if(--counts[mcb]==0) {
				count--;
			}
			if(++counts[pcb]==1) {
				count++;
			}
			//System.out.println("mi:"+mi + Arrays.toString(counts) + ", "+count);
			answer=Math.max(answer, count);
		}
	}
	
	static int N,D,K,C,answer;//접시수, 초밥의 가짓수, 연속먹는 수, 쿠폰번호
	static int[] lst;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn = new StringTokenizer(br.readLine());
		N=Integer.parseInt(stn.nextToken());
		D=Integer.parseInt(stn.nextToken());
		K=Integer.parseInt(stn.nextToken());
		C=Integer.parseInt(stn.nextToken());
		lst=new int[N];
		for(int x=0; x<N; x++) {
			lst[x]=Integer.parseInt(br.readLine());
		}
		answer=0;
		getNum();
		System.out.println(answer);

	}

}
