package com.ssafy.boj.y22.m04.w4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_23290_마법사상어와복제 {

	// 문제 방향 숫자를 %8한 값으로 사용
	public static int[] drE = { 1, 0, -1, -1, -1, 0, 1, 1 };
	public static int[] dcE = { -1, -1, -1, 0, 1, 1, 1, 0 };

	// 상, 좌, 하,우
	public static int[] dr = { -1, 0, 1, 0 };
	public static int[] dc = { 0, -1, 0, 1 };
	public static int sr = 0;
	public static int sc = 1;
	public static int[] shark;
	public static List<Integer>[][] board;
	public static List<Integer>[][] backup;
	public static boolean[][] smellNow;
	public static boolean[][] smellPast;
	public static int[] sharkDir;
	public static int[] select;
	public static int maxSum;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] MS = br.readLine().split(" ");
		int M = Integer.parseInt(MS[0]);
		int S = Integer.parseInt(MS[1]);

		// board 만들기
		board = new ArrayList[6][6];
		backup = new ArrayList[6][6];
		for (int r = 1; r <= 4; r++) {
			for (int c = 1; c <= 4; c++) {
				board[r][c] = new ArrayList<>();
				backup[r][c] = new ArrayList<>();
			}
		}

		// 냄새정보
		smellNow = new boolean[6][6];
		smellPast = new boolean[6][6];

		// fish 입력 받기
		for (int fc = 0; fc < M; fc++) {
			String[] fishInfo = br.readLine().split(" ");
			int fx = Integer.parseInt(fishInfo[0]);
			int fy = Integer.parseInt(fishInfo[1]);
			int d = Integer.parseInt(fishInfo[2]) % 8;
			board[fx][fy].add(d);
		}
		// 상어 입력 받기
		String[] sharkInfo = br.readLine().split(" ");
		int sx = Integer.parseInt(sharkInfo[0]);
		int sy = Integer.parseInt(sharkInfo[1]);
		shark = new int[2];
		shark[sr] = sx;
		shark[sc] = sy;

		for (int i = 0; i < S; i++) {
			backup();

			fishMv();

			maxSum = -1;
			select = new int[3];
			sharkDir = new int[3];

			perm(0, shark[sr], shark[sc]);
			
			killFish(sharkDir, shark);
			
			update();
		}

		bw.write(cntFish()+" ");
		bw.flush();

	}

	// 출발위치를 미반영하기 위해
	// 경로 배열을 만드는게 아닌 이동방향배열을 만들자!!
	// DFS로하면 체크배열로 이미 간 곳은 안가지만
	// 이 문제는 이미 간 곳도 갈 수 있다!!
	// 결론적으로 중복순열이다.
	// 방문한 곳에 갈 수는 있지만 물고기가 이미 잡아먹혔으므로
	// 물고기가 또 더해지는 것은 막아주자.
	public static void perm(int sidx, int str, int stc) {
		if (sidx == 3) {
			// 순열 생성 완료
			int sumVal = 0;
			int curR = str;
			int curC = stc;
			boolean[][] check = new boolean[6][6];
			boolean flag = true;
			for (int i = 0; i < 3; i++) {
				curR += dr[select[i]];
				curC += dc[select[i]];
				// 경계밖이면 이 순열 자체가 불가능
				if (!BC(curR, curC)) {
					flag=false;
					break;
				}
				// 방문한적 없는 곳일때만 물고기를 추가시켜준다.
				if (!check[curR][curC]) {
					sumVal += board[curR][curC].size();
				}
				check[curR][curC] = true;
			}

			if (flag && sumVal > maxSum) {
				maxSum = sumVal;
				// 복사, 정수니까 그냥 단순 할당
				for (int i = 0; i < 3; i++) {
					sharkDir[i] = select[i];
				}
			}

			return;
		}

		for (int i = 0; i < 4; i++) {
			select[sidx] = i;
			perm(sidx + 1, str, stc);
		}
	}


	// 이동 방향이 확정된 상태로 움직이는 것이니까
	// 상어 위치 정보가 변하게끔(목표대상이 특정 동작 후 상태가
	// 변화되어있냐, 그대로냐를 잘 구분해주자)
	public static void killFish(int[] sharkDir, int [] shark) {
		// 냄새 과거로 옮기기
		copyNotObj(smellPast, smellNow);
		// 현재 냄새 지우기
		clear(smellNow);
		boolean[][] check = new boolean[6][6];
		for (int i = 0; i < 3; i++) {
			shark[sr] += dr[sharkDir[i]];
			shark[sc] += dc[sharkDir[i]];
			if (!check[shark[sr]][shark[sc]] && !board[shark[sr]][shark[sc]].isEmpty()) {
				board[shark[sr]][shark[sc]].clear();
				smellNow[shark[sr]][shark[sc]] = true;
			}
			check[shark[sr]][shark[sc]] = true;
		}
	}

	public static int cntFish() {
		int sum = 0;
		for (int row = 1; row <= 4; row++) {
			for (int col = 1; col <= 4; col++) {
				sum += board[row][col].size();
			}
		}
		return sum;
	}

	public static void clear(boolean[][] a) {
		for (int row = 1; row <= 4; row++) {
			for (int col = 1; col <= 4; col++) {
				a[row][col] = false;
			}
		}
	}

	public static void copyNotObj(boolean[][] a, boolean[][] b) {
		for (int row = 1; row <= 4; row++) {
			for (int col = 1; col <= 4; col++) {
				a[row][col] = b[row][col];
			}
		}
	}

	public static void fishMv() {
		// 이동 후 모습을 나타내는 배열 만들기
		List<Integer>[][] tmp = new ArrayList[6][6];
		for (int r = 1; r <= 4; r++) {
			for (int c = 1; c <= 4; c++) {
				tmp[r][c] = new ArrayList<>();
			}
		}
		for (int r = 1; r <= 4; r++) {
			for (int c = 1; c <= 4; c++) {
				// 각 칸의 물고기에 대해 조사
				int size = board[r][c].size();
				for (int i = 0; i < size; i++) {
					// 하나 빼기
					int curr = board[r][c].get(i);
					// 이동했나
					boolean flag = false;
					// 8번(방향개수)만큼 하면 제자리로 돌아온다!!!
					// 다른 방법은 백업을 쓰는 방법이 있다.
					int currBU = curr;
					for (int dir = 0; dir < 8; dir++) {
						int rowD = r + drE[curr];
						int colD = c + dcE[curr];

						// 이동할 수 있으면 이동하자, 2시대의 냄새 모두 따져줘야함.
						if (!(rowD == shark[sr] && colD == shark[sc]) && !smellPast[rowD][colD] && !smellNow[rowD][colD]
								&& BC(rowD, colD)) {
							tmp[rowD][colD].add(curr);
							flag = true;
							break;
						} else {
							// 반시계 방향
							if (curr == 0) {
								curr = 7;
							} else {
								curr = curr - 1;
							}
						}
					}
					// 이동을 못했으면 다시 원래 방향으로 원래 칸으로 넣기
					if (!flag) {
						tmp[r][c].add(currBU);
					}
				}
			}
		}
		// board 업데이트
		for (int r = 1; r <= 4; r++) {
			for (int c = 1; c <= 4; c++) {
				board[r][c] = tmp[r][c];
			}
		}

	}

	public static boolean BC(int r, int c) {
		if (r >= 1 && r <= 4 && c >= 1 && c <= 4) {
			return true;
		} else {
			return false;
		}
	}

	public static void backup() {
		for (int r = 1; r <= 4; r++) {
			for (int c = 1; c <= 4; c++) {
				// 카피전에 백업 배열을 비워두자
				backup[r][c].clear();
				// 정수니까 따로 객체 생성없이 바로 할당하면 됨.
				for (int i = 0; i < board[r][c].size(); i++) {
					backup[r][c].add(board[r][c].get(i));
				}
			}
		}
	}

	public static void update() {
		for (int r = 1; r <= 4; r++) {
			for (int c = 1; c <= 4; c++) {
				// 정수니까 따로 객체 생성없이 바로 넣어주면 됨.
				for (int i = 0; i < backup[r][c].size(); i++) {
					board[r][c].add(backup[r][c].get(i));
				}
				// 백업배열 초기화(backup메서드에서도 복사전에 한번 하지만 혹시 몰라서)
				backup[r][c].clear();
			}
		}
	}
	
	public static void debug() {
		System.out.println("shark : " + shark[sr] + " " + shark[sc]);

		// 디버깅
		for (int r = 0; r <= 5; r++) {
			for (int c = 0; c <= 5; c++) {
				System.out.print(board[r][c] + " ");
			}
			System.out.println();
		}

		System.out.println("-------------");

		// 디버깅
		for (int r = 0; r <= 5; r++) {
			for (int c = 0; c <= 5; c++) {
				System.out.print(smellNow[r][c] + " ");
			}
			System.out.println();
		}

		System.out.println("-------------");

		// 디버깅
		for (int r = 0; r <= 5; r++) {
			for (int c = 0; c <= 5; c++) {
				System.out.print(smellPast[r][c] + " ");
			}
			System.out.println();
		}

		System.out.println("-------------");

	}

}
//End