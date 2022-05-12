package com.ssafy.boj.y22.m04.w4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_17144_미세먼지안녕 {
	public static int R;
	public static int C;
	public static int T;
	public static int pr;
	public static int[][] board;
	// 우,상,좌,하
	public static int[] dr = { 0, -1, 0, 1 };
	public static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] RCT = br.readLine().split(" ");
		R = Integer.parseInt(RCT[0]);
		C = Integer.parseInt(RCT[1]);
		T = Integer.parseInt(RCT[2]);
		// 패딩
		board = new int[R + 2][C + 2];
		// 공기청정기 윗부분만 받기 위한 lock
		boolean lock = false;
		for (int r = 1; r <= R; r++) {
			String[] aline = br.readLine().split(" ");
			for (int c = 1; c <= C; c++) {
				board[r][c] = Integer.parseInt(aline[c - 1]);
				if (!lock && board[r][c] == -1) {
					lock = true;
					pr = r;
				}
			}
		}
		for (int i = 0; i < T; i++) {
			spread();
			purify();
		}

		bw.write(count() + " ");
		bw.flush();
	}

	// 공청기는 안따지게 주의하자
	public static int count() {
		int sumVal = 0;
		for (int r = 1; r <= R; r++) {
			for (int c = 1; c <= C; c++) {
				// 공청기 or 빈칸이 아닌 경우
				if (board[r][c] > 0) {
					sumVal += board[r][c];
				}
			}
		}
		return sumVal;
	}

	public static void purify() {
		int[][] tmp = new int[R + 2][C + 2];
		// 하나의 이동의 출발과 도착 중 출발 위치를 체크한다.
		boolean[][] check = new boolean[R + 2][C + 2];

		// 1번 트랙
		for (int col = 2; col <= C - 1; col++) {
			tmp[pr][col + 1] = board[pr][col];
			check[pr][col] = true;
		}

		// 2번 트랙
		for (int row = pr; row >= 2; row--) {
			tmp[row - 1][C] = board[row][C];
			check[row][C] = true;
		}

		// 3번 트랙
		for (int col = C; col >= 2; col--) {
			tmp[1][col - 1] = board[1][col];
			check[1][col] = true;
		}

		// 4번 트랙
		for (int row = 1; row <= pr - 1; row++) {
			tmp[row + 1][1] = board[row][1];
			check[row][1] = true;
		}

		// 5번 트랙
		for (int col = 2; col <= C - 1; col++) {
			tmp[pr + 1][col + 1] = board[pr + 1][col];
			check[pr + 1][col] = true;
		}

		// 6번 트랙
		for (int row = pr + 1; row <= R - 1; row++) {
			tmp[row + 1][C] = board[row][C];
			check[row][C] = true;
		}

		// 7번 트랙
		for (int col = C; col >= 2; col--) {
			tmp[R][col - 1] = board[R][col];
			check[R][col] = true;
		}

		// 8번 트랙
		for (int row = R; row >= pr + 2; row--) {
			tmp[row - 1][1] = board[row][1];
			check[row][1] = true;
		}

		// 공청기를 타지 않은 곳도 복사
		// 이때 공청기 복사되면서 공청기 자리의 먼지는 자연스럽게 정화된다.
		for (int r = 1; r <= R; r++) {
			for (int c = 1; c <= C; c++) {
				if (!check[r][c]) {
					tmp[r][c] = board[r][c];
				}
			}
		}

		// 이제 tmp정보를 board에 업데이트하자.
		copy(board, tmp);
	}

	// 동시발생이란 조건을 주의하자!!
	// 확산 전 기존 판에서 나의 값은 2가지로 쪼개진다.
	// 1. 새로운 판의 남에게 주는 값, 2. 새로운 판의 나에게 주는 값ㅁㅁㅁㅁㅁㅁㅁ메모ㅁㅁㅁㅁㅁㅁㅁㅁㅁ
	public static void spread() {
		// tmp는 확산 후 모습을 나타냄.
		int[][] tmp = new int[R + 2][C + 2];

		// 모든 칸에 대하여
		for (int row = 1; row <= R; row++) {
			for (int col = 1; col <= C; col++) {
				// 나눠주기 전 값
				int rest = board[row][col];
				// 한칸 당 할당량
				int share = rest / 5;
				// 나눠주기
				for (int i = 0; i < 4; i++) {
					int rowD = row + dr[i];
					int colD = col + dc[i];
					// 줄 수 있는 곳
					if (board[rowD][colD] != -1 && BC(rowD, colD)) {
						tmp[rowD][colD] += share;
						rest -= share;
					} // 줬다.
				} // 다 나눠 줌
					// 남은 양이 곧 내가 먹는다
				tmp[row][col] += rest;
			}
		}

		// 확산 후 모습을 board에 업데이트
		copy(board, tmp);
	}

	public static void copy(int[][] a, int[][] b) {
		for (int row = 1; row <= R; row++) {
			for (int col = 1; col <= C; col++) {
				// 값이 정수니까 그냥 할당
				a[row][col] = b[row][col];
			}
		}
	}

	public static boolean BC(int r, int c) {
		if (r >= 1 && r <= R && c >= 1 && c <= C) {
			return true;
		} else {
			return false;
		}
	}

}
