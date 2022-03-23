package week08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj11050 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nk = br.readLine().split(" ");
		int n = Integer.parseInt(nk[0]);
		int k = Integer.parseInt(nk[1]);

		k = (n - k < k) ? n - k : k;

		int ans = 1;

		for (int i = 0; i < k; i++) {
			ans *= (n - i);
			ans /= (i + 1);
		}
		System.out.println(ans);

	}

}
