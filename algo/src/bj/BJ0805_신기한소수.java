package bj;

import java.util.Scanner;

public class BJ0805_신기한소수 {

	static public boolean is_prime(int num) {
		if (num<2) return false;
		for(int i=2; i<=Math.sqrt(num);i++) {
			if(num%i==0) {
				return false;
			}
		}
		return true;
	}
	
	static public void rec(int num, int idx) {
		int num2;
		if(idx==N) {
			System.out.println(num);
			return;
		}
			
		for(int i=0; i<10; i++) {
			num2=num*10 +i;
			if (is_prime(num2) ){
				rec(num2,idx+1);
			}
		}
	}
	
	static public int N,idx, s, e;
	//static public boolean[] lst;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		
		rec(2,1);
		rec(3,1);
		rec(5,1);
		rec(7,1);

		
	}

}
