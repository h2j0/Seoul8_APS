package week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1199 {
	static int N;
	static int[][] ipt;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());

		ipt = new int[N][N];
		int rSum;
		boolean flag = true;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			rSum = 0;
			for (int j = 0; j < N; j++) {
				ipt[i][j] = Integer.parseInt(st.nextToken());
				rSum += ipt[i][j];
			}
			if (rSum%2==1) {
				flag = false;
				break;
			}
		}
		if (flag) {
			sb = new StringBuilder();
			dfs(0);
			System.out.println(sb);
		}else {
			System.out.println(-1);
		}
		

	}

	static void dfs(int root) {
		for (int i = 0; i < N; i++) {
			while (ipt[root][i] > 0) {
				ipt[root][i]--;
				ipt[i][root]--;
				dfs(i);
			}
		}
		sb.append(root + 1 + " ");
	}

}
