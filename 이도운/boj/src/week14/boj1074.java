package week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1074 {
	static int n, r, c;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		int[] coord = new int[4];
		coord[1] = 1;
		coord[3] = 1;
		for (int i = 0; i < n; i++) {
			coord[1] *= 2;
			coord[3] *= 2;
		}
		coord[1] -= 1;
		coord[3] -= 1;
		int ans = 0;

		while (coord[0] != coord[1]) {
			int[] tc = quad(coord);
			for (int i = 0; i < 4; i++) {
				coord[i] = tc[i];
			}
			ans += tc[4];
		}
		System.out.println(ans);

	}

	static int[] quad(int[] arr) {
		int ri = arr[0];
		int re = arr[1];
		int ci = arr[2];
		int ce = arr[3];
		int nquad = ((re - ri) + 1) * ((ce - ci) + 1) / 4;

		int[] ans = new int[5];

		if (r <= (ri + re) / 2 && c <= (ci + ce) / 2) {
			ans[0] = ri;
			ans[1] = (ri + re) / 2;
			ans[2] = ci;
			ans[3] = (ci + ce) / 2;
			ans[4] = 0;
		} else if (r <= (ri + re) / 2 && c > (ci + ce) / 2) {
			ans[0] = ri;
			ans[1] = (ri + re) / 2;
			ans[2] = (ci + ce) / 2 + 1;
			ans[3] = ce;
			ans[4] = nquad;
		} else if (r > (ri + re) / 2 && c <= (ci + ce) / 2) {
			ans[0] = (ri + re) / 2 + 1;
			ans[1] = re;
			ans[2] = ci;
			ans[3] = (ci + ce) / 2;
			ans[4] = nquad * 2;
		} else {
			ans[0] = (ri + re) / 2 + 1;
			ans[1] = re;
			ans[2] = (ci + ce) / 2 + 1;
			ans[3] = ce;
			ans[4] = nquad * 3;
		}
		return ans;
	}

}
