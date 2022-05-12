package com.ssafy.boj.y22.m04.w4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_17779_게리맨더링2 {
	public static int N;
	public static int mindiff;
	// 좌하,우하,우상,좌상(경계선 만들기 대각선 이동용)
	public static int[] drX = { 1, 1, -1, -1 };
	public static int[] dcX = { -1, 1, 1, -1 };

	// 우,상,좌,하
	public static int[] dr = { 0, -1, 0, 1 };
	public static int[] dc = { 1, 0, -1, 0 };

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

		N = Integer.parseInt(br.readLine());
		// 크기 1 패딩
		int[][] board = new int[N + 2][N + 2];
		for (int row = 1; row <= N; row++) {
			String[] aline = br.readLine().split(" ");
			for (int col = 1; col <= N; col++) {
				board[row][col] = Integer.parseInt(aline[col - 1]);
			}
		}

		mindiff = Integer.MAX_VALUE;

		// 고려 범위는 1부터 N까지.
		// r,c는 2중 for문으로 가능한 모든 친구로 한다.
		// 일단 d1,d2를 계속 늘려보고 범위 밖으로 나가는 경우 컷하자.
		// 맨아래 2행과 좌우 양끝 열은 경계선을 만들 수 없다.
		for (int row = 1; row <= N - 2; row++) {
			for (int col = 2; col <= N - 1; col++) {
				// 시작점 위치 선정완료
				// 경계선 만들기, 일단 길이는 최대한으로 마음껏 가게하고
				// 조건에 맞지 않는 경계선은 튕겨져 나가게끔한다.
				for (int da = 1; da <= N; da++) {
					for (int db = 1; db <= N; db++) {
						int[][] zone = new int[N + 2][N + 2];
						// 경계선이 board 밖으로 나가면
						try {
							boundary(row, col, da, db, zone);
						} catch (ArrayIndexOutOfBoundsException e) {
							// 이번 경우는 계산하지 않고 넘어가겠다.
							continue;
						}
						full(row, col, da, db, zone);
						othersFull(row, col, da, db, zone);
						calcu(board, zone);
					}
				}
			}
		}

		bw.write(mindiff + "\n");
		bw.flush();
	}

	public static boolean BC(int row, int col) {
		if (row >= 1 && row <= N && col >= 1 && col <= N) {
			return true;
		} else {
			return false;
		}

	}

	public static void calcu(int[][] board, int[][] zone) {
		int[] elec = new int[6];
		// 분배
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				switch (zone[r][c]) {
				case 1:
					elec[1] += board[r][c];
					break;
				case 2:
					elec[2] += board[r][c];
					break;
				case 3:
					elec[3] += board[r][c];
					break;
				case 4:
					elec[4] += board[r][c];
					break;
				case 5:
					elec[5] += board[r][c];
					break;
				}
			}
		}

		int max = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= 5; i++) {
			if (elec[i] < min) {
				min = elec[i];
			}
			if (elec[i] > max) {
				max = elec[i];
			}
		}
		if ((max - min) < mindiff) {
			mindiff = (max - min);
		}

	}

	// 경계선 만들기
	public static boolean boundary(int r, int c, int d1, int d2, int[][] zone) {
		int curR = r;
		int curC = c;

		for (int i = 0; i < d1; i++) {
			zone[curR][curC] = 5;
			curR += drX[0];
			curC += dcX[0];
		}

		for (int i = 0; i < d2; i++) {
			zone[curR][curC] = 5;
			curR += drX[1];
			curC += dcX[1];
		}

		for (int i = 0; i < d1; i++) {
			zone[curR][curC] = 5;
			curR += drX[2];
			curC += dcX[2];
		}

		for (int i = 0; i < d2; i++) {
			zone[curR][curC] = 5;
			curR += drX[3];
			curC += dcX[3];
		}

		return true;
	}

	// 경계선 내부를 5로 채우기
	public static void full(int r, int c, int d1, int d2, int[][] zone) {
		// 두 5 사이의 모든 칸을 5로 만든다.
		// 행은 5가 두개있는 행들이다.
		for (int row = r + 1; row <= r + d1 + d2 - 1; row++) {
			boolean flag = false;
			for (int col = 1; col <= N; col++) {
				if (zone[row][col] == 5) {
					flag = !flag;
				} else if (flag) {
					zone[row][col] = 5;
				}

			}

		}
	}


	// 5번 제외 나머지 선거구 채우기
	public static void othersFull(int x, int y, int d1, int d2, int[][] zone) {
		// 1번 선거구 배정
		for (int r = 1; r < x + d1; r++) {
			for (int c = 1; c <= y; c++) {
				if (zone[r][c] != 5) {
					zone[r][c] = 1;
				}
			}
		}
		// 2번 선거구 배정
		for (int r = 1; r <= x + d2; r++) {
			for (int c = y + 1; c <= N; c++) {
				if (zone[r][c] != 5) {
					zone[r][c] = 2;
				}
			}
		}
		// 3번 선거구 배정
		for (int r = x + d1; r <= N; r++) {
			for (int c = 1; c < y - d1 + d2; c++) {
				if (zone[r][c] != 5) {
					zone[r][c] = 3;
				}
			}
		}
		// 4번 선거구 배정
		for (int r = x + d2 + 1; r <= N; r++) {
			for (int c = y - d1 + d2; c <= N; c++) {
				if (zone[r][c] != 5) {
					zone[r][c] = 4;
				}
			}
		}
	}

}
//End