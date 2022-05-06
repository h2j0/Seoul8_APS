package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_1764_듣보잡 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int l = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int N = l + s;
		String[] listen = new String[l];
		String[] see = new String[s];
		HashMap<String, Integer> map = new HashMap<>();
		ArrayList<String> ans = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			if (!map.containsKey(str)) {
				map.put(str, 1);
			} else {
				map.put(str, map.get(str) + 1);
			}
		}

		for (String key : map.keySet()) {
			if (map.get(key) == 2) {
				ans.add(key);
			}
		}

 		Collections.sort(ans);
		sb.append(ans.size()).append("\n");
		for (int i = 0; i < ans.size(); i++) {
			sb.append(ans.get(i)).append("\n");
		}
		System.out.println(sb);
	}
}
