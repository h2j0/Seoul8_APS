package BOJ;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_2178_미로탐색 {
	
	static int N;
	static int M;
	static int[][] maze;
	static boolean[][] visited;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		maze = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			String[] str = sc.next().split("");
			for(int j = 0; j < M; j++) {
				maze[i][j] = Integer.parseInt(str[j]);
			}
		}
		visited = new boolean[N][M];
		bfs();
		System.out.println(maze[N-1][M-1]);
	}
	
	static void bfs() {
		Queue<Integer> queR = new LinkedList<>(); //row
		Queue<Integer> queC = new LinkedList<>(); //col
		
		queR.offer(0);
		queC.offer(0);
		
		visited[0][0] = true;
		while(!queR.isEmpty()) {
			//초기값(시작점)
			int r = queR.poll();
			int c = queC.poll();
			
			//4방탐색
			for(int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr >= 0 && nr < N && nc >= 0 && nc < M) {
					if(maze[nr][nc] == 1 && visited[nr][nc] == false) {
						queR.offer(nr);
						queC.offer(nc);
						
						visited[nr][nc] = true;
						maze[nr][nc] = maze[r][c] + 1; //maze에 이동하면서 값 저장.
					}
				}
				
			}
		}
		
		
	}
}
