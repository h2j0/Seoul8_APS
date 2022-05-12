package com.ssafy.boj.y22.m04.w4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;

public class BOJ_20056_마법사상어와파이어볼 {
	public static int N;
	public static int M;
	public static int K;
	public static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	public static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static List<fireball>[][] board;

	public static class fireball {
		public int m;
		public int s;
		public int d;

		public fireball(int m, int s, int d) {
			this.m = m;
			this.s = s;
			this.d = d;
		}

		@Override
		public String toString() {
			return "fireball [m=" + m + ", s=" + s + ", d=" + d + "]";
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] NMK = br.readLine().split(" ");
		N = Integer.parseInt(NMK[0]);
		M = Integer.parseInt(NMK[1]);
		K = Integer.parseInt(NMK[2]);

		// 크기1 패딩 board 만들기
		board = new LinkedList[N][N];
		objInject(board);

		// 파이어볼 생성
		// idx0부터 시작으로 좌표값 변경해서 받기
		for (int i = 0; i < M; i++) {
			String[] aline = br.readLine().split(" ");
			int r = Integer.parseInt(aline[0]) - 1;
			int c = Integer.parseInt(aline[1]) - 1;
			int m = Integer.parseInt(aline[2]);
			int s = Integer.parseInt(aline[3]);
			int d = Integer.parseInt(aline[4]);
			board[r][c].add(new fireball(m, s, d));
		}

		for (int i = 0; i < K; i++) {
			FBmv();
			GEtwo();
		}

		System.out.println(getResult());
	}

	public static int getResult() {
		int totalSum=0;
		// 모든 칸에 대해
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				// 비어있지 않으면
				if(!board[r][c].isEmpty()) {
					int size = board[r][c].size();
					for(int i=0; i<size; i++) {
						totalSum+=board[r][c].get(i).m;
					}
				}
			}
		}
		return totalSum;

	}

	public static void GEtwo() {
		// 모든 칸에 대해
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				// 2개 이상의 파이어볼
				if (board[r][c].size() >= 2) {
					beONE(r, c);
				}
			}
		}
	}

	// 하나로 합치고 4개의 새 파이어볼을 만든다.
	public static void beONE(int r, int c) {
		int size = board[r][c].size();
		int mSum = 0;
		int sSum = 0;
		List<Integer> dirList = new LinkedList<>();
		// 원래 있던 파이어볼 정보 모두 얻기
		for (int i = 0; i < size; i++) {
			mSum += board[r][c].get(i).m;
			sSum += board[r][c].get(i).s;
			dirList.add(board[r][c].get(i).d);
		}
		// 원래 있던 파이어볼 제거
		board[r][c].clear();
		// 새 파이어볼의 방향 결정
		int dirSize = dirList.size();
		int oddCnt = 0;
		int evenCnt = 0;
		for (int i = 0; i < dirSize; i++) {
			// 짝수일때
			if (dirList.get(i) % 2 == 0) {
				evenCnt++;
			// 홀수일때
			} else if (dirList.get(i) % 2 == 1) {
				oddCnt++;
			}
		}
		int[] newDir = new int[4];
		// 모두 홀수이거나 모두 짝수
		if (oddCnt == dirSize || evenCnt == dirSize) {
			newDir[0] = 0;
			newDir[1] = 2;
			newDir[2] = 4;
			newDir[3] = 6;
		} else {
			newDir[0] = 1;
			newDir[1] = 3;
			newDir[2] = 5;
			newDir[3] = 7;
		}

		// 새 파이어볼 4개를 다시 생성해서 보드에 넣어주기
		// 새 질량이 0이 아닐때만 생성
		if (mSum / 5 != 0) {
			board[r][c].add(new fireball(mSum / 5, sSum / size, newDir[0]));
			board[r][c].add(new fireball(mSum / 5, sSum / size, newDir[1]));
			board[r][c].add(new fireball(mSum / 5, sSum / size, newDir[2]));
			board[r][c].add(new fireball(mSum / 5, sSum / size, newDir[3]));
		}

	}

	public static void FBmv() {
		List<fireball>[][] tmp = new LinkedList[N + 2][N + 2];
		objInject(tmp);

		// 모든 칸에 대해
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				// 해당 칸의 모든 파이어볼
				int size = board[r][c].size();
				for (int i = 0; i < size; i++) {
					fireball curr = board[r][c].get(i);
					// 음수일때는 +N 해준다.
					int rowTmp = (r + dr[curr.d] * curr.s) % N;
					if ((r + dr[curr.d] * curr.s) % N < 0) {
						rowTmp += N;
					}
					int colTmp = (c + dc[curr.d] * curr.s) % N;
					if ((c + dc[curr.d] * curr.s) % N < 0) {
						colTmp += N;
					} // 도착지 찾기 완료

					// tmp에 도착 정보 저장
					// 객체 간섭안일어나게 조심히 다루자.
					// board에 있던 fireball 객체를 그대로 살려 넣어주기
					tmp[rowTmp][colTmp].add(curr);
				}
			}
		}

		// tmp -> board
		// tmp에 있던 리스트를 그대로 살려 넣어주기
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				board[r][c] = tmp[r][c];
			}
		}
	}

	// 리스트 객체 배열 생성할때 리스트 객체 주입해주기 위함.
	public static void objInject(List<fireball>[][] grid) {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				grid[r][c] = new LinkedList<>();
			}
		}
	}

}
