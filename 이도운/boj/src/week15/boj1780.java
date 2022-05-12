package week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1780 {
	static int N;
	static int[] ans;
	static int[][] data;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		data = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		ans = new int[3];
		cut(N, 0, 0);
		for (int i=0; i<3; i++) {
			System.out.println(ans[i]);
		}

	}

	static void cut(int L, int x, int y) {
		int r = data[x][y];
		boolean flag = true;
		outer: for (int i = 0; i < L; i++) {
			for (int j = 0; j < L; j++) {
				if (data[x + i][y + j] != r) {
					flag = false;
					break outer;
				}
			}
		}

		if (flag) {
			ans[data[x][y] + 1]++;
		} else {
			int L3 = L / 3;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					cut(L3, x + L3 * i, y + L3 * j);
				}
			}
		}

	}

}
