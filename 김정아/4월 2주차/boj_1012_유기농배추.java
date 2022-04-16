package BOJ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_1012_유기농배추 {

	static int[][] garden; // 텃밭 배열
	static int[] parent;
	static boolean[][] visited;
	static int cabbage; //배추
	static int worm; //지렁이
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int a;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int M = sc.nextInt();
			int N = sc.nextInt();
			int K = sc.nextInt();
			
			// 어차피 그냥 더 큰거로 크게 배열 만들면 편해보여.
			a = Math.max(M, N); //편하게 하고싶어서.
			
			visited = new boolean[a+2][a+2];
			garden = new int[a+2][a+2];
			parent = new int[a+2];
			for(int i = 0; i < K; i++) {
				int p = sc.nextInt();
				int c = sc.nextInt();
				
				garden[p+1][c+1] = 1; // 가르키는 간선 저장
				parent[c+1]++; // 카운팅
			}
			//배열 담기 끝
			//출력 확인
//			for(int i = 0; i < a+2; i++) {
//				for(int j = 0; j < a+2; j++) {
//					System.out.print(garden[i][j]);
//				}
//				System.out.println();
//			}
//			System.out.println(Arrays.toString(parent));
			ArrayList<Integer> howmany = new ArrayList<>();
			
			///dfs 로 인접한거 0 으로 바꾸고 카운팅
			worm = 1;
			for(int i = 0; i < a+2; i++) {
				for(int j = 0; j< a+2; j++) {
					cabbage = 0;//배추 개수
					if(garden[i][j] == 1 && !visited[i][j]) {
						dfs(i,j);
						howmany.add(cabbage);
						worm++;
//						System.out.println(worm);
					}
				}
			}
//			System.out.println(worm);
			
//			Collections.sort(howmany);
			System.out.println(howmany.size());
//			for(int i = 0; i< howmany.size(); i++) {
//				System.out.println(howmany.get(i));
//			}
			
		}
	}
	
	public static void dfs(int r, int c) {
		cabbage++;
		garden[r][c] = worm;
		visited[r][c] = true;
		
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(nr < 0 || nr >= a+2 || nc < 0 || nc >= a+2) continue;
			
			if( nr >= 0 && nr < a+2 && nc >= 0 && nr < a+2) {
				if(garden[nr][nc] == 1 && !visited[nr][nc]) {
					//배추가 있고 아직 방문 안한곳은
					dfs(nr, nc); // 탐색 계속해
				}
			}
		}
	}
}
