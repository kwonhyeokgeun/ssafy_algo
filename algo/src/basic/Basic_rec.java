package basic;

public class Basic_rec {

	public static void main(String[] args) {
		m2();
	}
	static int m1_cnt;
	static void m1() {
//		{
//			int i=10;
//			System.out.println("m1 i : "+i++);
//			m1();
//		}
		
		{
			System.out.println("m1 : m1_cnt : "+m1_cnt++);
			m1();
		}
	}
	
	static int m2_cnt=5;
	static void m2() {
		System.out.println("1 : m2_cnt : "+m2_cnt);
		if(m2_cnt>0) {
			m2_cnt--;
			m2();
		}
		System.out.println("2 : m2_cnt : "+m2_cnt);
	}
	

}
 