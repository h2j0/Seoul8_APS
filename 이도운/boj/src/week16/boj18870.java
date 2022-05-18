package week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class boj18870 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] ori = new int[n];
		
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < n; i++) {
			ori[i] = Integer.parseInt(st.nextToken());
			set.add(ori[i]);
		}
		int tmpL = set.size();
		Object[] x = set.toArray();
		Arrays.sort(x);
		HashMap<Integer, Integer> call = new HashMap<Integer, Integer>();
		for (int i=0; i<tmpL; i++) {
			call.put((Integer) x[i], i);
		}
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<n; i++) {
			sb.append(call.get(ori[i])+" ");
		}
		sb.toString().trim();
		System.out.println(sb);
	}

}
