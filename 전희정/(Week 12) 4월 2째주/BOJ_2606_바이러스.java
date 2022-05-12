package BOJ;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2606_바이러스 {
	static int[] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();

		p = new int[V + 1];
		// makeSet
		for (int i = 1; i <= V; i++) {
			p[i] = i;
		}

		for (int i = 0; i < E; i++) {
			int px = findSet(sc.nextInt());
			int py = findSet(sc.nextInt());
			// 부모가 다르면 합쳐
			if (px != py) {
				union(px, py);
			}
		}
		
		// 조상 update 
		for(int i=1; i <= V; i++) {
             findSet(i);
         }
		
		int cnt = 0;
		for (int i = 2; i < p.length; i++) {
			if (p[i] == 1) {
				cnt++;
			}
		}
		
//		System.out.println(Arrays.toString(p));
		System.out.println(cnt);
	}// main

	// 부모조상이 무조건 작은수가 되도록 합침
	private static void union(int x, int y) {
		int min = Math.min(x, y);
		int max = Math.max(x, y);
		if (min != max)
			p[max] = findSet(min);

	}

	private static int findSet(int x) {
		if (p[x] != x)
			p[x] = findSet(p[x]);
		return p[x];
	}
}
