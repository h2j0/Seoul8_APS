package com.ssafy.boj.y22.m05.w1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BOJ_1074_Z {
	public static long result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] Nrc = br.readLine().split(" ");
		int N = Integer.parseInt(Nrc[0]);
		int r = Integer.parseInt(Nrc[1]);
		int c = Integer.parseInt(Nrc[2]);
		int boardSize = (int) Math.pow(2, N);
		quard(0, 0, boardSize,r,c,0);
		System.out.println(result);

	}

	// 기준점은 해당면의 가장 좌상단 원소
	public static void quard(long row, long col, long len, int tr, int tc, long sum) {
		// 4칸짜리에 도착
		if (len == 2) {
			if(row == tr && col == tc) {
				result = sum;
			}else if(row == tr && col+1 == tc) {
				result = sum+1;
			}else if(row+1 == tr && col == tc) {
				result = sum+2;
			}else if(row+1 == tr && col+1 == tc) {
				result = sum+3;
			}
			return;
		} else {
			long cenR = row + len / 2;
			long cenC = col + len / 2;
			long halfLen = len/2;
			if (tr < cenR && tc < cenC) {
				// 좌상면
				quard(row, col, halfLen, tr, tc, sum);
			}
			else if (tr < cenR&& tc >= cenC) {
				// 우상면
				quard(row, cenC, halfLen, tr, tc, sum + len * len / 4);
			}
			else if (tr >= cenR && tc < cenC) {
				// 좌하면
				quard(cenR, col, halfLen, tr, tc, sum + len * len * 2 / 4);
			}
			else if (tr >= cenR && tc >= cenC) {
				// 우하면
				quard(cenR, cenC, halfLen, tr, tc, sum + len * len * 3 / 4);
			}
		}
	}
}
//End