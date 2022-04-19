package Apr_3rd_Week;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj11727_2xn타일링2 {
	static int[] dp = new int[1001];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		tile(n);

		System.out.println(dp[n]);

	}

	private static int tile(int n) {
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 3;

		for (int i = 3; i <= n; i++) {
			dp[i] = (dp[i - 1] + (dp[i - 2] * 2)) % 10007;
		}

		return dp[n];
	}

}
