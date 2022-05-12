package Apr_3rd_Week;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj7576_토마토 {
	static class Tomato {
		int r, c, day; // 좌표, 익는데 걸린 시간

		public Tomato(int r, int c, int day) {
			super();
			this.r = r;
			this.c = c;
			this.day = day; 
		}
	}

	static int[] dr = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dc = { 0, 0, -1, 1 }; // 상하좌우

	static int n, m, ans;
	static int[][] box;
	static boolean[][] check;

	static Queue<Tomato> queue;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		box = new int[n][m];
		check = new boolean[n][m];
		ans = -1;
		queue = new LinkedList<>();

		// 입력
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// bfs로 탐색하여 최단거리로 순회 
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				// 익은 토마토이고, 아직 방문하지 않은 경우 queue에 넣고 방문처리
				if (box[i][j] == 1 && !check[i][j]) {
					queue.add(new Tomato(i, j, 0));
					check[i][j] = true;
				}
			}
		}

		// queue가 빌 때까지 반복
		while (!queue.isEmpty()) {
			// 토마토를 하나 꺼낸다
			Tomato curr = queue.poll();

			// 사방 탐색
			for (int d = 0; d < 4; d++) {
				int nr = curr.r + dr[d];
				int nc = curr.c + dc[d];

				// 다음 토마토가 상자 안에 있고
				// 방문하지 않았고, 안익은 토마토일 때
				if (0 <= nr && nr < n && 0 <= nc && nc < m && !check[nr][nc] && box[nr][nc] == 0) {
					// 토마토가 익고
					box[nr][nc] = 1;
					// queue에 넣고 방문처리
					queue.add(new Tomato(nr, nc, curr.day + 1));
					check[nr][nc] = true;
				}

			}
			// 답은 토마토가 익는데 걸리는 날 중 가장 큰 값
			ans = Math.max(ans, curr.day);
		}

		// 전체 상자를 체크해서 안익은 토마토 있는지 확인. 있으면 답은 -1
		loop: for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (box[i][j] == 0) {
					ans = -1;
					break loop;
				}
			}
		}

		System.out.println(ans);

	}

}
