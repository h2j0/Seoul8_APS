package Apr_4th_Week;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class boj10026_적록색맹 {
	static class Pos {
		int r, c;
		char color;

		public Pos(int r, int c, char color) {
			super();
			this.r = r;
			this.c = c;
			this.color = color;
		}
	}

	static int[] dr = { -1, 1, 0, 0 };// 상하좌우
	static int[] dc = { 0, 0, -1, 1 };

	static char[][] map;
	static boolean[][] check;
	static int n;
	static int genAns, colblindAns;

	static Queue<Pos> queue;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		check = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}
		queue = new LinkedList<Pos>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!check[i][j]) {
					genBfs(i, j, map[i][j]);
				}
			}
		}

		sb.append(genAns).append(" ");

		check = new boolean[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!check[i][j]) {
					colbilndBfs(i, j, map[i][j]);
				}
			}
		}

		sb.append(colblindAns);
		
		System.out.println(sb);
		
	}

	private static void colbilndBfs(int r, int c, char color) {
		queue.add(new Pos(r, c, color));
		check[r][c] = true;

		while (!queue.isEmpty()) {
			Pos curr = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nr = curr.r + dr[d];
				int nc = curr.c + dc[d];

				if (0 <= nr && nr < n && 0 <= nc && nc < n && !check[nr][nc]) {
					if (curr.color == 'R' || curr.color == 'G') {
						if (map[nr][nc] == 'R' || map[nr][nc] == 'G') {
							queue.add(new Pos(nr, nc, map[nr][nc]));
							check[nr][nc] = true;
						}
					} else if (map[nr][nc] == curr.color) {
						queue.add(new Pos(nr, nc, map[nr][nc]));
						check[nr][nc] = true;
					}

				}
			}
		}
		colblindAns++;
	}

	private static void genBfs(int r, int c, char color) {
		queue.add(new Pos(r, c, color));
		check[r][c] = true;

		while (!queue.isEmpty()) {
			Pos curr = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nr = curr.r + dr[d];
				int nc = curr.c + dc[d];

				if (0 <= nr && nr < n && 0 <= nc && nc < n) {
					if (!check[nr][nc] && map[nr][nc] == curr.color) {
						queue.add(new Pos(nr, nc, map[nr][nc]));
						check[nr][nc] = true;
					}
				}
			}
		}
		genAns++;
	}

}
