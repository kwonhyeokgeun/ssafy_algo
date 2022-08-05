package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class BJ0805_탑 {
	
	static public void print() {
		for(Integer[] v : stack) {
			System.out.printf(Arrays.toString(v)+" ");
		}System.out.println();
	}
	
	static public int N;
	static public Deque<Integer[]> stack;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N= Integer.parseInt(br.readLine());
		
		StringTokenizer stn = new StringTokenizer(br.readLine());

		stack=new ArrayDeque<>();  //[높이, 인덱스]
		for(int i=0;i<N;i++) {
			
			int num=Integer.parseInt(stn.nextToken());
			//System.out.println("num:"+num);
			//print();
			if(stack.isEmpty()) {  //비었으면 추가
				sb.append(0).append(" ");
				stack.add(new Integer[] {num,i+1});
				continue;
			}
			if(stack.peekLast()[0]>=num) {  //i번째가 stack 마지막보다 작으면
				sb.append(stack.peekLast()[1]).append(" ");
				stack.add(new Integer[] {num,i+1});
			}
			else {  //i번째가 stack 마지막보다 크면
				while(!stack.isEmpty()) {
					if (stack.peekLast()[0]>=num) { //i번째보다 큰게 나오면
						sb.append(stack.peekLast()[1]).append(" ");
						stack.add(new Integer[] {num,i+1});
						break;
					}else { //i번째보다 큰게 나올때까지 pop
						stack.pollLast();
					}
				}
				if(stack.isEmpty()) { //i번째보다 큰게없으면
					sb.append(0).append(" ");
					stack.add(new Integer[] {num,i+1});
					
				}
			}
			
		}
		System.out.println(sb);
		

	}

}
