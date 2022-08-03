package basic;

import java.util.Stack;

public class Stack_ {

	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();
		stack.push("0");
		stack.push("1");
		stack.push("2");
		System.out.println(stack.get(2));
		System.out.println(stack);
	}

}
