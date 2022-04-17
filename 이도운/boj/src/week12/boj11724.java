package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj11724 {
	static int N, M;
	static int[][] tree;
	static int[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		tree = new int[N + 1][N + 1];
		visited = new int[N + 1];
		visited[0] = 1;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			tree[u][v] = 1;
			tree[v][u] = 1;
		}
		int cnt = 0;
		for (int i = 0; i <= N; i++) {
			if (visited[i] == 0) {
				dfs(i);
				cnt++;
			}
		}
		System.out.println(cnt);
	}

	static void dfs(int root) {
		Stack<Integer> q = new Stack<>();
		q.add(root);

		while (!q.isEmpty()) {
			int node = q.pop();
			for (int i = 1; i <= N; i++) {
				if (tree[i][node] == 1 && visited[i] == 0) {
					q.add(i);
					visited[i] = 1;
				}
			}
		}

	}

}
