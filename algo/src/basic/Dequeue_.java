package basic;

import java.util.Deque;
import java.util.LinkedList;

public class Dequeue_ {

	public static void main(String[] args) {
		Deque<Integer> deque = new LinkedList<>();
		deque.addLast(1);
		deque.addLast(2);
		deque.add(3);
		deque.add(4);
		System.out.println(deque);  //[1, 2, 3, 4]
		deque.add(5);   
		System.out.println(deque);  //[1, 2, 3, 4, 5]
		System.out.println(deque.remove());   //1 출력
		System.out.println(deque);   //[2, 3, 4, 5]
		System.out.println(deque.pop());   // 2출력
		System.out.println(deque);   // [3, 4, 5]


	}

}
