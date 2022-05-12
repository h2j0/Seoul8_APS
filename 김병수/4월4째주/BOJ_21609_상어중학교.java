package com.ssafy.boj.y22.m04.w4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class BOJ_21609_상어중학교 {

	public static int empty = -2;
	public static int black = -1;
	public static int rainbow = 0;
	public static int N;
	public static int M;
	public static int[][] board;

	// 우,상,좌,하
	public static int[] dr = { 0, -1, 0, 1 };
	public static int[] dc = { 1, 0, -1, 0 };

	public static class group implements Comparable<group> {
		List<coor> blockList;
		int size;
		int rainbowCnt;
		int mainR;
		int mainC;

		public group(List<coor> blockList, int size, int rainbowCnt, int mainR, int mainC) {
			this.blockList = blockList;
			this.size = size;
			this.rainbowCnt = rainbowCnt;
			this.mainR = mainR;
			this.mainC = mainC;
		}

		@Override
		public String toString() {
			return "group [blockList=" + blockList + ", size=" + size + ", rainbowCnt=" + rainbowCnt + ", mainR="
					+ mainR + ", mainC=" + mainC + "]";
		}

		@Override
		// 모든 조건에 대해 maxHeap
		public int compareTo(group o) {
			int result;
			if (o.size != this.size) {
				result = o.size - this.size;
			} else if (o.rainbowCnt != this.rainbowCnt) {
				result = o.rainbowCnt - this.rainbowCnt;
			} else if (o.mainR != this.mainR) {
				result = o.mainR - this.mainR;
			} else {
				result = o.mainC - this.mainC;
			}
			return result;
		}
	}

	public static class coor {
		public int row;
		public int col;

		public coor(int row, int col) {
			this.row = row;
			this.col = col;
		}

		@Override
		public String toString() {
			return "coor [row=" + row + ", col=" + col + "]";
		}
	}

	// 패딩값 0에 영향받지 않도록 BC 잘 지키자.(r >= 1 && r <= N && c >= 1 && c <= N)
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);
		board = new int[N + 2][N + 2];
		int point = 0;

		for (int r = 1; r <= N; r++) {
			String[] aline = br.readLine().split(" ");
			for (int c = 1; c <= N; c++) {
				board[r][c] = Integer.parseInt(aline[c - 1]);
			}
		}

		// BFS진입 판단 조건은 일반 블록이고 주위에 접근가능블록(같은 색 일반or무지개)가 하나라도 있을때
		// 블록수 2개이상을 보장하기 위함.
		while (true) {
			PriorityQueue<group> pq = new PriorityQueue<>();
			// 그룹 만들기
			for (int r = 1; r <= N; r++) {
				for (int c = 1; c <= N; c++) {
					// 일반블록이고
					if (board[r][c] >= 1) {
						// 주변에 접근 가능한 블록 있느냐
						boolean flag = false;
						for (int i = 0; i < 4; i++) {
							int rowD = r + dr[i];
							int colD = c + dc[i];
							if (BC(rowD, colD) && (board[rowD][colD] == 0 || board[rowD][colD] == board[r][c])) {
								flag = true;
							}
						}
						if (flag) {
							BFS(r, c, pq);
						}
					}
				}
			} // 그룹 만들기 끝
			// 만들 수 있는 그룹 없으면 게임 끝
			if (pq.isEmpty()) {
				break;
			}
			group curGrp = pq.poll();
			point += delete(curGrp);
			gravity();
			board = rotate();
			gravity();
		}
		
		bw.write(point+" ");
		bw.flush();

	}

	public static int[][] rotate() {
		int[][] tmp = new int[N + 2][N + 2];
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				tmp[N + 1 - c][r] = board[r][c];

			}
		}
		return tmp;
	}

	// 0이상의 값들만 영향을 받는다.
	public static void gravity() {
		for (int c = 1; c <= N; c++) {
			for (int r = N - 1; r >= 1; r--) {
				// 무지개와 일반 블록에 대해서만
				if (board[r][c] >= 0) {
					int curR = r;
					int curC = c;
					// 아래에 -1이상의 숫자를 만날때까지 내린다.
					// 이동할때 원래칸은 꼭 빈칸처리해주자.
					while (board[curR + 1][curC] == empty) {
						int tmp = board[curR][curC];
						board[curR][curC] = empty;
						curR++;
						board[curR][curC] = tmp;
					}
				}
			}
		}
	}

	// 선택한 블록그룹의 구성원들을 제거
	public static int delete(group curGrp) {
		List<coor> toDelete = curGrp.blockList;
		int B = toDelete.size();
		for (int i = 0; i < B; i++) {
			int r = toDelete.get(i).row;
			int c = toDelete.get(i).col;
			board[r][c] = empty;
		}
		return B * B;
	}

	// (str,stc)블럭이 속한 그룹 생성
	public static void BFS(int str, int stc, PriorityQueue<group> pq) {
		Queue<coor> Q = new LinkedList<>();
		boolean[][] check = new boolean[N + 2][N + 2];
		// Q에서 나와서 처리될때 blockList 진입
		List<coor> blockList = new ArrayList<>();
		int normalCnt = 0;
		int rainbowCnt = 0;
		int stColor = board[str][stc];

		// 첫 블록은 무조건 일반 블록이 되게 끔 했다.
		Q.add(new coor(str, stc));
		check[str][stc] = true;
		normalCnt++;

		// 그룹 구성 블럭들 모으는 중
		while (!Q.isEmpty()) {
			coor curr = Q.poll();
			blockList.add(curr);

			for (int i = 0; i < 4; i++) {
				int rowD = curr.row + dr[i];
				int colD = curr.col + dc[i];
				// BC 만족하고 방문하지 않았고 무지개 혹은 시작과 같은 색 일반 블록이다.
				if (BC(rowD, colD) && !check[rowD][colD] && (board[rowD][colD] == 0 || board[rowD][colD] == stColor)) {
					Q.add(new coor(rowD, colD));
					check[rowD][colD] = true;
					;
					if (board[rowD][colD] == 0) {
						rainbowCnt++;
					} else {
						normalCnt++;
					}
				}
			}
		}

		// 기준 블록 찾기
		coor mainBlock = findMain(blockList);
		int mainR = mainBlock.row;
		int mainC = mainBlock.col;

		// 그룹 크기
		int size = normalCnt + rainbowCnt;

		// PQ에 새로 만든 블록그룹 담기
		pq.add(new group(blockList, size, rainbowCnt, mainR, mainC));

	}

	public static coor findMain(List<coor> blockList) {
		coor mainBlock = new coor(100, 100);
		for (int i = 0; i < blockList.size(); i++) {
			// 기준 블록은 일반 블록만 가능
			if (board[blockList.get(i).row][blockList.get(i).col] > 0) {
				if (blockList.get(i).row < mainBlock.row) {
					// 객체 자체를 할당하지 말고 값만 옮겨주자. 혹시 섞일지 모르니까
					mainBlock.row = blockList.get(i).row;
					mainBlock.col = blockList.get(i).col;
				} else if (blockList.get(i).row == mainBlock.row) {
					if (blockList.get(i).col < mainBlock.col) {
						mainBlock.row = blockList.get(i).row;
						mainBlock.col = blockList.get(i).col;
					}
				}
			}
		}
		return mainBlock;
	}

	public static boolean BC(int r, int c) {
		if (r >= 1 && r <= N && c >= 1 && c <= N) {
			return true;
		} else {
			return false;
		}
	}

}
