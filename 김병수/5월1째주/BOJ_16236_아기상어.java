package com.ssafy.boj.y22.m05.w1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class BOJ_16236_아기상어 {

	public static class fish implements Comparable<fish> {
		public int dist;
		public int r;
		public int c;
		public int size;

		public fish() {
		}

		public fish(int dist, int r, int c, int size) {
			this.dist = dist;
			this.r = r;
			this.c = c;
			this.size = size;
		}

		@Override
		public String toString() {
			return "fish [dist=" + dist + ", r=" + r + ", c=" + c + ", size=" + size + "]";
		}

		@Override
		public int compareTo(fish o) {
			// 거리는 내림차순
			// 행은 내림차순
			// 열은 내림차순
			int result = 0;
			if (this.dist != o.dist) {
				result = this.dist - o.dist;
			} else if (this.r != o.r) {
				result = this.r - o.r;
			} else {
				result = this.c - o.c;
			}
			return result;
		}

	}

	public static class coor {
		public int r;
		public int c;
		public int dept;

		public coor(int r, int c, int dept) {
			this.r = r;
			this.c = c;
			// 최단 경로로 이동 중 지나간 칸의 개수(BFS)
			this.dept = dept;
		}
	}

	public static int[] dr = { 0, -1, 0, 1 };
	public static int[] dc = { 1, 0, -1, 0 };

	public static int[][] board;
	public static int N;
	public static fish shark;
	public static PriorityQueue<fish> pq;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		shark = new fish();

		// board 구성
		// 상어를 의미하는 9는 상어를 찾은 후 0으로 만든다.
		// 나중에 이 9가 길막할 수 있으므로
		for (int r = 0; r < N; r++) {
			String[] aline = br.readLine().split(" ");
			for (int c = 0; c < N; c++) {
				board[r][c] = Integer.parseInt(aline[c]);
			}
		}

		// 상어 첫 위치 찾기
		// 상어를 찾은 후 해당 칸은 0으로 만든다.
		updateShark();

		// 게임을 위한 변수
		int time = 0;
		int eat = 0;
		// 게임 시작
		while (true) {
			pq = new PriorityQueue<>();
			// board 스캔하면서 현시점 물고기 정보를 pq에 저장
			updatePQ();

			// pq가 비었다면 게임 종료
			if (pq.isEmpty()) {
				break;
			}

			// 이동
			fish nxt = pq.poll();
			eat++;
			time += nxt.dist;
			shark.r = nxt.r;
			shark.c = nxt.c;
			if (shark.size == eat) {
				shark.size++;
				eat = 0;
			}
			// 상어 이동 후 해당 칸을 0으로 만든다
			board[shark.r][shark.c]=0;
		}

		System.out.println(time);
	}

	// fish -> dist; r; c; size;
	// BFS로 먹을 수 있는 물고기를 모두 PQ에 담는다.
	// r,c는 상어 위치
	// curr.r, curr.c는 탐색 중 현재 위치
	// rowD, colD는 (curr.r, curr.c)의 주변 위치
	public static void updatePQ() {
		Queue<coor> Q = new LinkedList<>();
		boolean[][] check = new boolean[N][N];

		Q.add(new coor(shark.r, shark.c, 0));
		check[shark.r][shark.c] = true;

		while (!Q.isEmpty()) {
			coor curr = Q.poll();
			// 이게 먹을 수 있는 물고기 인가
			if (board[curr.r][curr.c] >= 1 && board[curr.r][curr.c] <= 6 && board[curr.r][curr.c] < shark.size) {
				pq.add(new fish(curr.dept, curr.r, curr.c, board[curr.r][curr.c]));
			}
			// 주변 탐색
			for (int i = 0; i < 4; i++) {
				int rowD = curr.r + dr[i];
				int colD = curr.c + dc[i];
				// 갈 수 있는 곳인가
				if (BC(rowD, colD) && !check[rowD][colD] && board[rowD][colD] <= shark.size) {
					Q.add(new coor(rowD, colD,curr.dept+1));
					check[rowD][colD] = true;
				}
			}
		}

	}

	public static void updateShark() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (board[r][c] == 9) {
					shark.dist = 0;
					shark.r = r;
					shark.c = c;
					shark.size = 2;
					board[r][c] = 0;
				}
			}
		}
	}

	public static boolean BC(int r, int c) {
		if (r >= 0 && r < N && c >= 0 && c < N) {
			return true;
		} else {
			return false;
		}
	}

}
//End