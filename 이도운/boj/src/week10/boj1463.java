package week10;

import java.io.IOException;
import java.util.Scanner;

public class boj1463 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] dp = new int[N + 1];

		if (N < 4) {
			if (N == 1) {
				System.out.println(0);
			} else {
				System.out.println(1);
			}
		} else {
			dp[2] = 1;
			dp[3] = 1;
			dp[4] = 2;

			for (int i = 5; i < N + 1; i++) {
				int tempDP = Integer.MAX_VALUE;
				if (i % 3 == 0) {
					tempDP = (dp[i / 3] + 1 < tempDP) ? dp[i / 3] + 1 : tempDP;
				}
				if (i % 2 == 0) {
					tempDP = (dp[i / 2] + 1 < tempDP) ? dp[i / 2] + 1 : tempDP;
				}
				tempDP = (dp[i - 1] + 1 < tempDP) ? dp[i - 1] + 1 : tempDP;
				dp[i] = tempDP;
			}
			System.out.println(dp[N]);

		}
	}
}
