package week08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;

public class boj1966 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());
		for (int t = 0; t < tc; t++) {
			String[] NM = br.readLine().split(" ");
			int N = Integer.parseInt(NM[0]);
			int M = Integer.parseInt(NM[1]);
			Deque<Integer> stack = new ArrayDeque<>();
			String[] ipt = br.readLine().split(" ");
			int[] list = new int[N];

			int tmp;
			for (int i = 0; i < N; i++) {
				tmp = Integer.parseInt(ipt[i]);
				stack.add(tmp);
				list[i] = tmp;
			}
			Arrays.sort(list);
			int maxIdx = list.length - 1;

			int np = 0;
			while (true) {
				if (stack.peekFirst() == list[maxIdx] && M == 0) {
					stack.pollFirst();
					np += 1;
					break;
				} else if (stack.peekFirst() == list[maxIdx]) {
					stack.pollFirst();
					maxIdx -= 1;
					np += 1;
					M -= 1;
				} else {
					stack.addLast(stack.pollFirst());
					M -= 1;
				}
				if (M < 0) {
					M += stack.size();
				}
			}
			System.out.println(np);

		}

	}

}
