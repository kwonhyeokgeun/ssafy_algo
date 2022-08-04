package basic;

public class Permutation {
	// 선택하고자 하는 대상 집합.
		static int[] target = new int[] { 1, 2, 3, 4 };
		// 대상 숫자를 선택했는지를 알려주는 집합.
		static boolean[] visited = new boolean[4];
		static int picknum=3;
		public static void main(String[] args) {
			permutation(0, "");
		}

		// 순열 메서드(cnt는 선택 횟수, result는 결과)
		private static void permutation(int cnt, String result) {
			// 3개를 선택했으므로, 결과를 출력하고 재귀를 종료한다.
			if (cnt == picknum) {
				System.out.println(result);
				return;
			}
			// 대상 집합을 순회하며 숫자를 하나 선택한다.
			for (int i = 0; i < target.length; i++) {
				// 이미 해당 숫자를 선택한 경우에는 스킵.
				if (visited[i]) {
					continue;
				}
				// 선택했다는 표시를 해준다.
				visited[i] = true;
				// 자신을 재귀 호출한다.
				permutation(cnt + 1, result + target[i]);
				// 선택을 해제한다.
				visited[i] = false;
			}
		}
}
