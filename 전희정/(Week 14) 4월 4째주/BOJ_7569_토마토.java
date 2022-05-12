package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_7569_토마토 {

	static class Tomato {
		int h;
		int r;
		int c;
		int day;

		public Tomato(int h, int r, int c, int day) {
			this.h = h;
			this.r = r;
			this.c = c;
			this.day = day;
		}
	}

	static int[] dr = { -1, 1, 0, 0, 0, 0 };
	static int[] dc = { 0, 0, -1, 1, 0, 0 };
	static int[] dh = { 0, 0, 0, 0, -1, 1 };
	static int M;
	static int N;
	static int[][][] box;
	static Queue<Tomato> q;
	static boolean[][][] visited;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		int H = sc.nextInt();

		q = new LinkedList<>();
		visited = new boolean[H][N][M];
		box = new int[H][N][M];
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					box[k][i][j] = sc.nextInt();
					if (box[k][i][j] == 1) {
						q.add(new Tomato(k, i, j, 0)); // 익은토마토 넣기
						visited[k][i][j] = true;
					}
				}
			}
		} // 입력완
		int ans = 0;

		while (!q.isEmpty()) {
			Tomato curr = q.poll();
			ans = curr.day;
			for (int i = 0; i < 6; i++) {
				int nr = curr.r + dr[i];
				int nc = curr.c + dc[i];
				int nh = curr.h + dh[i];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M || nh < 0 || nh >= H)
					continue;
				if (box[nh][nr][nc] != 0 || visited[nh][nr][nc])
					continue;

				// 토마토 익고
				box[nh][nr][nc] = 1;
				q.add(new Tomato(nh, nr, nc, curr.day + 1));
				visited[nh][nr][nc] = true;
			}
		}

		outer: for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (box[k][i][j] == 0) {
						ans = -1;
						break outer;
					}
				}
			}
		}
		System.out.println(ans);
	}

}
