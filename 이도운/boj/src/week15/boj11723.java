package week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj11723 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		int[] s = new int[21];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
			case "add":
				s[Integer.parseInt(st.nextToken())] = 1;
				break;
			case "remove":
				s[Integer.parseInt(st.nextToken())] = 0;
				break;
			case "check":
				sb.append(s[Integer.parseInt(st.nextToken())] + "\n");
				break;
			case "toggle":
				int idx = Integer.parseInt(st.nextToken());
				s[idx] = 1 - s[idx];
				break;
			case "all":
				for (int j = 0; j < 21; j++) {
					s[j] = 1;
				}
				break;
			case "empty":
				for (int j = 0; j < 21; j++) {
					s[j] = 0;
				}
				break;
			}
		}
		System.out.println(sb);

	}

}
