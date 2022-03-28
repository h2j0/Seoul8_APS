package week09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class boj11866 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Deque<Integer> dq = new ArrayDeque<>();

		String[] nk = br.readLine().split(" ");
		int n = Integer.parseInt(nk[0]);
		int k = Integer.parseInt(nk[1]);

		for (int i = 1; i <= n; i++) {
			dq.add(i);
		}
		sb.append("<");
		while (!dq.isEmpty()) {
			for (int i = 0; i < k - 1; i++) {
				dq.addLast(dq.pollFirst());
			}
			sb.append(dq.pollFirst() + ", ");
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.deleteCharAt(sb.length() - 1);
		sb.append(">");
		System.out.println(sb);

	}

}
