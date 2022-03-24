package week09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class boj10816 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		HashSet<Integer> set = new HashSet<>();

		int n = Integer.parseInt(br.readLine());
		String[] nsStr = br.readLine().split(" ");
		int[] ns = new int[n];
		for (int i = 0; i < n; i++) {
			ns[i] = Integer.parseInt(nsStr[i]);
			set.add(Integer.parseInt(nsStr[i]));
		}
		int m = Integer.parseInt(br.readLine());
		String[] msStr = br.readLine().split(" ");
		int[] ms = new int[m];
		for (int i = 0; i < m; i++) {
			ms[i] = Integer.parseInt(msStr[i]);
		}

		Integer[] nsUniq = new Integer[set.size()];
		set.toArray(nsUniq);
		Arrays.sort(nsUniq);
		Arrays.sort(ns);

		HashMap<Integer, Integer> nDict = new HashMap<Integer, Integer>();

		int idx = 0;
		for (int i = 0; i < nsUniq.length; i++) {
			int count = 0;
			while (idx < n && ns[idx] == nsUniq[i]) {
				count += 1;
				idx += 1;
			}
			nDict.put(nsUniq[i], count);
		}
		
		
		for (int i = 0; i < m; i++) {
			try {
				sb.append((nDict.get(ms[i])==null)?"0 ":nDict.get(ms[i]) + " ");
			} catch (Exception e) {
				sb.append("0 ");
				throw e;

			}

		}
		System.out.println(sb);

	}

	public static int binarySearch(int[] arr, int x) {
		int st = 0;
		int ed = arr.length - 1;
		int mid = (st + ed) / 2;

		while (st < ed) {
			if (arr[mid] > x) {
				ed = mid - 1;
			} else if (arr[mid] < x) {
				st = mid + 1;
			} else {
				return mid;
			}
			mid = (st + ed) / 2;
		}
		return mid;
	}

}
