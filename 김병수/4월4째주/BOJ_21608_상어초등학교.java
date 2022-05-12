package com.ssafy.boj.y22.m04.w4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class BOJ_21608_상어초등학교 {
	public static int N;
	public static int[][] board;
	public static nearInfo[][] objBoard;
	public static boolean[][] check;
	public static Map<Integer, Integer> [] adjList;

	// 우,상,좌,하
	public static int[] dr = { 0, -1, 0, 1 };
	public static int[] dc = { 1, 0, -1, 0 };

	public static class nearInfo implements Comparable<nearInfo> {
		public int likeCnt;
		public int emptyCnt;
		public int row;
		public int col;

		public nearInfo(int likeCnt, int emptyCnt, int row, int col) {
			this.likeCnt = likeCnt;
			this.emptyCnt = emptyCnt;
			this.row = row;
			this.col = col;
		}

		@Override
		public int compareTo(nearInfo o) {
			int result;
			// likeCnt와 emptyCnt는 maxHeap
			if (o.likeCnt != this.likeCnt) {
				result = o.likeCnt - this.likeCnt;
			} else if (o.emptyCnt != this.emptyCnt) {
				result = o.emptyCnt - this.emptyCnt;
				// row와 col은 minHeap
			} else if (this.row != o.row) {
				result = this.row - o.row;
			} else {
				result = this.col - o.col;
			}
			return result;
		}

		@Override
		public String toString() {
			return "nearInfo [likeCnt=" + likeCnt + ", emptyCnt=" + emptyCnt + ", row=" + row + ", col=" + col + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		// 크기 1 패딩
		board = new int[N + 2][N + 2];
		objBoard = new nearInfo[N + 2][N + 2];

		check = new boolean[N + 2][N + 2];
		// 인덱스는 학생번호, 담긴 데이터는 인접 HashMap
		adjList = new HashMap[N*N+1];
		for (int sc = 1; sc <= N * N; sc++) {
			// 학생 한명 받기
			String[] aline = br.readLine().split(" ");

			// 학생 번호
			int std = Integer.parseInt(aline[0]);
			// 좋아하는 학생 <몇번째, 학생번호>
			Map<Integer, Integer> adj = new HashMap<>();
			for (int lc = 1; lc <= 4; lc++) {
				adj.put(lc, Integer.parseInt(aline[lc]));
			}
			adjList[std] = adj;

			// 보드 탐색
			nearInfo select = findPosition(std, adj);
			board[select.row][select.col] = std;
			objBoard[select.row][select.col] = select;
			check[select.row][select.col] = true;
		}

		bw.write(satisfication()+" ");
		bw.flush();

	}

	// 삽입할때 인접 좋아하는 학생 수가 아닌
	// 완료 후 인접 좋아하는 학생 수이다!!!!!!!
	public static int satisfication() {
		int sumVal = 0;
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				int std  = board[r][c];
				int like = 0;
				// 좋아하는 사람수
				for (int i = 0; i < 4; i++) {
					int rowD = r + dr[i];
					int colD = c + dc[i];
					// 좋아하는 사람수
					if (BC(rowD, colD) && adjList[std].containsValue(board[rowD][colD])) {
						like++;
					}
				} // 완료 - 좋아하는 사람수
				
				switch (like) {
				case 0:
					sumVal += 0;
					break;
				case 1:
					sumVal += 1;
					break;
				case 2:
					sumVal += 10;
					break;
				case 3:
					sumVal += 100;
					break;
				case 4:
					sumVal += 1000;
					break;
				}
			}
		}
		return sumVal;

	}

	public static nearInfo findPosition(int std, Map<Integer, Integer> adj) {
		PriorityQueue<nearInfo> conditions = new PriorityQueue<>();
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				int like = 0;
				int empty = 0;
				// 좋아하는 사람수, 빈칸 수 확인
				for (int i = 0; i < 4; i++) {
					int rowD = r + dr[i];
					int colD = c + dc[i];
					// 좋아하는 사람수
					if (BC(rowD, colD) && adj.containsValue(board[rowD][colD])) {
						like += 1;
						// 빈칸 수
					} else if (BC(rowD, colD) && board[rowD][colD] == 0) {
						empty += 1;
					}
				} // 완료 - 좋아하는 사람수, 빈칸 수 확인

				// 각 칸의 정보 저장
				if (!check[r][c]) {
					conditions.add(new nearInfo(like, empty, r, c));
				}
			}
		}
		return conditions.poll();
	}

	public static boolean BC(int r, int c) {
		if (r >= 1 && r <= N && c >= 1 && c <= N) {
			return true;
		} else {
			return false;
		}
	}

}
