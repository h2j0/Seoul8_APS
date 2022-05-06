package BOJ;

import java.util.ArrayList;
import java.util.Scanner;


public class boj_14500_테트로미노 {

	static int N;
	static int M;
	static int[][] tetris;
	static boolean[][] sel;
	static int sum;
	static int tetromino;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int four;
	static int tmp;
	static boolean[] visited;
	static int[] visit = { 0, 1, 2, 3 };
	static ArrayList<Integer> Idx;
	static int max;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		tetris = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tetris[i][j] = sc.nextInt();
			}
		}
		sel = new boolean[N][M];
		visited = new boolean[4];
		max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				poliomino(i, j, 0, 0);
//				trouble(i, j);
				powerset(i, j, 0);

			}
		}
//		System.out.println(max);
//		System.out.println(tetromino);
		int res = Math.max(max, tetromino);
		System.out.println(res);

//		System.out.println(tetromino);
//		powerset(0, 0, 0);
		
	}

	public static void poliomino(int r, int c, int depth, int sum) {
		if (depth == 4) { // 4일때 일로와서 비교스
			tetromino = Math.max(tetromino, sum);
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr < 0 || nr >= N || nc < 0 || nc >= M)
				continue;
			if (sel[nr][nc])
				continue;

			sel[nr][nc] = true;
			poliomino(nr, nc, depth + 1, sum + tetris[nr][nc]); // sum에다가 값을 누적
			sel[nr][nc] = false;
		}
	}

	static void powerset(int r, int c, int idx) {
		if (idx == visited.length) {
			Idx = new ArrayList<>();
			for (int i = 0; i < visited.length; i++) {
				if (visited[i]) {
					Idx.add(visit[i]);
				}
			}
			if (Idx.size() == 3) {
				trouble(r, c);
			}
			return;
		}

		visited[idx] = true;
		powerset(r, c, idx + 1);

		visited[idx] = false;
		powerset(r, c, idx + 1);

	}

	static void trouble(int r, int c) {// 얘는 사방 탐색하는데 네개

		tmp = tetris[r][c];
		
		for (int d = 0; d < 3; d++) {
			int nr = r + dr[Idx.get(d)];
			int nc = c + dc[Idx.get(d)];
			if (nr < 0 || nr >= N || nc < 0 || nc >= M)
				continue;
			tmp += tetris[nr][nc];
		}
		if(max < tmp) {
			max = tmp;
		}

	}

}
