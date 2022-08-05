package bj;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;


//재귀말고 Stack을 사용한 방식

public class BJ0805_신기한소수2 {

	static public boolean is_prime(int num) {
		if (num<2) return false;
		for(int i=2; i<=Math.sqrt(num);i++) {
			if(num%i==0) {
				return false;
			}
		}
		return true;
	}
	
	static public void find() {
		while(!stack.isEmpty()) {
			Item item=stack.pollLast();
			if(item.idx==N) {
				System.out.println(item.num);
				continue;
			}
			int num;
			for(int i=9; i>=0; i--) {
				num=item.num*10+i;
				if(is_prime(num)) {
					stack.add(new Item(num,item.idx+1));
				}
			}
		}
	}
	
	static public int N,idx;
	static public Deque<Item> stack;;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		stack=new ArrayDeque<>();
		stack.add(new Item(7,1));
		stack.add(new Item(5,1));
		stack.add(new Item(3,1));
		stack.add(new Item(2,1));
		
		find();
		
	}
	
	public static class Item{
		public int num;
		public int idx;
		public Item(int num, int idx) {
			super();
			this.num = num;
			this.idx = idx;
		}
		@Override
		public String toString() {
			return "Item [num=" + num + ", idx=" + idx + "]";
		}
		
		
	}

}
