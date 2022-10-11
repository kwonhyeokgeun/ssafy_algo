package basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 #1 179
#2 330
#3 48
#4 663822 */
public class Solution {
	static BufferedReader br;
	static BufferedWriter bw;
	static int T;
	static int answer;
	static int N, M, K, C;
	static int[][] arr;
	static int[][] nextTree;
	static int[][] destroyTree;
	static int[][] jechoje;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	// 대각선
	static int[] tx = { -1, -1, 1, 1 };
	static int[] ty = { -1, 1, -1, 1 };

	/*
	 * 5 4 5 5 0 0 0 0 0 0 0 0 -1 1 0 0 5 0 0 4 0 0 0 0 2 0 -1 0 0
	 * 
	 */
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		 bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// T = Integer.parseInt(st.nextToken());

		 //for (int t = 1; t <= T; t++) {
		answer = 0;
		// st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 배열 크기
		M = Integer.parseInt(st.nextToken()); // 박멸이 진행되는 년 수
		K = Integer.parseInt(st.nextToken()); // 제초제의 확산 범위 k(칸)
		C = Integer.parseInt(st.nextToken()); // 제초제가 남아있는 년 수 c

		arr = new int[N + 1][N + 1];
		jechoje = new int[N + 1][N + 1];
		nextTree = new int[N + 1][N + 1];
		destroyTree = new int[N + 1][N + 1];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int m = 0; m < M; m++) {
			// 1.성장
			growth();
			// 2.번식
			spreadTree();

			// 3.박멸
			countDestroy();

			checkJechoje();
			// 4. 나무 그루 확인 및 제초제
			destroy();

			// 5. 제초제 확인
			// int xxx = 1;
		}
		System.out.println(answer);
		 //}
	}

	private static void checkJechoje() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (jechoje[i][j] >= 1) {
					jechoje[i][j]--;
				}
			}
		}
	}

	private static void destroy() {
		System.out.println("제초전");
		for(int i=0; i<N;i++) {
			System.out.println(Arrays.toString(arr[i]));
		}System.out.println();
		for(int i=0; i<N;i++) {
			System.out.println(Arrays.toString(jechoje[i]));
		}System.out.println();
		int x = 0;
		int y = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (destroyTree[i][j] > 0) {
					if (max < destroyTree[i][j]) {
						x = i;
						y = j;
						max = destroyTree[i][j];
					}

				}
			}
		}
		// 제초제 뿌리기
		answer += destroyTree[x][y];
		System.out.println(y+" ,"+x +", "+destroyTree[x][y]);
		arr[x][y] = 0;
		jechoje[x][y] += C;
		for (int k = 0; k < 4; k++) {// 대각선으로
			for (int l = 1; l <= K; l++) {
				int tempx = x + tx[k] * l;
				int tempy = y + ty[k] * l;
				if (!isRange(tempx, tempy))
					break;
				if (arr[tempx][tempy] == 0) {
					jechoje[tempx][tempy] = C;
					break;
				}
				if (arr[tempx][tempy] == -1)
					break;
				if (destroyTree[tempx][tempy] > 0) {
					jechoje[tempx][tempy] = C;
					arr[tempx][tempy] = 0;
				}
			}
		}
		System.out.println("제초후");
		for(int i=0; i<N;i++) {
			System.out.println(Arrays.toString(arr[i]));
		}System.out.println();
		for(int i=0; i<N;i++) {
			System.out.println(Arrays.toString(jechoje[i]));
		}System.out.println("======");
	}

	private static void countDestroy() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] > 0) {
					int sum = arr[i][j];
					for (int k = 0; k < 4; k++) {// 대각선으로
						boolean ch = false;
						for (int l = 1; l <= K; l++) {
							if (!ch) {
								// 확산 범위
								int tempx = i + tx[k] * l;
								int tempy = j + ty[k] * l;
								// 도중 벽이 있거나 나무가 아얘 없는 칸이 있는 경우,
								// 그 칸 까지는 제초제가 뿌려지며 그 이후의 칸으로는 제초제가 전파되지 않습니
								if (isRange(tempx, tempy)) {
									if (arr[tempx][tempy] <= 0) {
										ch = true;
									} else {
										sum += arr[tempx][tempy];
									}
								}
							}
						}
					}
					destroyTree[i][j] += sum;
				}
			}
		}
	}

	private static void spreadTree() {
		nextTree = new int[N + 1][N + 1];
		destroyTree = new int[N + 1][N + 1];
		// 기존에 있었던 나무들은 인접한 4개의 칸 중 벽, 다른 나무, 제초제 모두 없는 칸에 번식을 진행합니다.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] > 0) {
					// 나무일때
					int cnt = 0;
					for (int k = 0; k < 4; k++) {
						int tempx = i + dx[k];
						int tempy = j + dy[k];
						if (isRange(tempx, tempy)) {
							if (arr[tempx][tempy] == 0 && jechoje[tempx][tempy] == 0) {
								// 옆에가 나무거나 벽일때
								cnt++;
							}
						}
					}
					// 각 칸의 나무 그루 수에서 총 번식이 가능한 칸의 개수만큼 나누어진 그루 수만큼 번식이 되며,
					if (cnt > 0) {
						int div = arr[i][j] / cnt;
						for (int k = 0; k < 4; k++) {
							int tempx = i + dx[k];
							int tempy = j + dy[k];
							if (isRange(tempx, tempy)) {
								if (arr[tempx][tempy] == 0 && jechoje[tempx][tempy] == 0) {
									// 아무것도 없을때만
									nextTree[tempx][tempy] += div;
								}
							}
						}
					}

				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (jechoje[i][j] == 0) {
					arr[i][j] += nextTree[i][j];
				}
			}
		}

	}

	private static void growth() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] > 0) {
					// 나무일때
					int cnt = 0;
					for (int k = 0; k < 4; k++) {
						int tempx = i + dx[k];
						int tempy = j + dy[k];
						if (isRange(tempx, tempy) && arr[tempx][tempy] > 0 && jechoje[tempx][tempy] == 0) {
							// 옆에도 나무일때
							cnt++;
						}
					}
					arr[i][j] += cnt;
				}

			}
		}
	}

	private static boolean isRange(int x, int y) {
		return (x >= 0 && x < N && y >= 0 && y < N);
	}

}