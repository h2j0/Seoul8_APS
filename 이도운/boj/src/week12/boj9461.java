package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj9461 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		long[] p = new long[101];
		p[1] = 1;
		p[2] = 1;
		p[3] = 1;
		p[4] = 2;
		p[5] = 2;
		for (int i = 6; i < 101; i++) {
			p[i] = p[i - 1] + p[i - 5];
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(p[n]+"\n");
		}
		System.out.println(sb);

	}

}
