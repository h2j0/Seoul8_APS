package com.ssafy.boj.y22.m04.w4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_23288_주사위굴리기2 {
	public static int N;
	public static int M;
	public static int K;
	// 동북서남(반시계)
	public static int[] dr = { 0, -1, 0, 1 };
	public static int[] dc = { 1, 0, -1, 0 };
	public static int[] dice = { 0, 1, 2, 3, 4, 5, 6 };
	public static int gndIdx = 6;
	public static int[][] board;

	public static class coor {
		public int row;
		public int col;

		public coor(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 입력받기
		String[] NMK = br.readLine().split(" ");
		N = Integer.parseInt(NMK[0]);
		M = Integer.parseInt(NMK[1]);
		K = Integer.parseInt(NMK[2]);

		// 1짜리 패딩
		board = new int[N + 2][M + 2];
		for (int r = 1; r <= N; r++) {
			String[] aline = br.readLine().split(" ");
			for (int c = 0; c < M; c++) {
				board[r][c + 1] = Integer.parseInt(aline[c]);
			}
		}

		// 시작(최초 동쪽이동완료, 주사위는 아직 미변화 시점)
		int curR = 1;
		int curC = 1;
		int dir = 0;
		int sumVal = 0;
		while (K > 0) {
			// 한칸 움직이기
			curR += dr[dir];
			curC += dc[dir];
			// 주사위 변함
			doDice(dir);
			// 획득할 점수 계산
			int B = board[curR][curC];
			int C = BFS(curR, curC, board[curR][curC]);
			sumVal += B * C;
			// 방향결정
			// 시계
			if (dice[gndIdx] > B) {
				if (dir == 0) {
					dir = 3;
				} else {
					dir--;
				}
				// 반시계
			} else if (dice[gndIdx] < B) {
				dir = (dir + 1) % 4;
			}
			// 벽에 인접한 곳은 반대방향으로 변경
			if (curR + dr[dir] < 1 || curR + dr[dir] > N || curC + dc[dir] < 1 || curC + dc[dir] > M) {
				dir = (dir + 2) % 4;
			}
			K--;
		}

		bw.write(sumVal + "\n");
		bw.flush();

	}

	public static int BFS(int row, int col, int stVal) {
		int cnt = 0;
		Queue<coor> Q = new LinkedList<>();
		boolean[][] checkBFS = new boolean[N + 2][M + 2];
		Q.add(new coor(row, col));
		checkBFS[row][col] = true;

		while (!Q.isEmpty()) {
			coor curr = Q.poll();
			cnt++;
			for (int i = 0; i < 4; i++) {
				int rowD = curr.row + dr[i];
				int colD = curr.col + dc[i];
				if (!checkBFS[rowD][colD] && board[rowD][colD] == stVal) {
					Q.add(new coor(rowD, colD));
					checkBFS[rowD][colD] = true;
				}
			}
		}
		return cnt;

	}

	public static void doDice(int dir) {
		switch (dir) {
		// East
		case 0:
			int tmp0 = dice[6];
			dice[6] = dice[3];
			dice[3] = dice[1];
			dice[1] = dice[4];
			dice[4] = tmp0;
			break;
		// North
		case 1:
			int tmp1 = dice[2];
			dice[2] = dice[1];
			dice[1] = dice[5];
			dice[5] = dice[6];
			dice[6] = tmp1;
			break;
		// West
		case 2:
			int tmp2 = dice[3];
			dice[3] = dice[6];
			dice[6] = dice[4];
			dice[4] = dice[1];
			dice[1] = tmp2;
			break;
		// South
		case 3:
			int tmp = dice[1];
			dice[1] = dice[2];
			dice[2] = dice[6];
			dice[6] = dice[5];
			dice[5] = tmp;
			break;
		}
	}

}
//End