package Mar_3rd_Week;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1018_체스판다시칠하기 {

	public static void main(String[] args) throws Exception {
		// N*M보드를 받아서 처음부터 N-8+1, M-8+1까지 8*8 범위를 지정하고,
		// W로 시작하는 경우와 B로 시작하는 경우 새로 색칠해야 하는 개수를 구해서 가장 작은 값을 도출

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] board = new char[N][M];
		for (int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray();
		}

		
		// W로 시작하는 경우
		int resultB = Integer.MAX_VALUE;
		for (int i = 0; i < N - 7; i++) {
			for (int j = 0; j < M - 7; j++) {
				int tmp = 0;
				for (int k = 0; k < 8; k++) {
					for (int l = 0; l < 8; l++) {
						if((k+l) % 2 == 0) {
							if (board[i+k][j+l] == 'B') {
								tmp++;
							}
						} else {
							if (board[i+k][j+l] == 'W') {
								tmp++;
							}
						}
						
						
					}
				}
				
				resultB = Integer.min(tmp, resultB);
			}
		}
		// B로 시작하는 경우
		int resultW = Integer.MAX_VALUE;
		for (int i = 0; i < N - 7; i++) {
			for (int j = 0; j < M - 7; j++) {
				int tmp = 0;
				for (int k = 0; k < 8; k++) {
					for (int l = 0; l < 8; l++) {
						if((k+l) % 2 == 0) {
							if (board[i+k][j+l] == 'W') {
								tmp++;
							}
						} else {
							if (board[i+k][j+l] == 'B') {
								tmp++;
							}
						}
						
						
					}
				}
				resultW = Integer.min(tmp, resultW);
			}
		}
		
		int result = Integer.min(resultB,resultW);
		System.out.println(result);
		
		
		
	}

}
