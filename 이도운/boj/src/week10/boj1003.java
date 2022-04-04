package week10;

import java.util.Scanner;

public class boj1003 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t;
		int n;
		StringBuilder sb = new StringBuilder();

		int[] check = new int[43];
		t = sc.nextInt();
		for (int i = 0; i < 43; i++) {
			check[i] = 0;
		}
		check[0] = 1;
		check[1] = 1;
		check[2] = 1;

		int[][] dp = new int[41][2];
		dp[0][0] = 1;
		dp[1][1] = 1;
		dp[2][0] = 1;
		dp[2][1] = 1;

		for (int i = 3; i < 41; i++) {
			dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
			dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
		}

		for (int i = 0; i < t; i++) {
			sc.nextLine();
			n = sc.nextInt();
			sb.append(dp[n][0] + " " + dp[n][1]);
			System.out.println(sb);
			sb = new StringBuilder();
		}
	}

}
