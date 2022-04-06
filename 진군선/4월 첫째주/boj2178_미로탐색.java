package Apr_1st_Week;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 최단거리 구하기 -> BFS
public class boj2178_미로탐색 {
	static class Position {
		int r, c, dist;

		public Position(int r, int c, int dist) {
			super();
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
		
	}
	
	static int[] dr = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dc = { 0, 0, -1, 1 }; // 상하좌우

	static char[][] map;
	static int ans;
	static Queue<Position> queue = new LinkedList<>();
	static int n;
	static int m;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];

		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}
		// 시작점
		Position start = new Position(0, 0, 0);
		
		bfs(start);
		
		System.out.println(ans);
		
	} // main 종료

	private static void bfs(Position position) {
		// 시작점을 넣고 방문처리
		queue.add(position);
		map[position.r][position.c] = '0';
		position.dist ++;
		
		// 큐가 공백이 될 때까지 반복
		while (!queue.isEmpty()) {
			//하나 꺼내
			Position curr = queue.poll();
			
			// 현재 좌표에서 인접한 친구들을 모두 담는다
			for(int i = 0; i<4; i++) {
				int nr = curr.r + dr[i];
				int nc = curr.c + dc[i];
				
				if(0> nr || nr >= n || 0> nc || nc >= m) continue;
				if(map[nr][nc] == '1') {
					if(nr==n-1 && nc ==m-1) {
						ans = curr.dist+1;
						return;
					}
					
					map[nr][nc] = '0';
					int dist = curr.dist;
					queue.add(new Position(nr, nc, ++dist));
					
				}
			}
			
		}
		
	}

}
