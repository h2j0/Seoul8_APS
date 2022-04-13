package com.ssafy.boj.y22.m04.w2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1012_유기농배추 {
	// 우,상,좌,하
	public static int[] dr = { 0, -1, 0, 1 };
	public static int[] dc = { 1, 0, -1, 0 };
	public static int[][] town;

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

		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			// 입력받기
			String [] MNK =br.readLine().split(" ");
			int M = Integer.parseInt(MNK[0]);
			int N = Integer.parseInt(MNK[1]);
			int K = Integer.parseInt(MNK[2]);
			// 크기 1의 패딩
			town = new int[N + 2][M + 2];
			// 2는 무관심지역, 1은 배추, 0은 노 배추
			for (int row = 0; row < N + 2; row++) {
				for (int col = 0; col < M + 2; col++) {
					if (row == N + 1 || row == 0 || col == M + 1 || col == 0) {
						town[row][col] = 2;
					}
				}
			}
			// 배추 위치 받기
			for(int i=0; i<K; i++) {
				String [] XY =br.readLine().split(" ");
				int Y = Integer.parseInt(XY[1]);
				int X = Integer.parseInt(XY[0]);
				// 패딩 고려
				town[Y+1][X+1] = 1;
			}
			
			// 전체 돌기
			int groupCnt = 0;
			for (int row = 1; row < N + 1; row++) {
				for (int col = 1; col < M + 1; col++) {
					// 1인 곳만 BFS시작
					if (town[row][col] == 1) {
						BFS(new coor(row, col));
						groupCnt++;
					}
				}
			}


			// 출력
			bw.write(groupCnt + "\n");
			bw.flush();
		}
	}

	public static void BFS(coor start) {
		Queue<coor> Q = new LinkedList<>();
		Q.add(start);
		town[start.row][start.col] = 2;
		while (!Q.isEmpty()) {
			coor curr = Q.poll();

			// delta 탐색
			for (int i = 0; i < 4; i++) {
				int rowD = curr.row + dr[i];
				int colD = curr.col + dc[i];
				// 배추가 있으면
				if (town[rowD][colD] == 1) {
					Q.add(new coor(rowD, colD));
					// 방문 체크
					town[rowD][colD] = 2;
				}
			}
		}
		return;
	}
}
//End