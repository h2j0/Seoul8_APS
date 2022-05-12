package week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class boj11403 {
	static int n;
	static int[][] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		graph = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < n; i++) {
			int[] pos = search(i);
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < n; j++) {
				sb.append(pos[j] + " ");
			}
			sb.toString().trim();
			System.out.println(sb);
		}

	}

	static int[] search(int root) {
		int[] visited = new int[n];
		Deque<Integer> dq = new ArrayDeque<>();
		dq.add(root);

		while (!dq.isEmpty()) {
			int node = dq.pollFirst();
			for (int i = 0; i < n; i++) {
				if (graph[node][i] == 1 && visited[i] == 0) {
					dq.add(i);
					visited[i] = 1;
				}
			}
		}
		return visited;

	}

}
