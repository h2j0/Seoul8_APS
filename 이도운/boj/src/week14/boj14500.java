package week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj14500 {
	static int[][] b;
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		b = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				b[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int a1 = t1(i, j);
				int a23 = t23(i, j);
				int a32 = t32(i, j);
				ans = (ans > a1) ? ans : a1;
				ans = (ans > a23) ? ans : a23;
				ans = (ans > a32) ? ans : a32;
			}
		}
		System.out.println(ans);

	}

	static int t1(int x, int y) {
		int[] s = { 0, 0, 0 };
		if (y + 3 < m) {
			for (int i = 0; i < 4; i++) {
				s[0] += b[x][y + i];
			}
		} else {
			s[0] = -1;
		}
		if (x + 3 < n) {
			for (int i = 0; i < 4; i++) {
				s[1] += b[x + i][y];
			}
		} else {
			s[1] = -1;
		}
		if ((x + 1 < n) && (y + 1 < m)) {
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					s[2] += b[x + i][y + j];
				}
			}
		}
		int max = -1;
		for (int i = 0; i < 3; i++) {
			max = (max > s[i]) ? max : s[i];
		}
		return max;
	}

	static int t32(int x, int y) {
		int[] s = new int[8];
		if ((x + 2 >= n) || (y + 1 >= m)) {
			return -1;
		} else {
			s[0] = b[x][y] + b[x][y + 1] + b[x + 1][y] + b[x + 2][y];
			s[1] = b[x][y + 1] + b[x + 1][y + 1] + b[x + 2][y + 1] + b[x + 2][y];
			s[2] = b[x][y] + b[x][y + 1] + b[x + 1][y + 1] + b[x + 2][y + 1];
			s[3] = b[x][y] + b[x + 1][y] + b[x + 2][y] + b[x + 2][y + 1];

			s[4] = b[x][y + 1] + b[x + 1][y + 1] + b[x + 1][y] + b[x + 2][y];
			s[5] = b[x][y] + b[x + 1][y] + b[x + 1][y + 1] + b[x + 2][y + 1];
			s[6] = b[x][y] + b[x + 1][y] + b[x + 1][y + 1] + b[x + 2][y];
			s[7] = b[x][y + 1] + b[x + 1][y + 1] + b[x + 1][y] + b[x + 2][y + 1];
		}
		int max = -1;
		for (int i = 0; i < 8; i++) {
			max = (max > s[i]) ? max : s[i];
		}
		return max;
	}

	static int t23(int x, int y) {
		int[] s = new int[8];
		if ((x + 1 >= n) || (y + 2 >= m)) {
			return -1;
		} else {
			s[0] = b[x][y] + b[x + 1][y] + b[x + 1][y + 1] + b[x + 1][y + 2];
			s[1] = b[x][y] + b[x][y + 1] + b[x][y + 2] + b[x + 1][y + 2];
			s[2] = b[x][y] + b[x + 1][y] + b[x][y + 1] + b[x][y + 2];
			s[3] = b[x + 1][y] + b[x + 1][y + 1] + b[x + 1][y + 2] + b[x][y + 2];

			s[4] = b[x][y] + b[x][y + 1] + b[x + 1][y + 1] + b[x + 1][y + 2];
			s[5] = b[x + 1][y] + b[x + 1][y + 1] + b[x][y + 1] + b[x][y + 2];
			s[6] = b[x][y] + b[x][y + 1] + b[x + 1][y + 1] + b[x][y + 2];
			s[7] = b[x + 1][y] + b[x + 1][y + 1] + b[x][y + 1] + b[x + 1][y + 2];
		}
		int max = -1;
		for (int i = 0; i < 8; i++) {
			max = (max > s[i]) ? max : s[i];
		}
		return max;
	}

}
