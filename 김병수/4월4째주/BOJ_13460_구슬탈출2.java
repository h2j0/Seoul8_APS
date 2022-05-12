package com.ssafy.boj.y22.m04.w4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_13460_구슬탈출2 {
	public static char[][] board;
	public static int N;
	public static int M;
	public static int st = 5;
	public static int ri = 0;
	public static int up = 1;
	public static int le = 2;
	public static int dn = 3;
	public static int red = 0;
	public static int blue = 1;
	public static int r = 0;
	public static int c = 1;
	public static int[] dr = { 0, -1, 0, 1 };
	public static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 입력받기
		String[] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);
		board = new char[N][M];
		for (int row = 0; row < N; row++) {
			String aline = br.readLine();
			for (int col = 0; col < M; col++) {
				board[row][col] = aline.charAt(col);
			}
		}

		// game 시작

	}

	public static void game(int dept, int dir, char[][] board, int[][] RBpos) {

		switch (dir) {
		case 0:
			break;
		// UP
		// 더 위쪽에 있는 애 먼저
		case 1:
//			if (RBpos[red][row] < RBpos[bule][row]) {
//
//			}

		}

		game(dept + 1, up, cpy(board), RB(board));
		game(dept + 1, dn, cpy(board), RB(board));
		game(dept + 1, ri, cpy(board), RB(board));
		game(dept + 1, le, cpy(board), RB(board));

	}

	public static void go(int dir, int color, char[][] board, int[][] RBpos) {
		// 이동할 곳 찾기
		
		
		
		
		
		
		
	}

	public static char[][] cpy(char[][] curBoard) {
		char[][] copy = new char[N][M];
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < M; col++) {
				copy[row][col] = curBoard[row][col];
			}
		}
		return copy;
	}

	public static int[][] RB(char[][] curBoard) {
		int[][] RBpos = new int[2][2];
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < M; col++) {
				if (curBoard[row][col] == 'R') {
					RBpos[0][0] = row;
					RBpos[0][1] = col;
				} else if (curBoard[row][col] == 'B') {
					RBpos[1][0] = row;
					RBpos[1][1] = col;
				}
			}
		}
		return RBpos;
	}
}
//End