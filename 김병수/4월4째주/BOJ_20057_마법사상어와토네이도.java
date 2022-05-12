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

public class BOJ_20057_마법사상어와토네이도 {
	public static double[][] kernel = { { 0, 0, 0.02, 0, 0 }, { 0, 0.1, 0.07, 0.01, 0 }, { 0.05, 0, 0, 0, 0 },
			{ 0, 0.1, 0.07, 0.01, 0 }, { 0, 0, 0.02, 0, 0 } };
	// 좌,하,우,상
	public static int[] dr = { 0, 1, 0, -1 };
	public static int[] dc = { -1, 0, 1, 0 };
	public static int N;
	public static int[][] board;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 입력받기
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		int sum = 0;
		for (int r = 0; r < N; r++) {
			String[] aLine = br.readLine().split(" ");
			for (int c = 0; c < N; c++) {
				board[r][c] = Integer.parseInt(aLine[c]);
				sum += board[r][c];
			}
		}

		int[][] test = new int[N][N];
		// 토네이도 이동
		int curR = N / 2;
		int curC = N / 2;
		// 직선길이
		int len = 1;
		// 하나의 직선길이를 채우는 횟수
		int times = 0;
		int dir = 0;
		// 하나의 직선길이를 채우는 걸 두번했을때 직선길이가 증가하도록함.
		boolean toggle = false;
		while (!(curR == 0 && curC == 0)) {
			curR = curR + dr[dir];
			curC = curC + dc[dir];
			times++;
			wind(curR, curC, dir);

			if (!toggle && len == times) {
				toggle = true;
				times = 0;
				dir = (dir + 1) % 4;
			} else if (toggle && len == times) {
				toggle = false;
				len++;
				times = 0;
				dir = (dir + 1) % 4;
			}
		}

		// 남은 모래 확인
		int leftOver = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				leftOver += board[r][c];
			}
		}

		bw.write((sum - leftOver) + "\n");
		bw.flush();
	}

	public static void wind(int curR, int curC, int dir) {

		double[][] theKernel = new double[5][5];
		switch (dir) {
		// 서
		case 0:
			for (int r = 0; r < 5; r++) {
				for (int c = 0; c < 5; c++) {
					theKernel[r][c] = kernel[r][c];
				}
			}
			break;
		// 남
		case 1:
			for (int r = 0; r < 5; r++) {
				for (int c = 0; c < 5; c++) {
					theKernel[5 - 1 - c][r] = kernel[r][c];
				}
			}
			break;

		// 동
		case 2:
			for (int r = 0; r < 5; r++) {
				for (int c = 0; c < 5; c++) {
					theKernel[r][5 - 1 - c] = kernel[r][c];
				}
			}
			break;
		// 북
		case 3:
			for (int r = 0; r < 5; r++) {
				for (int c = 0; c < 5; c++) {
					theKernel[c][r] = kernel[r][c];
				}
			}
			break;
		}

		// 바람 불기
		// 주변 영향
		int spread = 0;
		for (int r = curR - 2; r <= curR + 2; r++) {
			for (int c = curC - 2; c <= curC + 2; c++) {
				if (r >= 0 && r < N && c >= 0 && c < N) {
					int distribution = (int) (theKernel[r - curR + 2][c - curC + 2] * board[curR][curC]);
					board[r][c] += distribution;
					spread += distribution;
					// 범위 밖에 있어도 분배는 한다고 간주하므로 범위 밖일때도 총 분배양에 포함시켜줘야함.
				} else {
					spread += (int) (theKernel[r - curR + 2][c - curC + 2] * board[curR][curC]);
				}
			}
		}
		// 분배한 것 제외하고는 분배 중 버림에 의한 것까지 모두 a가 가져가야함.
		if (curR + dr[dir] >= 0 && curR + dr[dir] < N && curC + dc[dir] >= 0 && curC + dc[dir] < N) {
			board[curR + dr[dir]][curC + dc[dir]] += board[curR][curC] - spread;
		}
		// 현재 위치 0으로
		board[curR][curC] = 0;
	}
}
//End