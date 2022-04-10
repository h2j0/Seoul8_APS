package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class boj1012 {
	static int M, N, K;
	static int[][] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			graph = new int[M][N];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				graph[x][y] = 1;
			}
			int nworm = 0;
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (graph[i][j] == 1) {
						dfs(i, j);
						nworm += 1;
					}
				}
			}
			System.out.println(nworm);

		}

	}

	static void dfs(int x, int y) {
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };
		Deque<Integer> dq = new ArrayDeque<>();
		dq.add(x * N + y);
		graph[x][y] = 0;

		while (!dq.isEmpty()) {
			int tmpxy = dq.pollFirst();
			int curx = tmpxy / N;
			int cury = tmpxy % N;

			for (int d = 0; d < 4; d++) {
				int nx = curx + dx[d];
				int ny = cury + dy[d];

				if (nx < 0 || nx >= M || ny < 0 || ny >= N) {
					continue;
				}

				if (graph[nx][ny] == 1) {
					graph[nx][ny] = 0;
					dq.add(nx * N + ny);
				}

			}

		}

	}

}
