package BOJ.Study.Week11_Apr1st;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9095_123더하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// dp 배열 먼저 생성
		int[] dp = new int[11];
		dp[1] = 1; // (1)
		dp[2] = 2; // (1+1), (2)
		dp[3] = 4; // (1+1+1), (1+2), (2+1), (3)

		for (int i = 4; i < 11; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		} // dp 배열 생성 완

		// 테케 입력
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(dp[n]).append("\n");
		}
		System.out.println(sb);
	}

}
