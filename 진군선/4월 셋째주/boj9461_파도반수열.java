package Apr_3rd_Week;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj9461_파도반수열 {
	static long[] dp = new long[101]; // 숫자를 그대로 쓰기 위해 한칸 더 크게 받음

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < t; tc++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(wave(n)).append("\n");
		}
		System.out.println(sb);

	}

	private static long wave(int n) {
		// bottom-up 방식
		dp[1] = dp[2] = dp[3] = 1;
		dp[4] = dp[5] = 2;

		for (int i = 6; i <= n; i++) {
			dp[i] = dp[i - 5] + dp[i - 1];
		}

		return dp[n];
	}

}
