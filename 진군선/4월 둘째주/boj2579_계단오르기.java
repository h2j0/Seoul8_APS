package Apr_2nd_Week;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj2579_계단오르기 {

	static int[] points;
	static boolean[] check;
	static int n;
	static int ans;
	static int sum;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		check = new boolean[n + 1];
		points = new int[n + 1];
		for (int i = 1; i < n + 1; i++)
			points[i] = Integer.parseInt(br.readLine());

		ans = 0;
		dfs(0, 0, points[0]);
		// dfs로 풀고
		// 3회 이상 연속되면 return;
		System.out.println(ans);
	}

	private static void dfs(int i, int cnt, int sum) {
		if (cnt == 3)
			return;

		if (i >= n) {
			ans = Math.max(ans, sum);
			return;
		}
		
		
		check[i] = true;

		if ((i+1)<=n && !check[i + 1])
			dfs(i + 1, cnt + 1, sum + points[i + 1]);
		if ((i+2)<=n && !check[i + 2])
			dfs(i + 2, cnt, sum + points[i + 2]);

	}

}
