package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ0812_절댓값힙 {

	static int N;
	static PriorityQueue<Integer> hp = 
		new PriorityQueue<>( (o1,o2)->Math.abs(o1)==Math.abs(o2)? o1-o2 : Math.abs(o1)-Math.abs(o2) //절댓값기준 오름차순
		);
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn;
		N=Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			int num=Integer.parseInt(br.readLine());
			if(num==0) {
				Integer min= hp.poll();
				System.out.println(min==null?0:min);
			}else {
				hp.add(num);
			}
		}
	}

}
