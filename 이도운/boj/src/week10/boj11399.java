package week10;

import java.util.Arrays;
import java.util.Scanner;

public class boj11399 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] p = new int[n];
		for (int i = 0; i < n; i++) {
			p[i] = sc.nextInt();
		}
		Arrays.sort(p);

		int[] ans = new int[n];
		ans[0] = p[0];

		for (int i = 1; i < n; i++) {
			ans[i] = p[i] + ans[i - 1];
		}
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += ans[i];
		}
		System.out.println(sum);
	}

}
