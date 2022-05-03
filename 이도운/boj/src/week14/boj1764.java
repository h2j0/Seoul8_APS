package week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class boj1764 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		HashSet<String> setA = new HashSet();
		for (int i = 0; i < n; i++) {
			setA.add(br.readLine());
		}
		HashSet<String> setB = new HashSet();
		for (int i = 0; i < m; i++) {
			setB.add(br.readLine());
		}

		setA.retainAll(setB);

		String[] ans = new String[setA.size()];
		Iterator iterA = setA.iterator();
		int idx = 0;
		while (iterA.hasNext()) {
			ans[idx++] = (String) iterA.next();
		}

		Arrays.sort(ans);
		System.out.println(ans.length);
		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
	}

}
