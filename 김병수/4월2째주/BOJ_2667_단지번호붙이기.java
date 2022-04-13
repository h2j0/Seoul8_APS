package com.ssafy.boj.y22.m04.w2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ_2667_단지번호붙이기 {
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

		// 입력받기
		int N = Integer.parseInt(br.readLine());
		// 크기 1의 패딩
		town = new int[N + 2][N + 2];
		// 2는 무관심지역, 1은 아직 처리하지 않은 집, 0은 빈 곳
		for (int row = 0; row < N + 2; row++) {
			for (int col = 0; col < N + 2; col++) {
				if (row == N + 1 || row == 0 || col == N + 1 || col == 0) {
					town[row][col] = 2;
				}
			}
		}
		for (int row = 1; row < N + 1; row++) {
			char[] aLine = br.readLine().toCharArray();
			for (int col = 1; col < N + 1; col++) {
				town[row][col] = aLine[col - 1] - '0';
			}
		}

		// 전체 돌기
		int groupCnt = 0;
		List<Integer> grpList = new LinkedList<>();
		for (int row = 1; row < N + 1; row++) {
			for (int col = 1; col < N + 1; col++) {
				// 1인 곳만 BFS시작
				if (town[row][col] == 1) {
					grpList.add(BFS(new coor(row, col)));
					groupCnt++;
				}
			}
		}
		Collections.sort(grpList);

		// 출력
		bw.write(groupCnt+"\n");
		for (int i = 0; i < grpList.size(); i++) {
			bw.write(grpList.get(i) + "\n");
		}
		bw.flush();
	}

	public static int BFS(coor start) {
		int elementCnt = 0;
		Queue<coor> Q = new LinkedList<>();
		Q.add(start);
		town[start.row][start.col] = 2;
		while (!Q.isEmpty()) {
			coor curr = Q.poll();
			elementCnt++;
			// delta 탐색
			for (int i = 0; i < 4; i++) {
				int rowD = curr.row + dr[i];
				int colD = curr.col + dc[i];
				// 집이 있으면
				if (town[rowD][colD] == 1) {
					Q.add(new coor(rowD, colD));
					// 방문 체크
					town[rowD][colD] = 2;
				}
			}
		}
		return elementCnt;
	}
}
//End