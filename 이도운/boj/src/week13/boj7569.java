package week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class boj7569 {
	static Deque<Integer> q = new ArrayDeque<>();
	static int M;
	static int N;
	static int H;
	static int[][][] tmt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		tmt = new int[N][M][H];

		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					tmt[i][j][k] = Integer.parseInt(st.nextToken());
					if (tmt[i][j][k] == 1) {
						q.add(k * (M * N) + i * M + j);
					}
				}
			}
		}
		bfs();

		int res = 0;
		outer: for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < H; k++) {
					if (tmt[i][j][k] == 0) {
						res = 0;
						break outer;
					}
					res = (res > tmt[i][j][k]) ? res : tmt[i][j][k];
				}
			}
		}
		System.out.println(res - 1);

	}

	static void bfs() {

		int[] dx = { 1, -1, 0, 0, 0, 0 };
		int[] dy = { 0, 0, 1, -1, 0, 0 };
		int[] dz = { 0, 0, 0, 0, 1, -1 };

		while (!q.isEmpty()) {

			int coord = q.pollFirst();
			int z = coord / (M * N);
			coord -= z * M * N;
			int x = coord / M;
			int y = coord % M;

			for (int d = 0; d < 6; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				int nz = z + dz[d];

				if (nx >= 0 && nx < N && ny >= 0 && ny < M && nz >= 0 && nz < H && tmt[nx][ny][nz] == 0) {

					tmt[nx][ny][nz] = tmt[x][y][z] + 1;
					q.add(nz * (M * N) + nx * M + ny);
				}

			}
		}

	}

}
