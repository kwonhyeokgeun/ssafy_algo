package basic;

import java.util.PriorityQueue;

public class PriorityQueue_ {

	public static void main(String[] args) {
		PriorityQueue<Item> hp = new PriorityQueue<>();
		hp.add(new Item(3,3));
		hp.add(new Item(3,2));
		hp.add(new Item(3,4));
		hp.add(new Item(1,3));
		for(int i=0; i<4; i++){
			Item ci=hp.poll();
			System.out.print(ci+" ");
		}
	}
	
	static class Item implements Comparable<Item>{
		int x,y;
		public Item(int x,int y){
			this.x=x;
			this.y=y;
		}
		public int compareTo(Item o) { //x오름차순, y오름차순
			return this.x==o.x? this.y-o.y : this.x-o.y;
		}
		@Override
		public String toString() {
			return "[x=" + x + ", y=" + y + "]";
		}
		
	}

}
