package com.ssafy.boj.y22.m04.w3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_7576_토마토 {
	// 우,상,좌,하
	public static int[] dr = { 0, -1, 0, 1 };
	public static int[] dc = { 1, 0, -1, 0 };
	public static int[][] board;
	public static boolean[][] check;
	public static Queue<coor> Q;

	public static class coor {
		public int row;
		public int col;

		public coor(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}

		@Override
		public String toString() {
			return "coor [row=" + row + ", col=" + col + "]";
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 입력받기
		String[] MN = br.readLine().split(" ");
		int M = Integer.parseInt(MN[0]);
		int N = Integer.parseInt(MN[1]);
		// 크기 1 패딩
		board = new int[N + 2][M + 2];
		check = new boolean[N + 2][M + 2];
		for (int row = 0; row < N + 2; row++) {
			for (int col = 0; col < M + 2; col++) {
				if (row == N + 1 || row == 0 || col == M + 1 || col == 0) {
					// 패딩부분은 토마토가 없는 칸 취급한다.
					board[row][col] = -1;
				}
			}
		}

		// 입력받기
		// Q : 익은 토마토 큐
		Q = new LinkedList<>();
		// 토마토 수
		int tomatoes = 0;
		for (int row = 1; row <= N; row++) {
			String[] aLine = br.readLine().split(" ");
			for (int col = 1; col <= M; col++) {
				board[row][col] = Integer.parseInt(aLine[col - 1]);
				// 익은 토마토 큐에 추가
				if (board[row][col] == 1) {
					Q.add(new coor(row, col));
					// 여기서 방문체크가 필요한 이유 :
					// 하나의 0에 대해 인접한 여러 1이 중복으로
					// 접근할 수 있음. 그러면 하나의 0이
					// Queu에 여러번 올라감.
					check[row][col] = true;
					tomatoes++;
				// 익지 않은 토마토
				} else if (board[row][col] == 0) {
					tomatoes++;
				}
			}
		}


		// 아무것도 안익은 상태(day0)부터 시작할 것이다
		int dayCnt = -1;
		// 전염된 토마토 수
		int doRed = 0;
		
		// BFS
		// - 논리 정리 기준 : 
		// N째날 할 일은 N번째 iteration에 모아두자.
		// N번째 iteration에 N+1일 날 할일을 적지 말자.
		// - 첫번째 iteration(day0)에는 익은 상태로 준 토마토를 익힌다.
		while (!Q.isEmpty()) {
			dayCnt++;
			// for조건문에 정적변수를 쓰도록 하자.
			int QsizeToday = Q.size();
			for (int q = 0; q < QsizeToday; q++) {
				coor curr = Q.poll();
				// 전염, 전염처리는 꼭 Q에서 poll했을때 처리한다.
				board[curr.row][curr.col] = 1;
				doRed++;
				// 전염 후보인 주변 0을 Q에 올리기
				for (int i = 0; i < 4; i++) {
					int rowD = curr.row + dr[i];
					int colD = curr.col + dc[i];
					if (!check[rowD][colD] && board[rowD][colD] == 0) {
						Q.add(new coor(rowD, colD));
						check[rowD][colD] = true;
					}
				}
			}
		}

		// 정답 결정
		int result = -1;
		if (tomatoes == doRed) {
			result = dayCnt;
		} else {
			result = -1;
		}
		
		// 출력
		bw.write(result + "\n");
		bw.flush();

	}
}
//End