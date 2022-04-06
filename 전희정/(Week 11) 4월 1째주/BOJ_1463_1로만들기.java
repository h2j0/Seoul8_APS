package BOJ.Study.Week11_Apr1st;

import java.util.Scanner;

public class BOJ_1463_1로만들기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[n + 1];
		dp[1] = 0;

		for (int i = 2; i <= n; i++) {
			// 1 빼주는 연산이니까 연산 횟수는 내 앞칸애에서 연산횟수 1 증가
			dp[i] = dp[i - 1] + 1;

			// 2나눠주는 연산이니까 나/2번째 애에서 연산횟수 1증가
			// 동시에 내 앞칸애에서 +1 : 연산횟수 1증가이니까 둘 중에 작은애가 들어간다
			if (i % 2 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 2] + 1);
			}
			// 3나눠주는 연산이니까 나/3번째 애에서 연산횟수 1증가
			// 동시에 내 앞칸애에서 +1 : 연산횟수 1증가이니까 둘 중에 작은애가 들어간다
			if (i % 3 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 3] + 1);
			}
		}

		System.out.println(dp[n]);
	}
}
