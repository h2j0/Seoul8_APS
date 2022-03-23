package week08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj1654 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] kn = br.readLine().split(" ");
		int k = Integer.parseInt(kn[0]);
		int n = Integer.parseInt(kn[1]);
		long[] ks = new long[k];
		long left = 1;
		long right = 0;

		for (int i = 0; i < k; i++) {
			ks[i] = Integer.parseInt(br.readLine());
			right += ks[i];
		}
		right /= n;
		long mid;
		long ans = 0;

		while (left <= right) {
			mid = (left + right) / 2;
			long nMid = 0;
			for (int i = 0; i < k; i++) {
				nMid += ks[i] / mid;
			}
			if (nMid < n) {
				right = mid - 1;
			} else {
				left = mid + 1;
				ans = mid;
			}
		}
		System.out.println(ans);

	}

}
