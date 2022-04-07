package BOJ.Study.Week11_Apr1st;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178_미로탐색 {
	static class Pos {
		int r;
		int c;
		int dist;

		public Pos(int r, int c, int dist) {
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		char[][] maze = new char[n][m];
		for (int i = 0; i < n; i++) {
			maze[i] = br.readLine().toCharArray();
		} // 입력 완

//		int dist=0;
		int ansDist = 0;
		
		Pos start = new Pos(0, 0, 1);

		boolean[][] visited = new boolean[n][m];

		// 큐 생성
		Queue<Pos> q = new LinkedList<>();

		visited[start.r][start.c] = true;
		q.add(start);

		while (!q.isEmpty()) {
			Pos curr = q.poll();

			if (curr.r == n-1 && curr.c == m-1) {
					ansDist = curr.dist;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int nr = curr.r + dr[i];
				int nc = curr.c + dc[i];

				if (nr < 0 || nr >= n || nc < 0 || nc >= m)
					continue;
				if (maze[nr][nc] != '1' || visited[nr][nc])
					continue;

				visited[nr][nc] = true;
				q.add(new Pos(nr, nc, curr.dist+1));
//				q.add(new Pos(nr, nc, ++curr.dist)); 이건 1%에서 틀렸습니다 나옴
				// 4방향을 돌면서 증가되고 있었다?? 
				// help................................
				// 사실 이해가 잘 안감 ㅎ,ㅎ,ㅎ,ㅎ,,ㅎㅎ,
				// 
				// 
			} // 4방향 탐색
		} // bfs while

		System.out.println(ansDist);
	}// main

}
