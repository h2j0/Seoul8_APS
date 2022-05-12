package com.ssafy.boj.y22.m04.w4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ_21610_마법사상어와비바라기 {

	// 문제의 방향숫자 % 8인 값을 사용
	public static int[] dr = { 1, 0, -1, -1, -1, 0, 1, 1 };
	public static int[] dc = { -1, -1, -1, 0, 1, 1, 1, 0 };
	public static int[] drX = { 1, -1, -1, 1 };
	public static int[] dcX = { -1, -1, 1, 1 };
	public static int r = 0;
	public static int c = 1;
	public static int[][] board;
	public static int N;
	public static int M;
	public static List<coor> cloud;

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

		String[] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);
		board = new int[N][N];
		// 구름조각 정보 저장
		cloud = new ArrayList<>();
		// board 정보
		for (int row = 0; row < N; row++) {
			String[] aline = br.readLine().split(" ");
			for (int col = 0; col < N; col++) {
				board[row][col] = Integer.parseInt(aline[col]);
			}
		}

		// 첫 구름
		cloud.add(new coor(N - 1, 0));
		cloud.add(new coor(N - 1, 1));
		cloud.add(new coor(N - 2, 0));
		cloud.add(new coor(N - 2, 1));

		// 각 명령
		for (int oc = 0; oc < M; oc++) {
			String[] order = br.readLine().split(" ");
			int d = Integer.parseInt(order[0])%8;
			int s = Integer.parseInt(order[1]);
			cloudMv(d, s);
			rain();
			waterBug();
			makeCloud();
		}

		bw.write(leftOver() + "\n");
		bw.flush();
	}
	
	public static int leftOver() {
		int sum=0;
		for(int r= 0; r<N; r++) {
			for(int c=0; c<N;c++) {
				sum+= board[r][c];
			}
		}
		return sum;
	}
	

	public static void makeCloud() {
		// 원래 있던 구름칸은 check배열에 표시하고 말소하고
		// 구름 생성 조건에 check배열이 표시되지 않은 것이라는 조건을 추가한다.
		boolean [][] check = new boolean[N][N];
		while(!cloud.isEmpty()) {
			coor curr = cloud.remove(0);
			check[curr.row][curr.col]=true;
		}
		// cloud가 텅 비었음
		for(int r= 0; r<N; r++) {
			for(int c=0; c<N;c++) {
				// 이전에 있었던 구름이 아니고 물의 양이 2이상인 모든 칸
				if(!check[r][c] && board[r][c]>=2) {
					// 구름 생성
					cloud.add(new coor(r,c));
					// 물의 양이 2 줄어든다.
					board[r][c]-=2;
				}
			}
		}
	}
	
	public static void waterBug() {
		for (int i = 0; i < cloud.size(); i++) {
			int curR = cloud.get(i).row;
			int curC = cloud.get(i).col;

			// 대각에 물이 있는 바구니 수
			int cnt = 0;
			for(int x=0; x<4;x++) {
				int adjR = curR+drX[x];
				int adjC = curC+dcX[x];
				if(BC(adjR,adjC) && board[adjR][adjC]>0) {
					cnt++;
				}
			}
			// 해당 칸 물 증가
			board[curR][curC] += cnt;
		}
	}
	
	public static boolean BC(int row, int col) {
		if(row>=0 && row <N && col>=0 && col<N) {
			return true;
		}else {
			return false;
		}
		
	}

	public static void cloudMv(int d, int s) {
		// 모든 구름
		for (int i = 0; i < cloud.size(); i++) {
			// 음수도 modulo로 board 이어붙인 것처럼 인덱스할려면 추가적인 처리를 해줘야 한다.
			int newR = cloud.get(i).row + dr[d] * s;
			int newC = cloud.get(i).col + dc[d] * s;

			// 음수처리
			if (newR < 0) {
				while (!(newR >= 0 && newR <= N - 1)) {
					newR += N;
				}
			}
			if (newC < 0) {
				while (!(newC >= 0 && newC <= N - 1)) {
					newC += N;
				}
			}
			cloud.get(i).row = (newR) % N;
			cloud.get(i).col = (newC) % N;
		}
	}

	public static void rain() {
		// 구름 있는 곳에 비 내리기
		for (int i = 0; i < cloud.size(); i++) {
			board[cloud.get(i).row][cloud.get(i).col] += 1;
		}
	}

}
//End