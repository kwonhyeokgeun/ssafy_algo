package basic;

import java.util.PriorityQueue;

public class PriorityQueue_2 {

	public static void main(String[] args) {
		PriorityQueue<Integer> hp = new PriorityQueue<>();
		hp.add(5);
		hp.add(1);
		hp.add(2);
		hp.add(7);
		hp.add(5);
		hp.add(4);
		for(Integer v:hp) {
			System.out.print(v+" ");  //1 5 2 7 5 4  //이거는 순서보장안됨
		}System.out.println();
		
		while(!hp.isEmpty()) {
			System.out.print(hp.poll()+" "); //1 2 4 5 5 7 
		}System.out.println();
	}

}
