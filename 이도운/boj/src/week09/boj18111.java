package week09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj18111 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] nmb = br.readLine().split(" ");
		int n = Integer.parseInt(nmb[0]);
		int m = Integer.parseInt(nmb[1]);
		int b = Integer.parseInt(nmb[2]);

		int[] tile = new int[n * m];

		for (int i = 0; i < n; i++) {
			String[] ipt = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				tile[i * m + j] = Integer.parseInt(ipt[j]);
			}
		}

		int ans = Integer.MAX_VALUE;
		int height = 0;

		for (int h = 256; h >= 0; h--) {
			int temp = 0;
			int usedblock = 0;

			for (int i = 0; i < n * m; i++) {
				if (tile[i] < h) {
					temp += h - tile[i];
					usedblock += h - tile[i];
				} else {
					temp += 2 * (tile[i] - h);
					usedblock -= tile[i] - h;
				}
			}
			if (usedblock <= b && temp < ans) {
				ans = temp;
				height = h;
			}

		}
		System.out.println(ans+" "+height);

	}

}
