package com.ssafy.boj.y22.m04.w3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_9461_파도반수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			// 입력받기
			int N = Integer.parseInt(br.readLine());
			
			long [] dp = new long [101];
			dp[1] = 1; dp[2] = 1; dp[3] = 1; dp[4] = 2; dp[5] = 2; 
			
			for(int i = 6; i<=N; i++) {
				dp[i]=dp[i-1]+dp[i-5];
			}
			
			// 출력
			bw.write(dp[N] + "\n");
		}
		bw.flush();
	}
}
//End