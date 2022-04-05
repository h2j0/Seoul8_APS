package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SWEA_7733_치즈도둑 {

	
	static int N;
	static int[][] cheese;
	static boolean[][] sel;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc	= {0, 0, -1, 1};
	static int max;
	static int day;
	static int cnt;
	static int ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			
			N = Integer.parseInt(br.readLine());
			
			cheese = new int[N][N];
			max = -1; //사실 굳이 100일로 설정할 필요가 있나 싶어서 그냥 100이 max가 아닌한 그냥 max정도만 도는 걸로.
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					cheese[i][j] = Integer.parseInt(st.nextToken());
					if(cheese[i][j] > max) {
						max = cheese[i][j];
					}
				}
			}
			
			//잘 들어왔나 확인
//			for(int i = 0; i < N; i++) {
//				for(int j = 0; j < N; j++) {
//					System.out.print(cheese[i][j]);
//				}
//				System.out.println();
//			}
//			System.out.println(max);
			
			sel = new boolean[N][N];
			ans = 1; // 치즈가 한개로 시작
			day = 1;
			left();
			System.out.println("#"+tc+" "+ans);
		}
		
	}
	
	public static void left() {
		while(max >= day) {// 날짜 마다 치즈 덩어리 카운팅
			cnt = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(cheese[i][j] == day) {
						cheese[i][j] = 0; // 먹으면 0으로 일단 바꿔
					}
				}
			}
//			for(int i = 0; i < N; i++) {
//				for(int j = 0; j < N; j++) {
//					System.out.print(cheese[i][j]);
//				}
//				System.out.println();
//			}
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(cheese[i][j] > 0 && !sel[i][j]) { // 아닌 곳 들어와서 세줘
//						sel[i][j] = true;
						find(i, j); // find함수 실행해서
						cnt++; //카운팅
					}
				}
			}
			System.out.println();
//			System.out.println();
			System.out.print(max+" "+cnt+" "+day);
			
			if(cnt > ans) {
				ans = cnt;
			}

			day++;
		}

		
	}
	
	public static void find(int r, int c) { //dfs
		sel[r][c] = true;
		
		//4방 탐색
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = r + dc[i];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
			
			if(cheese[nr][nc] > 0 && !sel[nr][nc]) {
//				sel[nr][nc] = true;
				find(nr, nc);
			}
 		}
		
	}
	
}
