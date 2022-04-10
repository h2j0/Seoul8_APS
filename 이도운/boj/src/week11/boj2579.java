package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2579 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] score = new int[N];
		for (int i = 0; i < N; i++) {
			score[i] = Integer.parseInt(br.readLine());
		}

		if (N > 2) {
			int[] dp = new int[N];
			dp[0] = score[0];
			dp[1] = score[0] + score[1];
			dp[2] = ((score[0] > score[1]) ? score[0] : score[1]) + score[2];

			for (int i = 3; i < N; i++) {
				int tmp1 = dp[i - 2] + score[i];
				int tmp2 = dp[i - 3] + score[i - 1] + score[i];
				dp[i] = (tmp1 > tmp2) ? tmp1 : tmp2;
			}
			System.out.println(dp[N-1]);

		} else {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				sum += score[i];
			}
			System.out.println(sum);
		}

	}

}
