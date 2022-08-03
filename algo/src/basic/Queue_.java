package basic;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Queue_ {

	public static void main(String[] args) {
		Queue<Integer> que = new LinkedList<>(); //int형 queue 선언
		que.add(1);     // 값 1 추가
		que.add(2);     // 값 2 추가
		que.offer(3);   // 값 2 추가
		System.out.println(que.peek()); //1
		System.out.println(que);  //[1, 2, 3]
		System.out.println(que.poll());  //1
		System.out.println(que);  //[2, 3]
		System.out.println(Arrays.toString(que.toArray()));  //[2, 3]
		

	}


}
