package week08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2805 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		long N = Integer.parseInt(NM[0]);
		long M = Integer.parseInt(NM[1]);
		String[] HS = br.readLine().split(" ");
		long[] tree = new long[(int) N];
		long high = 0;
		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(HS[i]);
			high = (tree[i] > high) ? tree[i] : high;
		}
		long low = 0;
		long mid;
		long ans = tree[0];
		while (low <= high) {
			mid = (low + high) / 2;
			long get_tree = 0;
			for (int i = 0; i < tree.length; i++) {
				get_tree += (tree[i] > mid) ? (tree[i] - mid) : 0;
			}
			if (get_tree < M) {
				high = mid - 1;
			} else {
				low = mid + 1;
				ans = mid;
			}
		}
		System.out.println(ans);

	}

}
