package basic;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Stack_ {

	public static void main(String[] args) {
		//stack은 vector를 extends한거라서 무거운 편이다 그래서 ArrayDeque나 deque을 쓰는걸 추천하는 듯
		//Deque<Integer> stack = new ArrayDeque();
		
		Stack<String> stack = new Stack<>();
		stack.push("0");
		stack.push("1");
		stack.push("2");
		System.out.println(stack.get(2));
		System.out.println(stack);
	}

}
