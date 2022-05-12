package week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2630 {
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
		ans = new int[2];
		BW(N, 0, 0);
		System.out.println(ans[0]);
		System.out.println(ans[1]);

	}

	static void BW(int L, int x, int y) {
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
			ans[data[x][y]]++;
		} else {
			int L2 = L / 2;
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					BW(L2, x + L2 * i, y + L2 * j);
				}
			}
		}

	}

}
