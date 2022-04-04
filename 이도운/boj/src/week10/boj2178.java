package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class boj2178 {

	static int[][] maze;
	static int n;
	static int m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		maze = new int[n][m];

		for (int i = 0; i < n; i++) {
			String ipt = br.readLine();
			for (int j = 0; j < m; j++) {
				maze[i][j] = Character.getNumericValue(ipt.charAt(j));
			}
		}
		bfs();
		System.out.println(maze[n-1][m-1]);

	}

	static void bfs() {
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };
		Deque<Integer> q = new ArrayDeque<>();
		q.add(0);

		while (!q.isEmpty()) {
			int pp = q.pollFirst();
			int x = pp / m;
			int y = pp % m;

			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];

				if (nx >= 0 && nx < n && ny >= 0 && ny < m && maze[nx][ny] == 1) {
					maze[nx][ny] = maze[x][y] + 1;
					q.add(nx * m + ny);
				}
			}
		}

	}

}
