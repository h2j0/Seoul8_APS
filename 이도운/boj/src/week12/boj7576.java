package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class boj7576 {
	static Deque<Integer> q = new ArrayDeque<>();
	static int M;
	static int N;
	static int[][] tmt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		tmt = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				tmt[i][j] = Integer.parseInt(st.nextToken());
				if (tmt[i][j] == 1) {
					q.add(i * M + j);
				}
			}
		}

		bfs();

		int res = 0;
		outer: for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tmt[i][j] == 0) {
					res = 0;
					break outer;
				}
				res = (res > tmt[i][j]) ? res : tmt[i][j];
			}
		}
		System.out.println(res - 1);
	}

	static void bfs() {

		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };

		while (!q.isEmpty()) {

			int coord = q.pollFirst();
			int x = coord / M;
			int y = coord % M;
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];

				if (nx >= 0 && nx < N && ny >= 0 && ny < M && tmt[nx][ny] == 0) {
					tmt[nx][ny] = tmt[x][y] + 1;
					q.add(nx * M + ny);
				}

			}
		}

	}

}
