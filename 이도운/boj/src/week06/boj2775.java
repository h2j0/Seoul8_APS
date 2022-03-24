package week06;

import java.util.Scanner;

public class boj2775 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 0; tc < T; tc++) {
			int k = sc.nextInt();
			int n = sc.nextInt();

			int[] f0 = new int[n];
			for (int i = 0; i < n; i++) {
				f0[i] = i + 1;
			}
			
			for (int i = 1; i <= k; i++) {
				int[] fi = new int[n];
				fi[0] = f0[0];
				for (int j = 1; j < n; j++) {
					fi[j] = fi[j-1]+f0[j];
				}
				for (int j=0; j<n; j++) {
					f0[j] = fi[j];
				}
			}
			System.out.println(f0[n-1]);
		}

	}

}
