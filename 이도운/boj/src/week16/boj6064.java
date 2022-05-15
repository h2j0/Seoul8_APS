package week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj6064 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = x - y;

			int g = gcd(m, n);
			int a = exEuclid(m, n);

			if (d % g == 0) {
				long k = d / g;
				long kk = x - (k * a * m) - 1;
				while (kk < 0) {
					kk += ((m / g) * n);
				}
				long ans = kk % ((m / g) * n) + 1;
				System.out.println(ans);
			} else {
				System.out.println(-1);
			}
		}

	}

	static int gcd(int x, int y) {
		while (y > 0) {
			int tmp = x;
			x = y;
			y = tmp % y;
		}
		return x;
	}

	static int lcm(int x, int y) {
		int res = x * y / gcd(x, y);
		return res;
	}

	static int exEuclid(int a, int b) {
		int x0 = 1;
		int x1 = 0;
		int y0 = 0;
		int y1 = 1;

		while (b != 0) {
			int n = a / b;
			int tmp = a;
			a = b;
			b = tmp % b;

			tmp = x0;
			x0 = x1;
			x1 = tmp - n * x1;

			tmp = y0;
			y0 = y1;
			y1 = tmp - n * y1;
		}

		return x0;
	}

}
