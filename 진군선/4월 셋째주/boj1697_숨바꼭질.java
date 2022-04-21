package Apr_3rd_Week;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1697_숨바꼭질 {
	static class Pos {
		int n, cnt;

		public Pos(int n, int cnt) {
			super();
			this.n = n;
			this.cnt = cnt;
		}

	}

	static int[] arr;
	static boolean[] check;
	static int k, n;
	static Queue<Pos> queue;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		// dp 문제인 것 같은데... 검색해봐야지
		// 구글링을 하니 다들 bfs로 풀이...
		arr = new int[200001];
		check = new boolean[200001];
		queue = new LinkedList<>();
		queue.add(new Pos(n, 0));
		bfs();

	}

	private static void bfs() {
		check[n] = true;

		while (!queue.isEmpty()) {
			Pos curr = queue.poll();
			if (curr.n == k) {
				System.out.println(curr.cnt);
				break;
			}

			if (curr.n - 1 >= 0 && !check[curr.n - 1]) {
				queue.add(new Pos(curr.n - 1, curr.cnt + 1));
				check[curr.n - 1] = true;
			}
			if (curr.n + 1 < 200001 && !check[curr.n + 1]) {
				queue.add(new Pos(curr.n + 1, curr.cnt + 1));
				check[curr.n + 1] = true;
			}
			if (curr.n * 2 < 200001 && !check[curr.n * 2]) {
				queue.add(new Pos(curr.n * 2, curr.cnt + 1));
				check[curr.n * 2] = true;
			}
		}
	}

}
