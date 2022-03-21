package com.ssafy.boj.y22.m03.w3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class boj_1018_체스판다시칠하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] nArr = br.readLine().split(" ");
		int black = 1;
		int white = 0;

		int N = Integer.parseInt(nArr[0]);
		int M = Integer.parseInt(nArr[1]);
		String[] mArr = new String[M];
		int[][] board = new int[N][M];
		for (int n = 0; n < N; n++) {
			mArr = br.readLine().split("");
			for (int m = 0; m < M; m++) {
				if (mArr[m].equals("B")) {
					board[n][m] = black;
				} else {
					board[n][m] = white;
				}
			}
		}

		// 블랙 커널
		int[][] bKernel = new int[8][8];
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				bKernel[row][col] = (row + col + 1) % 2;

			}
		}
		// 화이트 커널
		int[][] wKernel = new int[8][8];
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				wKernel[row][col] = (row + col) % 2;

			}
		}

		int minVal = 64;
		// 8x8로 전부 스캔
		for (int n = 0; n <= N - 8; n++) {
			for (int m = 0; m <= M - 8; m++) {
				// 블랙커널로 한번
				int sum = 0;
				for (int row = 0; row < 8; row++) {
					for (int col = 0; col < 8; col++) {
						sum += board[n + row][m + col] ^ bKernel[row][col];
					}
				}
				if (sum < minVal) {
					minVal = sum;
				}
				// 화이트커널로 한번
				sum = 0;
				for (int row = 0; row < 8; row++) {
					for (int col = 0; col < 8; col++) {
						sum += board[n + row][m + col] ^ wKernel[row][col];
					}
				}
				if (sum < minVal) {
					minVal = sum;
				}
			}
		}

//		// 디버깅용
//		for(int n=0; n<N; n++) {
//			for(int m=0; m<M; m++) {
//				System.out.print(bKernel[n][m]+" ");
//			}
//			System.out.println();
//		}

		// 출력
		bw.write(minVal + "\n");
		bw.flush();
		bw.close();
	}
}
// End
