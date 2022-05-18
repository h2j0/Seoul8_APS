package week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class boj11286 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		PriorityQueue<Integer> pq = new PriorityQueue<>(
				(o1, o2)->{
					int a1 = Math.abs(o1);
					int a2 = Math.abs(o2);
					if (a1 == a2) return o1>o2?1:-1;
					return a1-a2;
				}
				);
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine());
			if (x != 0) {
				pq.add(x);
			}else {
				if (pq.isEmpty()) {
					sb.append("0\n");
				}else {
					sb.append(pq.poll()+"\n");					
				}
			}
		}
		System.out.println(sb);
	}

}
