package BOJ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class boj_2667_단지번호붙이기 {
	
	static int[][] map;
	static boolean[][] visited;
	static int N;
	static int house;
	static int cnt;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); // 지도 크기
		map = new int[N][N];
		visited = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			String str = sc.next();
			for(int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < N; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
		// 입력받기 끝
		
		// 집 개수 담을 어레이리스트
		ArrayList<Integer> howmany = new ArrayList<>();
		
		// 집을 찾아 줍시다
		house = 1;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j<N; j++) {
				cnt = 0; // 연결되는 단지에 있는 집 개수 세기 위해서
				if(map[i][j] == 1 && !visited[i][j]) {
					dfs(i,j);
					howmany.add(cnt);
					house++; // 단지 수.
				}
			}
		}
		
		//출력 확인
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < N; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
		
		Collections.sort(howmany);
		System.out.println(howmany.size());
		for(int i = 0; i< howmany.size(); i++) {
			System.out.println(howmany.get(i));
		}
		
	}
	
	
	public static void dfs(int r, int c) {
		cnt++;
		map[r][c] = house;
		visited[r][c] = true;
		
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
			
			if( nr >= 0 && nr < N && nc >= 0 && nr < N) {
				if(map[nr][nc] == 1 && !visited[nr][nc]) {
					//집이 있고 아직 방문 안한곳은
					dfs(nr, nc); // 탐색 계속해
				}
			}
		}
		
	}
}
