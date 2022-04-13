package com.ssafy.boj.y22.m04.w2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_11726_2xN타일링_DP {
	public static long[] dpArr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 입력받기
		int N = Integer.parseInt(br.readLine());
		dpArr = new long[N + 1];
		// 출력
		bw.write(dp(N) + "\n");
		bw.flush();
	}

	public static long dp(int n) {
		switch (n) {
		case 1:
			return 1;
		case 2:
			return 2;
		}
		// 중복 계산 방지, 아직 결과를 얻은 적 없을때만 진입
		if (dpArr[n - 1] == 0) {
			dpArr[n - 1] = dp(n - 1);
		}
		if (dpArr[n - 2] == 0) {
			dpArr[n - 2] = dp(n - 2);
		}
		return (dpArr[n - 1] + dpArr[n - 2]) % 10007;
	}
}
//End