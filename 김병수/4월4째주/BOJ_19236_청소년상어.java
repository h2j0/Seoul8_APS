package com.ssafy.boj.y22.m04.w4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_19236_청소년상어 {


	public static int shark = 99;
	// 0-우상,1-상,2-좌상....문제에서 8방향은 여기서 idx0...고로 dir%8한 것을 idx로 써야함.
	public static int[] dr = { -1, -1, -1, 0, 1, 1, 1, 0 };
	public static int[] dc = { 1, 0, -1, -1, -1, 0, 1, 1 };
	public static int maxSum;

	public static class fish implements Comparable<fish> {
		public int num;
		public int dir;

		public fish(int num, int dir) {
			this.num = num;
			this.dir = dir;

		}
		

		@Override
		public String toString() {
			return "fish [num=" + num + ", dir=" + dir + "]";
		}


		@Override
		public int compareTo(fish o) {
			// TODO Auto-generated method stub
			return this.num - o.num;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 입력받기
		fish[][] board = new fish[4][4];
		for (int row = 0; row < 4; row++) {
			String[] aline = br.readLine().split(" ");
			for (int col = 0; col < 4; col++) {
				board[row][col] = new fish(Integer.parseInt(aline[col * 2 + 0]),
						Integer.parseInt(aline[col * 2 + 1]) % 8);
			}
		}

		// 게임 시작
		 maxSum = 0;
		 game(0,0,0,cpy(board));

		
		bw.write(maxSum + "\n");
		bw.flush();

	}
	public static fish [][] cpy(fish [][] board){
		fish [][] copy = new fish[4][4];
		for (int row = 0; row < 4; row++) {
			for (int col = 0; col < 4; col++) {
				copy[row][col] = new fish(board[row][col].num,board[row][col].dir);
			}
		}
		return copy;
	}
	
	
	public static void game(int r, int c, int sumVal, fish [][] board) {
		// 파라미터 받은 위치로 상어 이동
		int get = board[r][c].num;
		int dir = board[r][c].dir;
		board[r][c] = new fish(shark, dir);

		shake(board);
		
		// 상어 있던 곳 비우기
		board[r][c] = new fish(111,-1);
		// 상어 이동 파라미터 주기
		for(int len=1;len<=3;len++) {
			// delta가 범위안에 있고 비어있지 않으면 거기로 가라
			if(r+dr[dir]*len >= 0 && r+dr[dir]*len < 4 && c+dc[dir]*len  >= 0 && c+dc[dir]*len < 4 && board[r+dr[dir]*len][c+dc[dir]*len].num!=111) {
				game(r+dr[dir]*len,c+dc[dir]*len,sumVal+get,cpy(board));
			}
		}
		// 더 이상 갈데가 없으면
		maxSum = Math.max(maxSum, sumVal+get);
	}
	
	public static void shake(fish [][] board) {
		// 16회 순서대로 이동을 위한 check배열
		boolean[] check = new boolean[120];
		// 물고기 이동 16회
		for (int i = 0; i < 16; i++) {
			// 최소찾기
			int minVal = 100;
			int minR = 100;
			int minC = 100;
			for (int row = 0; row < 4; row++) {
				for (int col = 0; col < 4; col++) {
					if (!check[board[row][col].num] && board[row][col].num < minVal) {
						minVal = board[row][col].num;
						minR = row;
						minC = col;
					}
				}
			}
			// 물고기가 아니면 pass
			if(board[minR][minC].num>16) {
				continue;
			}
			check[board[minR][minC].num] = true;
			// 이번 이동할 물고기
			move(minR,minC,board);
		}
	}

	public static void move(int r, int c, fish[][]board) {
		// 이동 방향 정하기
		// 이동 가능 하냐
		// 8번 확인
		int times = 8;
		while (times > 0) {
			int rowD = r + dr[board[r][c].dir];
			int colD = c + dc[board[r][c].dir];
			// 가능하면 교환
			if (rowD >= 0 && rowD < 4 && colD >= 0 && colD < 4 && board[rowD][colD].num != shark) {
				fish tmp = board[rowD][colD];
				board[rowD][colD] = board[r][c];
				board[r][c] = tmp;
				break;
				// 불가능하면
			} else {
				board[r][c].dir = (board[r][c].dir + 1) % 8;
			}
			times--;
		}
	}
}
//End