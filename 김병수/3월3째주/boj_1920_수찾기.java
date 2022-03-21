package com.ssafy.boj.y22.m03.w3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class boj_1920_수찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// N 관련 입력
		int N = Integer.parseInt(br.readLine());
		String[] nArr = br.readLine().split(" ");
		int[] nArrInt = new int[N];
		for (int nIdx = 0; nIdx < N; nIdx++) {
			nArrInt[nIdx] = Integer.parseInt(nArr[nIdx]);
		}
		// 오름차순 정렬
		// 숫자가 String이여도 정렬을 해주긴 한다.
		Arrays.sort(nArrInt);

		// M 관련 입력
		int M = Integer.parseInt(br.readLine());
		String[] mArr = br.readLine().split(" ");
		int[] mArrInt = new int[M];
		for (int mIdx = 0; mIdx < M; mIdx++) {
			mArrInt[mIdx] = Integer.parseInt(mArr[mIdx]);
		}
		// 탐색 결과 저장
		int[] result = new int[M];

		// 이진탐색
		for (int m = 0; m < M; m++) {
			int highIdx = N - 1;
			int lowIdx = 0;
			int midIdx = (highIdx + lowIdx) / 2;
			while (lowIdx <= highIdx) {
				if (mArrInt[m] == nArrInt[midIdx]) {
					result[m] = 1;
					break;
				} else if (mArrInt[m] > nArrInt[midIdx]) {
					lowIdx = midIdx + 1;
				} else {
					highIdx = midIdx - 1;
				}
				midIdx = (highIdx + lowIdx) / 2;
			}
		}

		// 출력
		for (int m = 0; m < M; m++) {
			bw.write(result[m] + "\n");
		}
		bw.flush();
		bw.close();
	}
}
// End
