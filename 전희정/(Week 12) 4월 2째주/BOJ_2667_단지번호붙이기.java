package BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_2667_단지번호붙이기 {

	static int[] dr = { 0, 1, -1, 0 }; // 우하좌상
	static int[] dc = { 1, 0, 0, -1 };
	static char[][] map;
	static boolean[][] visited;
	static List<Integer> res;
	static int N;
	static int cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());

		map = new char[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		} // 입력완
		res = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				cnt = 0;
				if (map[i][j] == '1' && !visited[i][j]) {
					dfs(i, j);
					res.add(cnt);
				}
			}
		}
		Collections.sort(res);
		sb.append(res.size());
		for(int i=0;i<res.size();i++) {
			sb.append("\n").append(res.get(i));
		}
		System.out.println(sb);
		
	}// main

	private static void dfs(int r, int c) {
		visited[r][c] = true;
		cnt++;

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			// 범위 벗어나면 제껴
			if (nr < 0 || nr >= N || nc < 0 || nc >= N)
				continue;
			// 이미 방문했거나 0 만나면 제껴
			if (visited[nr][nc] || map[nr][nc] == '0')
				continue;

			dfs(nr, nc);
		}
	}
}
