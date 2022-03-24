package week07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class boj1920 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		String[] nIpt = br.readLine().split(" ");
		int[] ns = new int[n];
		for (int i = 0; i < n; i++) {
			ns[i] = Integer.parseInt(nIpt[i]);
		}
		Arrays.sort(ns);

		int m = Integer.parseInt(br.readLine());
		String[] mIpt = br.readLine().split(" ");
		int[] ms = new int[m];
		for (int i = 0; i < m; i++) {
			ms[i] = Integer.parseInt(mIpt[i]);
		}

		if (m < 10) {

			for (int i = 0; i < m; i++) {
				int ans = 0;
				for (int j = 0; j < n; j++) {
					if (ms[i] == ns[j]) {
						ans = 1;
					}
				}
				System.out.println(ans);
			}

		} else {
			for (int i = 0; i < m; i++) {
				bw.write(binarySearch(ms[i], ns) + "\n");
			}
			bw.flush();
			bw.close();
		}

	}

	public static int binarySearch(int x, int[] arr) {
		int st = 0;
		int ed = arr.length - 1;
		int mid = (st + ed) / 2;

		while (st < ed) {
			if (arr[mid] > x) {
				ed = mid - 1;
			} else if (arr[mid] < x) {
				st = mid + 1;
			} else {
				return 1;
			}
			mid = (st + ed) / 2;
		}

		for (int i = st; i <= ed; i++) {
			if (arr[i] == x) {
				return 1;
			}
		}
		return 0;

	}

}
