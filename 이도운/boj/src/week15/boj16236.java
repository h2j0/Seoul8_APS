package week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj16236 {
	static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		int[][] map = new int[n][n];
		int size = 2;
		int sharkX = 0;
		int sharkY = 0;
		
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };


		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int m = Integer.parseInt(st.nextToken());
				map[i][j] = m;
				if (m == 9) {
					sharkX = i;
					sharkY = j;
				}
			}
		}
		
		map[sharkX][sharkY] = 0;

		int eat = 0;
		int mv = 0;

		while (true) {
			PriorityQueue<int[]> PQ = new PriorityQueue<>((o1, o2) -> o1[2] != o2[2] ? Integer.compare(o1[2], o2[2])
					: (o1[0] != o2[0] ? Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1])));
			boolean[][] visited = new boolean[n][n];

			PQ.add(new int[] { sharkX, sharkY, 0 });
			visited[sharkX][sharkY] = true;

			boolean flag = false;

			while (!PQ.isEmpty()) {
				int[] curPos = PQ.poll();
				sharkX = curPos[0];
				sharkY = curPos[1];

				if (map[sharkX][sharkY] != 0 && map[sharkX][sharkY] < size) {
					map[sharkX][sharkY] = 0;
					eat++;
					mv += curPos[2];
					flag = true;
					break;
				}
				for (int d = 0; d < 4; d++) {
					int nx = sharkX + dx[d];
					int ny = sharkY + dy[d];

					if (!BC(nx, ny) || visited[nx][ny] || map[nx][ny] > size) {
						continue;
					}
					PQ.add(new int[] { nx, ny, curPos[2]+1 });
					visited[nx][ny] = true;
				}
			}
			if (!flag) {
				break;
			}
			if (size == eat) {
				size++;
				eat = 0;
			}

		}
		System.out.println(mv);

	}

	static boolean BC(int x, int y) {
		boolean res = (x >= 0 && x < n && y >= 0 && y < n);
		return res;
	}

}
