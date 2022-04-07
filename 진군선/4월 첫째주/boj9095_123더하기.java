package Apr_1st_Week;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj9095_123더하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < t; tc++) {
			int n = Integer.parseInt(br.readLine());
			// dfs 이용해서 탐색

			// stack을 하나 만든다
			Stack<Integer> stack = new Stack<>();

			int ans = 0;
			stack.add(n);
			while (!stack.isEmpty()) {
				int curr = stack.pop();

				if (curr == 0) {
					ans++;
				}

				if (curr - 1 >= 0) {
					stack.add(curr - 1);
				}
				if (curr - 2 >= 0) {
					stack.add(curr - 2);
				}
				if (curr - 3 >= 0) {
					stack.add(curr - 3);
				}

			}

			sb.append(ans).append("\n");
		}// tc 종료
		System.out.println(sb);
	}
}
