package com.ssafy.boj.y22.m04.w4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_23291_어항정리 {
	public static int N;
	public static int K;
	public static int difVal = 10_000;
	public static int[][] board;
	public static int[] dr = { 0, -1, 0, 1 };
	public static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 입력받기
		String[] NK = br.readLine().split(" ");
		N = Integer.parseInt(NK[0]);
		K = Integer.parseInt(NK[1]);
		board = new int[N][N];
		String[] input = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			board[0][i] = Integer.parseInt(input[i]);
		}

		int cnt = 0;
		while (difVal > K) {
			findMinAndAdd();
			leftOneUp();
			fly();
			adjPN();
			arrange();
			flyHalf();

			adjPN();
			arrange();
			diff();
			cnt++;
		}

		bw.write(cnt + "\n");
		bw.flush();

	}

	public static void findMinAndAdd() {
		int min = 10_000;
		// findMin
		for (int i = 0; i < N; i++) {
			min = Math.min(min, board[0][i]);
		}
		// Add
		for (int i = 0; i < N; i++) {
			if (board[0][i] == min) {
				board[0][i]++;
			}
		}
	}

	public static void leftOneUp() {
		board[1][1] = board[0][0];
		board[0][0] = 0;
	}

	public static void fly() {
		int idx = 1;
		int pivot = 1;
		int w = 1;
		int h = 2;

		while (true) {

			// 종료조건
			if (pivot - 1 + w + h > N - 1) {
				return;
			}

			for (int col = pivot; col < pivot + w; col++) {
				for (int row = 0; row < h; row++) {
					int nr = w - (col - pivot);
					int nc = pivot + w + row;
					board[nr][nc] = board[row][col];
					board[row][col] = 0;
				}
			}

			pivot += w;
			if (idx % 2 == 0) {
				h++;
			} else {
				w++;
			}
			idx++;
		}
	}

	public static void adjPN() {

		// adjPN 정보 수집
		int[][] adjPN = new int[N][N];
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				// 물고기가 있는 어항
				if (board[row][col] > 0) {
					// delta탐색
					for (int i = 0; i < 4; i++) {
						int nr = row + dr[i];
						int nc = col + dc[i];
						// delta에 있는 것도 물고기가 있는 어항이어야 한다.
						if (nr >= 0 && nr < N && nc >= 0 && nc < N && board[nr][nc] > 0) {
							// 내가 갑이면 잃고
							if (board[row][col] > board[nr][nc]) {
								adjPN[row][col] -= (board[row][col] - board[nr][nc]) / 5;
								// 내가 을이면 얻고
							} else {
								adjPN[row][col] += (board[nr][nc] - board[row][col]) / 5;
							}
						}
					}
				}
			}
		}

		// adjPN 정보 반영
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				board[row][col] += adjPN[row][col];
			}
		}
	}

	public static void arrange() {
		int idx = 0;
		for (int col = 0; col < N; col++) {
			for (int row = 0; row < N; row++) {
				if (board[row][col] > 0) {
					board[0][idx] = board[row][col];
					// 이동한 곳이 제자리일때 제자리를 지우면 다 지워지므로 지우면 안돼.
					if (!(0 == row && idx == col)) {
						board[row][col] = 0;
					}
					idx++;

				}
			}
		}
	}

	public static void flyHalf() {

		// 첫번째접기
		for (int col = 0; col < N / 2; col++) {
			board[1][N - 1 - col] = board[0][col];
			board[0][col] = 0;
		}
		// 두번째접기
		// 기준점을 하나잡고 그 '기준점과 이웃점의 관계'와 '변환(기준점)과 변환(이웃점)의 관계'를
		// 비교해서 식을 만든다.
		int stC = N / 2;
		int stR = 0;
		int w = N / 4;
		int h = 2;
		for (int dc = 0; dc < w; dc++) {
			for (int dr = 0; dr < h; dr++) {
				int nr = stR + 3 - dr;
				int nc = stC + (N / 2-1) - dc;
				board[nr][nc] = board[stR + dr][stC + dc];
				if (!(nr == stR + dr && nc == stC + dc)) {
					board[stR + dr][stC + dc] = 0;
				}
			}
		}
	}

	public static void diff() {
		int max = 0;
		int min = 10_000;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, board[0][i]);
			min = Math.min(min, board[0][i]);
		}
		difVal = Math.min(difVal, max - min);
	}
}
//End