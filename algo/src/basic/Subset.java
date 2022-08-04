package basic;

import java.nio.channels.SelectableChannel;

public class Subset {

	static int[] src = {1,2,3,4,5};
	static boolean[] visited = new boolean[src.length];
	public static void main(String[] args) {
		
		subset(0);
	}
	
	static void subset(int srcIdx) {
		if(srcIdx==src.length) {
			printSubset();
			return;
		}
		visited[srcIdx]=true; //선택
		subset(srcIdx+1); //다음 선택
		
		visited[srcIdx]=false; //비선택
		subset(srcIdx+1); //다음 선택
	}
	
	static void printSubset() {
		for(int i=0; i<visited.length;i++) {
			if(visited[i]) System.out.print(src[i]+" ");
		}
		System.out.println();
	}

}
