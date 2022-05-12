package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10026_적록색약 {
	static boolean[][] visited;
	static char[][] colorRGB;
	static char[][] colorRB;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		colorRGB = new char[n][n];

		for (int i = 0; i < n; i++) {
			colorRGB[i] = br.readLine().toCharArray();
		}
		colorRB = new char[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				colorRB[i][j] = colorRGB[i][j];
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (colorRB[i][j] == 'G')
					colorRB[i][j] = 'R';
			}
		}

		int rgb = 0;
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					rgb++;
					dfsRGB(i, j);
				}
			}
		} // for

		int rb = 0;
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					rb++;
					dfsRB(i, j);
				}
			}
		} // for

		System.out.println(rgb + " " + rb);
	} // main

	private static void dfsRGB(int r, int c) {
		visited[r][c] = true;
		char nowColor = colorRGB[r][c];
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr < 0 || nc < 0 || nr >= n || nc >= n || visited[nr][nc])
				continue;
			if (nowColor != colorRGB[nr][nc])
				continue;

			dfsRGB(nr, nc);
		}
	} // 적록색맹 아닌 사람

	private static void dfsRB(int r, int c) {
		visited[r][c] = true;
		char nowColor = colorRB[r][c];
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr < 0 || nc < 0 || nr >= n || nc >= n || visited[nr][nc])
				continue;
			if (nowColor != colorRB[nr][nc])
				continue;

			dfsRB(nr, nc);
		}
	}

}
