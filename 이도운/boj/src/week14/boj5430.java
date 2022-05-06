package week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class boj5430 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			String p = br.readLine();
			int n = Integer.parseInt(br.readLine());
			String ipt = br.readLine();

			Deque<Integer> dq = new ArrayDeque<>();
			if (!ipt.equals("[]")) {
				String[] arr = ipt.substring(1, ipt.length() - 1).split(",");
				for (int j = 0; j < n; j++) {
					dq.add(Integer.parseInt(arr[j]));
				}
			}
			int rev = 0;
			boolean flag = true;
			for (int j = 0; j < p.length(); j++) {
				if (p.charAt(j) == 'R') {
					rev += 1;
				} else {
					if (dq.isEmpty()) {
						flag = false;
						break;
					} else {
						if (rev % 2 == 0) {
							dq.pollFirst();
						} else {
							dq.pollLast();
						}
					}
				}
			}
			if (flag) {
				StringBuilder sb = new StringBuilder();
				sb.append("[");
				int ll = dq.size();
				if (rev % 2 == 0) {
					for (int k = 0; k < ll; k++) {
						sb.append(dq.pollFirst());
						if (k < ll - 1) {
							sb.append(",");
						}
					}
				} else {
					for (int k = 0; k < ll; k++) {
						sb.append(dq.pollLast());
						if (k < ll - 1) {
							sb.append(",");
						}
					}
				}
				sb.append("]");
				System.out.println(sb);
			} else {
				System.out.println("error");
			}

		}

	}

}
