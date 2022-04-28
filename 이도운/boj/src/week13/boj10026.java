package week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj10026 {
	static int n;
	static int[][] visited, fig;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		fig = new int[n][n];
		for (int i = 0; i < n; i++) {
			String ipt = br.readLine();
			for (int j = 0; j < n; j++) {
				switch (ipt.charAt(j)) {
				case 'R':
					fig[i][j] = 1;
					break;
				case 'G':
					fig[i][j] = 2;
					break;
				case 'B':
					fig[i][j] = 3;
					break;
				}
			}
		}
		visited = new int[n][n];

		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i][j] == 0) {
					search(i, j);
					cnt += 1;
				}
			}
		}
		System.out.print(cnt + " ");

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				visited[i][j] = 0;
				if (fig[i][j] == 1)
					fig[i][j] = 2;
			}
		}

		cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i][j] == 0) {
					search(i, j);
					cnt += 1;
				}
			}
		}
		System.out.println(cnt);

	}

	static boolean BC(int x, int y) {
		boolean res = (x >= 0 && x < n && y >= 0 && y < n);
		return res;
	}

	static void search(int rx, int ry) {
		visited[rx][ry] = 1;
		for (int d = 0; d < 4; d++) {
			int nx = rx + dx[d];
			int ny = ry + dy[d];
			if (BC(nx, ny) && fig[nx][ny] == fig[rx][ry] && visited[nx][ny] == 0) {
				search(nx, ny);
			}
		}

	}

}
