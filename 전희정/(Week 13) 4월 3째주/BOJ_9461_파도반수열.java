package BOJ;

import java.util.Scanner;

public class BOJ_9461_파도반수열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			long[] P = new long[101];
			P[1] = P[2] = P[3] = 1;
			P[4] = 2;
			if (N >= 5) {
				for (int i = 5; i <= N; i++) {
					P[i] = P[i - 1] + P[i - 5];
				}
			}
			System.out.println(P[N]);

		}

	}
}
