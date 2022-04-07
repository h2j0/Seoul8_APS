import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1018_체스판다시칠하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		char[][] board = new char[N][M];
		for (int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray();
		}

		char[][] BFirst = new char[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i % 2 == 0 && j % 2 == 0)
					BFirst[i][j] = 'B';
				else if (i * j % 2 == 1)
					BFirst[i][j] = 'B';
				else
					BFirst[i][j] = 'W';
			}
		}

		char[][] WFirst = new char[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i % 2 == 0 && j % 2 == 0)
					WFirst[i][j] = 'W';
				else if (i * j % 2 == 1)
					WFirst[i][j] = 'W';
				else
					WFirst[i][j] = 'B';
			}
		}
		System.out.println("보드");
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(board[i]));
		}

		System.out.println("BW");
		for (int i = 0; i < 8; i++) {
			System.out.println(Arrays.toString(BFirst[i]));
		}
		System.out.println("WB");
		for (int i = 0; i < 8; i++) {
			System.out.println(Arrays.toString(WFirst[i]));
		}

		int minCnt = 0;
		int min = 987654321;
		for (int i = 0; i <= N - 8; i++) {
			for (int j = 0; j <= M - 8; j++) {
				int cnt1 = 0;
				int cnt2 = 0;
				for (int k = 0; k < 8; k++) {
					for (int l = 0; l < 8; l++) {
						if (board[i + k][j + l] != BFirst[k][l])
							cnt1++;
						if (board[i + k][j + l] != WFirst[k][l])
							cnt2++;
					}
				}
				minCnt = Math.min(cnt1, cnt2);
				if (minCnt < min) {
					min = minCnt;
				}
			}
		}
		System.out.println(min);
	}
}