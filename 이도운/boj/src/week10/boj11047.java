package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj11047 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] coin = new int[n];
		for (int i = 0; i < n; i++) {
			coin[n - 1 - i] = Integer.parseInt(br.readLine());
		}
		int rest = k;
		int ans = 0;
		int idx = 0;
		

		while (rest > 0 && idx < n) {
			if (rest < coin[idx]) {
				idx++;
			} else {
				ans += rest/coin[idx];
				rest %= coin[idx];
				idx++;
			}
		}
		System.out.println(ans);

	}

}
