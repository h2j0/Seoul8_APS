package week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class boj1927 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int x;
		int out;
		for (int i = 0; i < n; i++) {
			x = Integer.parseInt(br.readLine());
			if (x != 0) {
				pq.add(x);
			} else {
				if (pq.isEmpty()) {
					sb.append("0\n");
				} else {
					out = pq.poll();
					sb.append(out + "\n");
				}
			}
		}
		System.out.println(sb);
	}

}
