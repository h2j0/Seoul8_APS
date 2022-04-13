package com.ssafy.boj.y22.m04.w2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2579_계단오르기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 입력받기
		int N = Integer.parseInt(br.readLine());
		// idx1부터 쓴다
		int [] point = new int[301];
		for(int i=1; i<=N; i++) {
			point[i] = Integer.parseInt(br.readLine());
		}
		// [0] : i번째를 안밟음
		// [1] : i번째를 처음밟음
		// [2] : i번째를 연속해서 밟음
		// 1칸Jump의 연속횟수로 하나의 계단에 대해 경우를 나눔.
		// 경우에 따른 각 계단의 누적 점수
		int [][] dp = new int[301][3];
		for(int i=1; i<=N; i++) {
			// 현재를 안밟는 경우는 이전 계단에서 2칸을 뛰는 상황이고
			// 이전계단에서 2칸을 뛰는 상황은 이전계단이 처음밟거나 연속해서 밟은 경우.
			// 안밟음 경우는 현재 계단의 값을 더하지 않는다.
			dp[i][0] = Math.max(dp[i-1][1], dp[i-1][2]);
			dp[i][1] = dp[i-1][0]+point[i];
			dp[i][2] = dp[i-1][1]+point[i];
		}
		
		// 출력
		bw.write(Math.max(dp[N][1],dp[N][2])+"\n");
		bw.flush();
	}

}
//End