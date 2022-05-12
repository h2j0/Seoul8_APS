package BOJ;

import java.util.Scanner;

public class BOJ_11724_연결요소의개수 {
	static int[] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		// makeSet
		p = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			p[i] = i;
		}

		for (int i = 0; i < M; i++) {
			int px = findSet(sc.nextInt());
			int py = findSet(sc.nextInt());
			// 조상이 다르면 합친다
			if (px != py)
				union(px, py);
		}

		// 조상 업뎃
		for (int i = 0; i <= N; i++) {
			findSet(i);
		}

		int cnt = 0;
		// 자기가 조상이면 cnt증가
		for (int i = 1; i <= N; i++) {
			if (p[i] == i)
				cnt++;
		}
		System.out.println(cnt);
	}

	private static void union(int px, int py) {
		if (px != py)
			p[py] = findSet(px);
	}

	private static int findSet(int x) {
		if (x != p[x])
			p[x] = findSet(p[x]);
		return p[x];
	}
}
