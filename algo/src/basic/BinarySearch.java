package basic;

import java.util.Arrays;

public class BinarySearch {

	public static void main(String[] args) {
		int[] input= {1,5,7,10,13};
		//못찾은 경우 음수가 나오는데 대충 구간을 음수로 알려줌
		
		System.out.println(Arrays.binarySearch(input, 1)); //0 
		System.out.println(Arrays.binarySearch(input, 4)); //-2  //못찾았을때 
		System.out.println(Arrays.binarySearch(input, 8)); //-4
		System.out.println(Arrays.binarySearch(input, 0)); //-1
		
		//{      1,     5,     7,     10,     13}   value
		//       0      1      2       3       4    index
		//   -1    -2     -3      -4      -5   //못찾은 경우 음수로 위치를 알려줌
		
		System.out.println(Arrays.binarySearch(input, 0, 3, 12)); //-4 나옴, 0~2 중 12를 찾음
		//{      1,     5,     7,              }   value
		//       0      1      2       		       index
		//   -1    -2     -3      -4             //뒤에거는 날림
		
		System.out.println(Arrays.binarySearch(input, 2, 4, 8));  //-4나옴		
		//{       ,      ,      7,     10,      }   value
		//       0      1      2       3            index
		//   -1    -2     -3      -4         -5   //앞에거는 살림
	}

}
