package week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class boj9019 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		String[] order = { "D", "S", "L", "R" };

		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			int[][] cnt = new int[10000][2];
			boolean[] visited = new boolean[10000];

			Deque<Integer> dq = new ArrayDeque<>();
			dq.add(a);
			visited[a] = true;

			while (!dq.isEmpty()) {
				int node = dq.pollFirst();
				if (node == b) {
					break;
				}
				int[] nextNode = dslr(node);
				for (int j = 0; j < 4; j++) {
					if (!visited[nextNode[j]]) {
						cnt[nextNode[j]][0] = node;
						cnt[nextNode[j]][1] = j;

						visited[nextNode[j]] = true;
						dq.add(nextNode[j]);
					}
				}
			}
			StringBuilder sb = new StringBuilder();
			int idx = b;
			while(cnt[idx][0]!=a) {
				sb.append(order[cnt[idx][1]]);
				idx = cnt[idx][0];
			}
			sb.append(order[cnt[idx][1]]).reverse();
			System.out.println(sb);

		}

	}

	static int[] dslr(int x) {
		int[] res = new int[4];
		if (2 * x > 9999) {
			res[0] = (2 * x) % 10000;
		} else {
			res[0] = 2 * x;
		}
		if (x == 0) {
			res[1] = 9999;
		} else {
			res[1] = x - 1;
		}
		res[2] = x / 1000 + (x % 1000) * 10;
		res[3] = (x % 10) * 1000 + x / 10;
		return res;
	}

}
