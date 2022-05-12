package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class boj1697 {
	static int n, k;
	static int[] cnt;
	static int maxlevel = 100000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		cnt = new int[maxlevel + 1];
		Deque<Integer> q = new ArrayDeque<>();
		q.offer(n);
		while (!q.isEmpty()) {
			int x = q.pollFirst();
			if (x == k) {
				System.out.println(cnt[x]);
				break;
			}
			int[] t = {x-1, x+1, 2*x};
			for (int j = 0; j<3; j++) {
				if (0 <= t[j] && t[j] <= maxlevel && cnt[t[j]] == 0) {
					cnt[t[j]] = cnt[x] + 1;
					q.offer(t[j]);
				}
			}
		}

	}
}
